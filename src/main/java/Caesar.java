import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
    String newMessage = "";
        for (int i = 0; i < message.length(); i++){
        char currentChar = message.charAt(i);
        if (currentChar >= 'A' && currentChar <= 'Z'){
                newMessage = newMessage + (char)((currentChar - 62)%26+65);
        }
        else if (currentChar >= 'a' && currentChar <= 'z'){
                newMessage = newMessage + (char)((currentChar - 94)%26+97);
            }
         else{
            newMessage = newMessage + currentChar;
         }
        
    }
        return newMessage;
    }

    public static String decryptCaesar(String message) {
     String newMessage = "";
        for (int i = 0; i < message.length(); i++){
        char currentChar = message.charAt(i);
        if (currentChar >= 'D' && currentChar <= 'Z'){
                newMessage = newMessage + (char)(currentChar - 3);
        }
        else if (currentChar >= 'd' && currentChar <= 'z'){
                newMessage = newMessage + (char)(currentChar - 3);
            }
        else if (currentChar >= 'a' && currentChar <= 'c'){
            newMessage = newMessage + (char)((currentChar + - 74)%26+97);
        }
        else if (currentChar >= 'A' && currentChar <= 'C'){
            newMessage = newMessage + (char)((currentChar + - 42)%26+65);
        }
         else{
            newMessage = newMessage + currentChar;
         }
        
    }
        return newMessage;
    }
    

    public static String encryptCaesarKey(String message, int key) {
        String newMessage = "";
        for (int i = 0; i < message.length(); i++){
        char currentChar = message.charAt(i);
        if (currentChar >= 'A' && currentChar <= 'Z'){
                newMessage = newMessage + (char)((currentChar - 65 + key)%26+65);
        }
        else if (currentChar >= 'a' && currentChar <= 'z'){
                newMessage = newMessage + (char)((currentChar - 97 + key)%26+97);
            }
         else{
            newMessage = newMessage + currentChar;
         }
        
    }
        return newMessage;
    }

    public static String decryptCaesarKey(String message, int key) {
        String newMessage = "";
        if (key > 26){
            key = key%26;
        }
        for (int i = 0; i < message.length(); i++){
        char currentChar = message.charAt(i);
        if (currentChar >= ('A'+key) && currentChar <= 'Z'){
                newMessage = newMessage + (char)(currentChar - key);
        }
        else if (currentChar >= ('a'+key) && currentChar <= 'z'){
                newMessage = newMessage + (char)(currentChar - key);
            }
        else if (currentChar >= 'a' && currentChar <= ('a'+ key)){
            newMessage = newMessage + (char)((currentChar - 71 - key)%26+97);
        }
        else if (currentChar >= 'A' && currentChar <= ('A'+ key)){
            newMessage = newMessage + (char)((currentChar - 39 - key)%26+65);
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
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
