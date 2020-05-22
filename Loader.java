package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Loader {
    String mode;
    int key;
    String message;
    String fileNameIn;
    String fileNameOut;
    boolean isOut;
    String algType;

    public Loader() {
        this.mode = "enc";
        this.key = 0;
        this.message = "";
        this.fileNameIn = "";
        this.fileNameOut = "";
        this.isOut = false;
        this.algType = "shift";
    }

    public void load(String[] args) {
        for (int i = 0; i<args.length; i++) {
            if(args[i].isEmpty()) {
                break;
            }
            switch(args[i]) {
                case "-key": {
                    if (!args[i + 1].isEmpty()) {
                        key = Integer.parseInt(args[i + 1]);
                    }
                    break;
                }
                case "-data": {
                    if (!args[i + 1].isEmpty()) {
                        message = args[i + 1];
                    }
                    break;
                }
                case "-mode" : {
                    if (!args[i + 1].isEmpty()) {
                        mode = args[i + 1];
                    }
                    break;
                }
                case "-in" : {
                    if (!args[i + 1].isEmpty()) {
                        fileNameIn = args[i + 1];
                        loadFromFile(fileNameIn);
                    }
                    break;
                }
                case "-out" : {
                    if (!args[i + 1].isEmpty()) {
                        fileNameOut = args[i + 1];
                        isOut = true;
                    }
                    break;
                }
                case "-alg" : {
                    if (!args[i + 1].isEmpty()) {
                        algType = args[i + 1];
                    }
                    break;
                }
                default: {
                    System.out.println("Unknown argument");
                }
            }
        }
    }
    public void modeChoice() {
        switch(mode) {
            case "enc" : {
                Encryptor enc = new Encryptor(message, key);
                if(isOut == true && algType == "shift") {
                    loadToFile(fileNameOut, enc.changeByKeyOnlyLetters());
                }else if(isOut == true && algType == "unicode") {
                    loadToFile(fileNameOut, enc.changeByKeyEverySign());
                }
                else if(algType == "shift")
                {
                    System.out.println(enc.changeByKeyOnlyLetters());
                }
                else {
                    System.out.println(enc.changeByKeyEverySign());
                }
                break;
            }
            case "dec" : {
                Decryptor dec = new Decryptor(message, key);
                if(isOut == true && algType == "shift") {
                    loadToFile(fileNameOut, dec.changeByKeyOnlyLetters());
                } else if(isOut == true && algType == "unicode") {
                    loadToFile(fileNameOut, dec.changeByKeyEverySign());
                }
                else if(algType == "shift")
                {
                    System.out.println(dec.changeByKeyOnlyLetters());
                }
                else {
                    System.out.println(dec.changeByKeyEverySign());
                }
                break;
            }
        }
    }
    public void loadFromFile(String fileName) {
        File file  = new File(fileName);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                message = scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public void loadToFile(String fileName, String result){
        File file = new File(fileName);
        try(PrintWriter writer = new PrintWriter(file)){
                writer.write(result);
        } catch (IOException e) {
                System.out.println("An exception occurs");
        }
    }

}
