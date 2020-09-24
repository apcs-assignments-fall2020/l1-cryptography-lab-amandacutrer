import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String newMessage = "";
        for (int i = 0; i < message.length() - 1; i++){
            char currentChar = message.charAt(i);
            char iKey = (char)(key.charAt(i) - 65);
            
        if (currentChar >= 'A' && currentChar <= 'Z'){
                newMessage = newMessage + (char)((currentChar - 65 + iKey)%26+65);
        }
        else if (currentChar >= 'a' && currentChar <= 'z'){
                newMessage = newMessage + (char)((currentChar - 97 + iKey)%26+97);
            }
         else{
            newMessage = newMessage + currentChar;
         }
    }
        return newMessage;
    }

    public static String decryptVigenere(String message, String key) {
        String newMessage = "";
        for (int i = 0; i < message.length() - 1; i++){
            char currentChar = message.charAt(i);
            char iKey = (char)(key.charAt(i) - 65);
            if (iKey > 26){
            iKey = (char)(iKey % 26);
        }
   
        if (currentChar >= ('A'+ iKey) && currentChar <= 'Z'){
                newMessage = newMessage + (char)(currentChar - iKey);
        }
        else if (currentChar >= ('a'+ iKey) && currentChar <= 'z'){
                newMessage = newMessage + (char)(currentChar - iKey);
            }
        else if (currentChar >= 'a' && currentChar <= ('a'+ iKey)){
            newMessage = newMessage + (char)((currentChar - 71 - iKey)%26+97);
        }
        else if (currentChar >= 'A' && currentChar <= ('A'+ iKey)){
            newMessage = newMessage + (char)((currentChar - 39 - iKey)%26+65);
        }
         else{
            newMessage = newMessage + currentChar;
         }
        
    }
        return newMessage;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
