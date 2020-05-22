package encryptdecrypt;

public class Encryptor {
    private String message;
    private int key;

    Encryptor(String message, int key){
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
    public char[] strToChar(String message){
        char[] charArray = new char[message.length()];
        charArray = message.toCharArray();
        return charArray;
    }
    // metods from previous stages
    /*public String chanageMessageOtherEnd() {
        char[] array = strToChar(this.message);
        for(int i = 0; i < array.length; i++) {
            array[i] = changeOtherEndOfAlphabet(array[i]);
        }
        String newMessage = new String(array);
        return newMessage;
    }
    public char changeOtherEndOfAlphabet(char ch){
        if(isLowerLetter(ch)) {
            int middle = (122 - 97) / 2;
            if (ch > middle) {
                return (char) (97 + (122 - ch));
            } else {
                return (char) (122 - (97 + ch));
            }
        } else {
            return ch;
        }
    }*/
    public String changeByKeyOnlyLetters(){
        char[] array = strToChar(this.message);
        for(int i = 0; i < array.length; i++ ) {
            if(isLowerLetter((char)(array[i] + key)) || isUpperLetter((char)(array[i] + key)) ) {
                array[i] = (char)(array[i] + key);
            } else if(isLowerLetter(array[i]) == false && isUpperLetter(array[i]) == false ) {
                continue;
            } else if(isLowerLetter(array[i]) == true && isUpperLetter(array[i]) == false ) {
                int toAdd = 96 + (array[i] + key - 122);
                array[i] = (char)toAdd;
            } else {
                int toAdd = 66 + (array[i] + key - 90);
                array[i] = (char)toAdd;
            }
        }
        String newMessage = new String(array);
        return newMessage;
    }

    public String changeByKeyEverySign(){
        char[] array = strToChar(this.message);
        for(int i = 0; i < array.length; i++ ) {
            array[i] = (char)(array[i] + key);
        }
        String newMessage = new String(array);
        return newMessage;
    }
}
