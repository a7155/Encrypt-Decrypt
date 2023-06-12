
import java.util.Scanner;


/**
 *
 * @author 4715
 */
public class AtbashCipher {
        private static final char[] lookupTable = new char[26];

    static {

        for (int i = 0; i < 26; i++) {
            lookupTable[i] = (char) ('Z' - i);
        }
    }

    public String Encrypt(String message){

        char[] letters = message.toCharArray();
        String cipher = "";

        for (char a:
                letters) {
            if(Character.isLetter(a)){
                int pos = Character.toUpperCase(a) - 'A';
                char encryptedChar = (char) ('Z'-pos);
                cipher+=encryptedChar;
            }
            else{
                cipher+=a;
            }
        }

        return cipher;
    }
    public String Decrypt(String cipher){

        char[] letters = cipher.toCharArray();
        String message = "";

        for (char a:
                letters) {
            if(Character.isLetter(a)){
                int pos = 'Z' - Character.toUpperCase(a);
                char decryptedChar = (char) ('A' + pos);
                message+=decryptedChar;
            }
            else{
                message+=a;
            }
        }

        return message;
    }
    public static void main(String[] args) {

        AtbashCipher c = new AtbashCipher();
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan pesan menggunakan hurup kapital: ");
        String Message = input.next();
        String encrypted= c.Encrypt(Message);
        System.out.println("Encrypted --> "+ encrypted);

        String decrypted = c.Decrypt(encrypted);
        System.out.println("Decrypted --> "+ decrypted);




    }
}
