/**
 *
 * @author 4715
 */
import java.util.Scanner;
public class CaesarCipher {
    
   private String text, cipher, decipher;
    private int shift;

    public void setText(String text) {
        this.text = text;
    }
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }
    public void setDecipher(String decipher) {
        this.decipher = decipher;
    }
    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getText() {
        return text;
    }
    public String getCipher() {
        return cipher;
    }
    public String getDecipher() {
        return decipher;
    }
    public int getShift() {
        return shift;
    }

    public String encrypt(String text, int key) {
        String cipher = "";
        for(int i=0; i<text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                cipher += Character.toString(((text.charAt(i) + key -65) % 26 + 65));
            }else {
                cipher += Character.toString(((text.charAt(i) + key -97) % 26 + 97));
            }
        }
        return cipher;
    }

    public String decrypt(String text, int key) {
        String decipher = "";
        for(int i=0; i<text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                decipher += Character.toString((text.charAt(i) - key) < 65 ? (text.charAt(i) - key)+26 : (text.charAt(i) - key));
            }else {
                decipher += Character.toString((text.charAt(i) - key) < 97 ? (text.charAt(i) - key)+26 : (text.charAt(i) - key));
            }
        }
        return decipher;
    }

    public void showResult(String encOrDec) {
        System.out.println("\nPlain Text : " + getText() + "\nShift or Key : " + getShift());
        System.out.println(encOrDec + " Text : " + (encOrDec.equals("Encrypted") ? getCipher() : getDecipher()));
    }
    
    public static void main(String[] args) {
        CaesarCipher obj = new CaesarCipher();
        System.out.print("Choose a method below :\n1. Encrypt Text\n2. Decrypt Text\n\nEnter your choice : ");
        Scanner input = new Scanner(System.in);
        char choice = input.next().charAt(0);
        while((choice < '1' || choice > '2')){  // Validating input 
            System.out.println("Invalid input. Try again");
            choice = input.next().charAt(0);
        }

        if(choice == '1') {
            System.out.println("Enter your text to encrypt : ");
            obj.setText(input.next());
            System.out.println("Enter your key or shift : ");
            obj.setShift(input.nextInt());
            obj.setCipher(obj.encrypt(obj.getText(), obj.getShift()%26));
            obj.showResult("Encrypted");
        }else if(choice == '2') {
            System.out.println("Enter your text to decrypt : ");
            obj.setText(input.next());
            System.out.println("Enter your key or shift : ");
            obj.setShift(input.nextInt());
            obj.setDecipher(obj.decrypt(obj.getText(), obj.getShift()%26));
            obj.showResult("Decrypted");
        }
        input.close();
    }
}
