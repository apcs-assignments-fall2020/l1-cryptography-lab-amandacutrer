import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
    char ch;
    String newMessage = "";
    for (int i = 0; i < message.length(); i++){ 
        if (message.charAt(i) < 'A' || message.charAt(i) > 'Z'){
            newMessage = newMessage + message.charAt(i);
            continue;
        }
        char newChar = (char)(message.charAt(i) + 3);
        if (newChar > 'Z'){
            ch = (char)((newChar) - 26);
        }
        else {
            ch = (char)(newChar);
        }
        newMessage = newMessage + ch;
    }
        return newMessage;

    }

    public static String decryptCaesar(String message) {
        char ch;
    String newMessage = "";
    for (int i = 0; i < message.length(); i++){
        if (message.charAt(i) < 'A' || message.charAt(i) > 'Z'){
            newMessage = newMessage + message.charAt(i);
            continue;
        }
        else if (message.charAt(i) > 'A' && message.charAt(i) < 'Z'){
            if (message.charAt(i - 3) < 'A'){
            ch = (char)(message.charAt(i) + 23);
        }
        else {
            ch = (char)(message.charAt(i) - 3);
        }
        newMessage = newMessage + ch;
        }
    }
        return newMessage;
    }

    public static String encryptCaesarKey(String message, int key) {
        return message;
        // REPLACE THIS WITH YOUR CODE
    }

    public static String decryptCaesarKey(String message, int key) {
        return message;
        // REPLACE THIS WITH YOUR CODE
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
