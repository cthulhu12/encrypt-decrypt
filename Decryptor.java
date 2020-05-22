package encryptdecrypt;

public class Decryptor {
    private String message;
    private int key;
    Decryptor(String message) {
        this.message = message;
    }
    Decryptor(String message, int key) {
        this.message = message;
        this.key = key;
    }
    public boolean isLowerLetter(char ch) {
        if(ch >= 97 && ch <= 122 ) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isUpperLetter(char ch) {
        if(ch >= 65 && ch <= 90 ) {
            return true;
        } else {
            return false;
        }
    }
    public char[] strToChar(String message) {
        char[] charArray = new char[message.length()];
        charArray = message.toCharArray();
        return charArray;
    }
    public String changeByKeyEverySign() {
        char[] array = strToChar(this.message);
        for(int i = 0; i < array.length; i++ ) {
                array[i] = (char)(array[i] - this.key);
        }
        String newMessage = new String(array);
        return newMessage;
    }

    public String changeByKeyOnlyLetters(){
        char[] array = strToChar(this.message);
        for(int i = 0; i < array.length; i++ ) {
            if (isLowerLetter((char) (array[i])) && isLowerLetter((char) (array[i] - key))) {
                array[i] = (char) (array[i] - key);
            } else if(isUpperLetter((char) (array[i])) && isUpperLetter((char) (array[i] - key))) {
                array[i] = (char) (array[i] - key);
            }else if(isLowerLetter(array[i]) == false && isUpperLetter(array[i]) == false) {
                continue;
            } else if(isLowerLetter(array[i]) == true && isUpperLetter(array[i]) == false) {
                int toAdd = 122 + (array[i] - key - 96);
                array[i] = (char)toAdd;
            } else {
                int toAdd = 90 + (array[i] - key - 64);
                array[i] = (char)toAdd;
            }
        }
        String newMessage = new String(array);
        return newMessage;
    }
}
