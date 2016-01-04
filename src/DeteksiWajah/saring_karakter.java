package DeteksiWajah;

import javax.swing.text.*;
class saring_karakter {
public saring_karakter() {
}


public PlainDocument angkaSaja() {
    PlainDocument filterDigit = new PlainDocument() {
            @Override
        public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
                StringBuffer buffer = new StringBuffer();
                int s = 0;
                char[] dataInput = str.toCharArray();
                // Memeriksa semua data yang dimasukkan
                for (int i = 0; i < dataInput.length; i++) {
                // Menyaring Apakah data masukkan berupa DIGIT ??
                boolean isOnlyDigit = Character.isLetter(dataInput[i]);
                if (isOnlyDigit == false) {
                dataInput[s] = dataInput[i];
                s++;
                }
                }
                buffer.append(dataInput, 0, s);
                super.insertString(offs, new String(buffer), a);
        }
    };
    return filterDigit;
}


public PlainDocument hurufSaja() {
    PlainDocument filterLetter = new PlainDocument() {
            @Override
        public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
                StringBuffer buffer = new StringBuffer();
                int s = 0;
                char[] dataInput = str.toCharArray();
                // Memeriksa semua data yang dimasukkan
                for (int i = 0; i < dataInput.length; i++) {
                // Menyaring Apakah data masukkan berupa LETTER ??
                boolean isOnlyLetter = Character.isDigit(dataInput[i]);

                if (isOnlyLetter == false) {
                dataInput[s] = dataInput[i];
                s++;
                }
                }
                buffer.append(dataInput, 0, s);
                super.insertString(offs, new String(buffer), a);
        }
    };
    return filterLetter;
}

public PlainDocument tidakHurufAngka(){
    PlainDocument saring = new PlainDocument(){
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
                StringBuffer buffer = new StringBuffer();
                int s = 0;
                char[] dataInput = str.toCharArray();
                // Memeriksa semua data yang dimasukkan
                for (int i = 0; i < dataInput.length; i++) {
                // Menyaring Apakah data masukkan berupa LETTER ??
                boolean isOnlyLetter = Character.isLetterOrDigit(dataInput[i]);
                if (isOnlyLetter == false) {
                dataInput[s] = dataInput[i];
                s++;
                }
                }
                buffer.append(dataInput, 0, s);
                super.insertString(offs, new String(buffer), a);
        }
    };
    return saring;
}

public PlainDocument hurufBesar() {
    PlainDocument filterUpper = new PlainDocument() {
            @Override
        public void insertString(int offs, String str, AttributeSet a) throws
        BadLocationException {
        char[] upper = str.toCharArray();
        for (int i = 0; i < upper.length; i++) {
        // Menjadi upper case
        upper[i] = Character.toUpperCase(upper[i]);
        }
        super.insertString(offs, new String(upper), a);
        }
        };
    return filterUpper;
    }

}