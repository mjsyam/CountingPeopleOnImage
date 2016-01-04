/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeteksiWajah;

/**
 *
 * @author Syem
 */
public class TepiWajah {
    public static int[][] tepiWajah(int[][] statusKulit){
        int tepiMinX = statusKulit[0].length;
        int tepiMaxX = 0;
        int tepiMinY = statusKulit.length;
        int tepiMaxY = 0;
        
        int[][] filter = new int[statusKulit.length][statusKulit[0].length];
        //System.out.println("I   J   TepiMinX    TepiMaxX    TepiMinY    TepiMaxY");
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < filter[0].length; j++) {
                filter[i][j] = 0;                
                if(statusKulit[i][j] == 1){
                    if(i > tepiMaxX){
                        tepiMaxX = i;                        
                    }
                    if(i < tepiMinX){
                        tepiMinX = i;
                    }
                    if(j > tepiMaxY){
                        tepiMaxY = j;
                    }
                    if(j < tepiMinY){
                        tepiMinY = j;
                    }
                    //System.out.print(i+"    "+j+"    "+tepiMinX+"            "+tepiMaxX+"            "+tepiMinY+"            "+tepiMaxY+"\n");
                }
            }
        }
        //System.out.println("I   J   TepiMinX    TepiMaxX    TepiMinY    TepiMaxY");
        for (int i = tepiMinX; i < tepiMaxX; i++) {
            filter[i][tepiMinY] = 1;
            filter[i][tepiMaxY] = 1;
        }
        for (int i = tepiMinY; i < tepiMaxY; i++) {
            filter[tepiMinX][i] = 1;
            filter[tepiMaxX][i] = 1;
        }
        
        return filter;
    }
}
