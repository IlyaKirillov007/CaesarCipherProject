import java.util.Scanner;

public class CaesarCipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String message, int shiftKey) {
        message = message.toLowerCase();
        String cipherText = "";
        for (int ii = 0; ii < message.length(); ii++) {
            int charPosition = ALPHABET.indexOf(message.charAt(ii));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String message = "";
        for (int ii = 0; ii < cipherText.length(); ii++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(ii));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            message += replaceVal;
        }
        return message;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("\nChoose the desirable operation. \nFor encryption press 1. \nFor decryption press 2.");
        int choice = console.nextInt();

        if (choice == 1) {
            String message = new String();
            int key = 0;
            System.out.print("Enter the String for Encryption:");
            message = console.next();

            System.out.println("\n\nEnter Shift Key:");
            key = console.nextInt();
            System.out.println("\nEncrpyted msg:" + encrypt(message, key));
        }
        else if (choice == 2) {
            String message = new String();
            int key = 0;
            System.out.print("Enter the String for Decryption:");
            message = console.next();

            System.out.println("\n\nEnter Shift Key:");
            key = console.nextInt();

            System.out.println("\nDecrypted Message:" + decrypt(message, key));
        }
    }
}

