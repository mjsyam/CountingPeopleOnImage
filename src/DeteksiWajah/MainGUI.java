/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainGUI.java
 *
 * Created on Sep 27, 2012, 7:30:22 PM
 */
package DeteksiWajah;

import Morphologi.CariPerimeter;
import Morphologi.Dilation;
import Morphologi.Erosion;
import Morphologi.LabelImage;
import Morphologi2.DeteksiBoundary;
import ResizeImageInJlabel.ResizeImageInJlabel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Syem
 */
public class MainGUI extends javax.swing.JFrame {

    private JFileChooser jfc;
    private String namaFile = "", pathFile = "";
    private File f;
    ResizeImageInJlabel reSize = new ResizeImageInJlabel();
    private BufferedImage imageInput;
    private BufferedImage imageResult;
    private WritableRaster rasterInput;
    private WritableRaster rasterResult;
    private int[][] dataSE = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };

    public MainGUI() throws IOException {
        initComponents();
        jfc = new JFileChooser();
        //setSize(1250, 710);
        setLocationRelativeTo(this);
        final ImageIcon gambar = new ImageIcon(getClass().getResource("Header.jpg"));
        BufferedImage image = EfekGambar.getEfekKaca(gambar.getImage());
        jLabel5.setIcon(new ImageIcon(image));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        pilihFoto = new javax.swing.JButton();
        deteksiOrang = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        deteksiKulit = new javax.swing.JButton();
        PreviewFoto = new javax.swing.JPanel();
        labelLoadImage = new javax.swing.JLabel();
        DataHasilDeteksi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextJumlahWajah = new javax.swing.JTextField();
        TextWaktuProses = new javax.swing.JTextField();
        TextUkuranFoto = new javax.swing.JTextField();
        TextJumlahObjek = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PreviewHasilDeteksi = new javax.swing.JPanel();
        labelShowResult = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pilihFoto.setText("Pilih Foto ");
        pilihFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihFotoActionPerformed(evt);
            }
        });
        Menu.add(pilihFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        deteksiOrang.setText("Deteksi Orang");
        deteksiOrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deteksiOrangActionPerformed(evt);
            }
        });
        Menu.add(deteksiOrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 120, -1));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        Menu.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 80, -1));

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        Menu.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 80, -1));

        deteksiKulit.setText("Deteksi Kulit");
        deteksiKulit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deteksiKulitActionPerformed(evt);
            }
        });
        Menu.add(deteksiKulit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, -1));

        PreviewFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Load Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        PreviewFoto.setMaximumSize(new java.awt.Dimension(500, 500));
        PreviewFoto.setPreferredSize(new java.awt.Dimension(400, 400));
        PreviewFoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLoadImage.setText("Foto Awal");
        labelLoadImage.setMaximumSize(new java.awt.Dimension(40, 20));
        PreviewFoto.add(labelLoadImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 480, 400));

        DataHasilDeteksi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Hasil Deteksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Jumlah Wajah dalam Foto : ");

        jLabel3.setText("Waktu Proses Perhitungan :");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ukuran Foto :");

        TextJumlahObjek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextJumlahObjekActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Jumlah Objek Terdeteksi Kulit : ");

        javax.swing.GroupLayout DataHasilDeteksiLayout = new javax.swing.GroupLayout(DataHasilDeteksi);
        DataHasilDeteksi.setLayout(DataHasilDeteksiLayout);
        DataHasilDeteksiLayout.setHorizontalGroup(
            DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextJumlahWajah, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DataHasilDeteksiLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextJumlahObjek, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(18, 18, 18)
                .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextUkuranFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextWaktuProses, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        DataHasilDeteksiLayout.setVerticalGroup(
            DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                        .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextJumlahObjek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(TextJumlahWajah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))))
                    .addGroup(DataHasilDeteksiLayout.createSequentialGroup()
                        .addComponent(TextWaktuProses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(DataHasilDeteksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextUkuranFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PreviewHasilDeteksi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasil Deteksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        PreviewHasilDeteksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelShowResult.setText("Foto Hasil Deteksi");
        PreviewHasilDeteksi.add(labelShowResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 460, 390));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setMaximumSize(new java.awt.Dimension(2000, 1000));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PreviewFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PreviewHasilDeteksi, 0, 0, Short.MAX_VALUE)
                            .addComponent(DataHasilDeteksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreviewHasilDeteksi, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addComponent(PreviewFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DataHasilDeteksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihFotoActionPerformed
        // TODO add your handling code here:
        setLoadImageRGB();
        labelLoadImage.setText("");
        try {
            imageInput = ImageIO.read(f);

            TextUkuranFoto.setText(Integer.toString(imageInput.getWidth()) + " X " + Integer.toString(imageInput.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pilihFotoActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        if (namaFile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Foto Belum diLoad");
        }
        labelLoadImage.setIcon(null);
        labelShowResult.setIcon(null);
        TextJumlahObjek.setText("");
        TextJumlahWajah.setText("");
        TextUkuranFoto.setText("");
        TextWaktuProses.setText("");
        namaFile = "";
        pathFile = "";

    }//GEN-LAST:event_resetActionPerformed

    private void deteksiKulitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deteksiKulitActionPerformed
        if (namaFile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Foto Belum diLoad");
        } else {
            try {
                // TODO add your handling code here:
                deteksiKulit();
            } catch (IOException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_deteksiKulitActionPerformed

    private void deteksiOrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deteksiOrangActionPerformed
        if (namaFile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Foto Belum diLoad");
        } else {
            try {
                labelLoadImage.setText("");
                deteksiOrang();
            } catch (IOException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deteksiOrangActionPerformed

    private void TextJumlahObjekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextJumlahObjekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextJumlahObjekActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataHasilDeteksi;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel PreviewFoto;
    private javax.swing.JPanel PreviewHasilDeteksi;
    private javax.swing.JTextField TextJumlahObjek;
    private javax.swing.JTextField TextJumlahWajah;
    private javax.swing.JTextField TextUkuranFoto;
    private javax.swing.JTextField TextWaktuProses;
    private javax.swing.JButton deteksiKulit;
    private javax.swing.JButton deteksiOrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton keluar;
    private javax.swing.JLabel labelLoadImage;
    private javax.swing.JLabel labelShowResult;
    private javax.swing.JButton pilihFoto;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables

    public void tampilImageAsli(String path) {
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Image File", "jpg", "jpeg", "JPG", "JPEG", "PNG", "png");

        jfc.addChoosableFileFilter(fnef);
        jfc.setCurrentDirectory(new File(path));

        int ret = jfc.showOpenDialog(MainGUI.this);

        if (ret == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            BufferedImage img = reSize.loadImage(f.getAbsolutePath());
            ImageIcon imageIcon = new ImageIcon(reSize.reSize(img, labelLoadImage.getWidth(), labelLoadImage.getHeight()));
            labelLoadImage.setIcon(imageIcon);
            namaFile = f.getName();
            pathFile = f.getAbsolutePath();

        }
    }

    // Load image RGB asli
    public void setLoadImageRGB() {
        tampilImageAsli("d:/");
    }

    public void saveFile() {
        int returnVal = jfc.showSaveDialog(MainGUI.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();

        }
    }

    // Hasil Pengolahan
    public void tampilImageHasilOlahan(String path) {
        // Resize Image Sesuai ukuran Label
        BufferedImage img = reSize.loadImage(path);
        ImageIcon imageIcon = new ImageIcon(reSize.reSize(img, labelShowResult.getWidth(), labelShowResult.getHeight()));
        labelShowResult.setIcon(imageIcon);
    }

    //deteksi Kulit
    public void deteksiKulit() throws IOException {

        imageInput = ImageIO.read(f);
        rasterInput = imageInput.getRaster();
        imageResult = new BufferedImage(imageInput.getWidth(), imageInput.getHeight(), BufferedImage.TYPE_INT_RGB);
        rasterResult = imageResult.getRaster();

        int[][] kulit = DeteksiKulit.deteksiKulit(imageInput);
        // proses menghilangkan noise area pada citra
        int[][] kulit2 = RemoveNoise.removeNoise(kulit);
        //proses erosion
        Erosion imageErosion = new Erosion(kulit2);
        Erosion seErosion = new Erosion(dataSE);
        Erosion resultImageErosion = new Erosion(imageErosion.erosionProses(seErosion));
        int[][] resultIE = resultImageErosion.Pixel;

//        Erosion imageErosion2 = new Erosion(resultIE);
//        Erosion seErosion2 = new Erosion(dataSE);
//        Erosion resultImageErosion2 = new Erosion(imageErosion2.erosionProses(seErosion));
//        int[][] resultIE2 = resultImageErosion2.Pixel;
//
//
//        Dilation tesImage = new Dilation(resultIE2);
//        Dilation structureElement = new Dilation(dataSE);
//        Dilation resultImage = new Dilation(tesImage.dilationProses(structureElement));
//        int[][] resultID = resultImage.Pixel;

//        Dilation tesImage2 = new Dilation(resultID);
//        Dilation structureElement2 = new Dilation(dataSE);
//        Dilation resultImage2 = new Dilation(tesImage2.dilationProses(structureElement2));
//        int[][] resultID2 = resultImage2.Pixel;


        for (int i = 0; i < resultIE.length; i++) {
            for (int j = 0; j < resultIE[0].length; j++) {
                if (resultIE[i][j] == 1) {
                    rasterResult.setSample(i, j, 0, rasterInput.getSample(i, j, 0));
                    rasterResult.setSample(i, j, 1, rasterInput.getSample(i, j, 1));
                    rasterResult.setSample(i, j, 2, rasterInput.getSample(i, j, 2));
                }
            }
        }
        ImageIO.write(imageResult, "JPG", new File("E:/LabTesis/DataHasilUji" + namaFile));
        tampilImageHasilOlahan("E:/LabTesis/DataHasilUji" + namaFile);
    }

    //Hitung Jumlah Orang
    public void deteksiOrang() throws IOException {

        imageInput = ImageIO.read(f);
        rasterInput = imageInput.getRaster();
        imageResult = new BufferedImage(imageInput.getWidth(), imageInput.getHeight(), BufferedImage.TYPE_INT_RGB);
        rasterResult = imageResult.getRaster();
        long start = System.currentTimeMillis();
        int[][] kulit = DeteksiKulit.deteksiKulit(imageInput);
        // proses menghilangkan noise area pada citra
        int[][] kulit2 = RemoveNoise.removeNoise(kulit);
        //proses erosion
        Erosion imageErosion = new Erosion(kulit2);
        Erosion seErosion = new Erosion(dataSE);
        Erosion resultImageErosion = new Erosion(imageErosion.erosionProses(seErosion));
        int[][] resultIE = resultImageErosion.Pixel;

        // tampung image yang sudah di-Label dan status labelnya
        ArrayList list = LabelImage.labelImage(resultIE);

        //perhitungan area setiap wilayah label
        ArrayList listArea = area(list);
        ArrayList<int[]> arrayListArea = (ArrayList<int[]>) listArea.get(1);
        int[] arrayArea = listToArray(arrayListArea);

        //Perhitungan perimeter setiap wilayah label
        ArrayList listPerimeter = perimeter(list);
        ArrayList<int[]> arrayListPerimeter = (ArrayList<int[]>) listPerimeter.get(1);
        int[] arrayPerimeter = listToArray(arrayListPerimeter);

        //Mendapatkan lebar dan tinggi setiap wilayah label
        ArrayList lebarTinggiList = lebarTinggiRegion(list);
        ArrayList<int[]> arrayListIndexLebel = (ArrayList<int[]>) lebarTinggiList.get(0);
        ArrayList<int[]> arrayListValueLebar = (ArrayList<int[]>) lebarTinggiList.get(1);
        ArrayList<int[]> arrayListValueTinggi = (ArrayList<int[]>) lebarTinggiList.get(2);
        int[] arrayIndexLabel = listToArray(arrayListIndexLebel);
        int[] arrayLebar = listToArray(arrayListValueLebar);
        int[] arrayTiggi = listToArray(arrayListValueTinggi);
        System.out.println("Label   Luas   Perimeter    Lebar   Tinggi");
        //System.out.println(arrayIndexLabel.length);
        for (int i = 0; i < arrayIndexLabel.length; i++) {
            System.out.println(arrayIndexLabel[i] + ".       " + arrayArea[i] + "       " + arrayPerimeter[i] + "       " + arrayLebar[i] + "       " + arrayTiggi[i]);
        }
        System.out.println();

// Perhitungan/proses secara ke-seluruhan 
        //Tampung pixel yang sudah dilabel
        int[][] imageLabeling = (int[][]) list.get(0);

        ArrayList<int[]> arrayList = new ArrayList();
        arrayList = (ArrayList<int[]>) list.get(1);
        //printArray(imageLabeling);
        // Tampung nilai dari label
        int[] array = listToArray(arrayList);
        int label = 1;

        // Tampung sementara pixel yang sudah dilabel satu persatu
        int[][] tampLabel = new int[imageInput.getWidth()][imageInput.getHeight()];
        // Tampung sementara pixel yang sudah diBounding Box satu persatu
        int[][] boundingBox2 = new int[imageInput.getWidth()][imageInput.getHeight()];
        // Tampung sementara semua pixel yang sudah diBounding Box
        int[][] tampBoundingBox = new int[imageInput.getWidth()][imageInput.getHeight()];
        int jumlahWajah = 0;
        int indexLabel = 0;
        while (label <= array.length) {
            if ((arrayArea[indexLabel] > 300) && (arrayArea[indexLabel] < 1000)) {
                float lebar = arrayLebar[indexLabel];
                float tinggi = arrayTiggi[indexLabel];
                float perbandinganLebarTinggi = lebar / tinggi;
                float luas = arrayArea[indexLabel];
                float perimeter = arrayPerimeter[indexLabel];
                float circularity = (float) ((4 * 3.14 * luas) / (perimeter * perimeter));
               // System.out.println(label + "    " + arrayArea[indexLabel] + "       " + lebar + "     " + tinggi + "    " + perbandinganLebarTinggi + "      " + circularity);
                if ((circularity > 0.254) && (circularity < 1) || ((perbandinganLebarTinggi > 0.4) && (perbandinganLebarTinggi < 1))) {
                    System.out.println(label + "    " + arrayArea[indexLabel] + "       " + lebar + "     " + tinggi + "    " + perbandinganLebarTinggi + "      " + circularity);
                    jumlahWajah++;
                    for (int j = 0; j < imageLabeling.length; j++) {
                        for (int k = 0; k < imageLabeling[0].length; k++) {
                            if (imageLabeling[j][k] == label) {
                                tampLabel[j][k] = 250;
                            }
                        }
                    }
                    // Tampung bounding box dari setaip label
                    boundingBox2 = boundingBox(tampLabel);
                    //printArray(boundingBox2);

                    for (int j = 0; j < imageLabeling.length; j++) {
                        for (int k = 0; k < imageLabeling[0].length; k++) {
                            if (boundingBox2[j][k] == 1) {
                                // simpan nilai Bounding Box ke penampung sementara
                                tampBoundingBox[j][k] = 1;
                                // set nilai Bounding Box menjadi 0 untuk diolah kembali secara satu persatu
                                boundingBox2[j][k] = 0;
                            }
                            if (tampLabel[j][k] == 250) {
                                // set nilai tampLabel menjadi 0 untuk diolah kembali secara satu persatu
                                tampLabel[j][k] = 0;
                            }
                        }
                    }
                }
            }

            label++;
            indexLabel++;
        }
        //System.out.println("Jumlah Objek dalam citra: " + jumlahWajah);
        long end = System.currentTimeMillis();
        float waktuEksekusi = (float) ((end - start) / 1000.00);
        TextWaktuProses.setText(Float.toString(waktuEksekusi) + " detik");
        TextJumlahWajah.setText(Integer.toString(jumlahWajah) + " Orang");
        TextJumlahObjek.setText(Integer.toString(label) + " Objek");
        // Proses memasukktan nilai pixel ke image hasil(filterisasi)
        for (int i = 0; i < imageLabeling.length; i++) {
            for (int j = 0; j < imageLabeling[0].length; j++) {
                if (tampBoundingBox[i][j] == 1) {
                    rasterResult.setSample(i, j, 0, 255);
                    rasterResult.setSample(i, j, 1, 0);
                    rasterResult.setSample(i, j, 2, 0);
                } else {
                    rasterResult.setSample(i, j, 0, rasterInput.getSample(i, j, 0));
                    rasterResult.setSample(i, j, 1, rasterInput.getSample(i, j, 1));
                    rasterResult.setSample(i, j, 2, rasterInput.getSample(i, j, 2));
                }
            }
        }


        ImageIO.write(imageResult, "JPG", new File("E:LabTesis/DataHasilUji" + namaFile));
        tampilImageHasilOlahan("E:LabTesis/DataHasilUji" + namaFile);
    }

    // Konversi dari tipe buffer ke array
    public static int[][] bufferToArray(BufferedImage image) {
        int[][] data = new int[image.getWidth()][image.getHeight()];
        WritableRaster raster = image.getRaster();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                data[i][j] = raster.getSample(i, j, 0);
            }
        }
        return data;
    }
    // Konversi dari tipe array ke buffer

    public static BufferedImage arrayToBuffer(int[][] image) {
        BufferedImage image1 = new BufferedImage(image.length, image[0].length, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image1.getRaster();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                raster.setSample(i, j, 0, image[i][j]);
            }
        }
        return image1;
    }
    // Konversi dari tipe list ke array

    public static int[] listToArray(ArrayList<int[]> arrayList) {
        int[] data = new int[arrayList.size()];

        for (int j = 0; j < data.length; j++) {
            Object b = arrayList.get(j);
            String c = b.toString();
            int d = Integer.parseInt(c);
            data[j] = d;
        }

        return data;
    }
    // cetak nilai array untuk analisis hasil

    public static void printArray(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
    // mendapatkan nilai bounding box[(minX, minY), (maxY, minY), (minX, maxY), (maxX, maxY)]

    public static int[][] boundingBox(int[][] statusLabeled) {
        int tepiMinX = statusLabeled[0].length;
        int tepiMaxX = 0;
        int tepiMinY = statusLabeled.length;
        int tepiMaxY = 0;
        //System.out.println("I   J   TepiMinX    TepiMaxX    TepiMinY    TepiMaxY");
        int[][] filter = new int[statusLabeled.length][statusLabeled[0].length];
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < filter[0].length; j++) {
                filter[i][j] = 0;
                if (statusLabeled[i][j] == 250) {
                    if (i > tepiMaxX) {
                        tepiMaxX = i;
                    }
                    if (i < tepiMinX) {
                        tepiMinX = i;
                    }
                    if (j > tepiMaxY) {
                        tepiMaxY = j;
                    }
                    if (j < tepiMinY) {
                        tepiMinY = j;
                    }
                    //System.out.print(i+"    "+j+"    "+tepiMinX+"            "+tepiMaxX+"            "+tepiMinY+"            "+tepiMaxY+"\n"); 
                }
            }
        }
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

    // mendapatkan lebar dan tiggi tiap-tiap wilayah label 
    public static ArrayList lebarTinggiRegion(ArrayList imageLabel) {
        ArrayList tinggiValue = new ArrayList();
        ArrayList lebarValue = new ArrayList();
        ArrayList labelIndex = new ArrayList();

        // Tampung pixel yang sudah dilabel
        int[][] imageLabeling = (int[][]) imageLabel.get(0);

        ArrayList<int[]> arrayList = (ArrayList<int[]>) imageLabel.get(1);

        // Tampung nilai dari label
        int[] array = listToArray(arrayList);
        int c = 1;

        // Tampung sementara pixel yang sudah dilabel satu persatu
        int[][] statusLabeled = new int[imageLabeling.length][imageLabeling[0].length];
        // Tiggi dari masing-masing region


        while (c <= array.length) {
            for (int j = 0; j < imageLabeling.length; j++) {
                for (int k = 0; k < imageLabeling[0].length; k++) {
                    if (imageLabeling[j][k] == c) {
                        statusLabeled[j][k] = 250;
                    }
                }
            }

            int tepiMinX = statusLabeled[0].length;
            int tepiMaxX = 0;
            int tepiMinY = statusLabeled.length;
            int tepiMaxY = 0;
            for (int i = 0; i < statusLabeled.length; i++) {
                for (int j = 0; j < statusLabeled[0].length; j++) {
                    if (statusLabeled[i][j] == 250) {
                        if (i > tepiMaxX) {
                            tepiMaxX = i;
                        }
                        if (i < tepiMinX) {
                            tepiMinX = i;
                        }
                        if (j > tepiMaxY) {
                            tepiMaxY = j;
                        }
                        if (j < tepiMinY) {
                            tepiMinY = j;
                        }
                    }
                }
            }

            for (int i = 0; i < statusLabeled.length; i++) {
                for (int j = 0; j < statusLabeled[0].length; j++) {
                    if (statusLabeled[i][j] == 250) {
                        statusLabeled[i][j] = 0;
                    }
                }
            }

            int lebarRegion = (int) Math.sqrt((Math.pow((tepiMaxX - tepiMinX), 2)) + (Math.pow((tepiMinY - tepiMinY), 2)));
            int tinggiRegion = (int) Math.sqrt((Math.pow((tepiMinX - tepiMinX), 2)) + (Math.pow((tepiMaxY - tepiMinY), 2)));

            labelIndex.add(c);
            lebarValue.add(lebarRegion);
            tinggiValue.add(tinggiRegion);
            c++;
        }
        ArrayList listLebarTinggi = new ArrayList();
        listLebarTinggi.add(labelIndex);
        listLebarTinggi.add(lebarValue);
        listLebarTinggi.add(tinggiValue);

        return listLebarTinggi;

    }

    // Luas Masing2 wilayah label
    public static ArrayList area(ArrayList imageLabel) {

        ArrayList areaValue = new ArrayList();
        ArrayList labelIndex = new ArrayList();

        // Tampung pixel yang sudah dilabel
        int[][] imageLabeling = (int[][]) imageLabel.get(0);

        ArrayList<int[]> arrayList = (ArrayList<int[]>) imageLabel.get(1);

        // Tampung nilai dari label
        int[] array = listToArray(arrayList);
        int c = 1;

        // Tampung sementara pixel yang sudah dilabel satu persatu
        int[][] tampLabel = new int[imageLabeling.length][imageLabeling[0].length];

        int area = 1;
        while (c <= array.length) {
            for (int j = 0; j < imageLabeling.length; j++) {
                for (int k = 0; k < imageLabeling[0].length; k++) {
                    if (imageLabeling[j][k] == c) {
                        area++;
                    }
                }
            }

            // Tampung area dari setaip label
            areaValue.add(area);
            labelIndex.add(c);
            area = 0;
            c++;
        }
        ArrayList listArea = new ArrayList();
        listArea.add(labelIndex);
        listArea.add(areaValue);
        return listArea;
    }

    // Perimeter Masing2 wilayah label
    public static ArrayList perimeter(ArrayList imageLabel) {
        int[][] dataSE = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        ArrayList perimeterValue = new ArrayList();
        ArrayList labelIndex = new ArrayList();

        // Tampung pixel yang sudah dilabel
        int[][] imageLabeling = (int[][]) imageLabel.get(0);

        ArrayList<int[]> arrayList = (ArrayList<int[]>) imageLabel.get(1);

        // Tampung nilai dari label
        int[] array = listToArray(arrayList);
        int c = 1;

        // Tampung sementara pixel yang sudah dilabel satu persatu
        int[][] tampLabel = new int[imageLabeling.length][imageLabeling[0].length];

        int perimeter = 1;
        while (c <= array.length) {
            for (int j = 0; j < imageLabeling.length; j++) {
                for (int k = 0; k < imageLabeling[0].length; k++) {
                    if (imageLabeling[j][k] == c) {
                        tampLabel[j][k] = 1;
                    }
                }
            }
            DeteksiBoundary db = new DeteksiBoundary(tampLabel);
            DeteksiBoundary SE = new DeteksiBoundary(dataSE);
            DeteksiBoundary hasilBounday = new DeteksiBoundary(db.boundary(SE));

            for (int m = 0; m < hasilBounday.Pixels.length; m++) {
                for (int n = 0; n < hasilBounday.Pixels[0].length; n++) {
                    if (hasilBounday.Pixels[m][n] == 1) {
                        perimeter++;
                    }
                }
            }

            for (int i = 0; i < tampLabel.length; i++) {
                for (int j = 0; j < tampLabel[0].length; j++) {
                    if (tampLabel[i][j] == 1) {
                        tampLabel[i][j] = 0;
                    }
                }
            }

            // Tampung area dari setaip label

            perimeterValue.add(perimeter);
            labelIndex.add(c);
            perimeter = 0;
            c++;
        }
        ArrayList listPerimeter = new ArrayList();
        listPerimeter.add(labelIndex);
        listPerimeter.add(perimeterValue);
        return listPerimeter;
    }
}
