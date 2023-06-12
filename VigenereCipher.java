import java.util.Scanner;

/**
 *
 * @author 47155
 */
public class VigenereCipher {
    	public static void main(String[] args) {

		System.out.println("Vigenere Cipher Encryptor");
                //	Allow the user to choose if they want to encrypt or decrypt a message
                try (Scanner in = new Scanner(System.in)) {
                    //	Allow the user to choose if they want to encrypt or decrypt a message
                    System.out.println("Tekan 1 Untuk Encrypt Pesan / Tekan 2 Untuk Decrypt Pesan :");
                    int input = in.nextInt();
                    
                    switch (input) {
                        case 1:
                            {
                                System.out.print("Masukan key menggunakan hurup kapital: ");
                                String key = in.next();
                                System.out.print("Masukan pesan yang akan di Encrypted dengan Vigenere Cipher: ");
                                String EMessage = in.next();
                                String encryptMessage = encrypt(EMessage, key);
                                System.out.println("Hasil Encrypted Pesan : " + encryptMessage);
                                break;
                            }
                        case 2:
                            {
                                System.out.print("Masukan key menggunakan hurup kapital: ");
                                String key = in.next();
                                System.out.print("Masukan pesan yang akan di decrypted dengan Vigenere Cipher: ");
                                String DMessage = in.next();
                                String decryptMessage = decrypt(DMessage, key);
                                System.out.println("Pesan yang decrypted adalah: " + decryptMessage);
                                break;
                            }
                        default:
                            System.out.println("Salah penginputan!");
                            break;
                    }
                }
	}

	
	public static String encrypt(String Message, String Key) {
		String EMessage = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
			j = ++j % Key.length();
		}
		return EMessage;
	}


	public static String decrypt(String Message, String Key) {
		String DMessage = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			DMessage += (char)((letter - Key.charAt(j) + 26) % 26 + 65);
			j = ++j % Key.length();
		}
		return DMessage;
	}
}