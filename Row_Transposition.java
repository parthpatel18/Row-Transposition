import java.io.*;
import java.util.Scanner;

class Row_Transposition
{

	public static void main(String[] args) throws IOException{

		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);

		EncryptDecrypt ed = new EncryptDecrypt();

		String message;
		String word = null;
		String enmsg;
		String enword;

		int i = 0;
		String ciphertext = null;
		String plaintext = null;

		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Select any option given below!");
			System.out.println("1) Encryption");
			System.out.println("2) Decryption");
			System.out.println("3) Exit");
			int sel = s.nextInt();
			switch(sel) {
				case 1: {

					System.out.println("Enter Message : ");
					message = new String(br.readLine()).toLowerCase();

					System.out.println("Enter a word : ");
					word = new String(br.readLine()).toLowerCase();

					ciphertext = ed.encryption(word, message);
					System.out.println("CipherText : " + ciphertext);

					break;
				}
				case 2: {

					System.out.println("Select any given option");
					System.out.println("1) Use ciphertext and word from encryption performed");
					System.out.println("2) Use new ciphertext to decipher it");
					int j = s.nextInt();

					switch(j) {
						case 1: {

							if(ciphertext==null) {

								System.out.println("No encrypted text!");
								System.out.println("Enter new encrypted Message : ");
								enmsg = new String(br.readLine()).toLowerCase();

								System.out.println("Enter a word used for encryption : ");
								enword = new String(br.readLine()).toLowerCase();

								plaintext = ed.decryption(enword, enmsg);

								System.out.println("Plaintext : " + plaintext);

							}
							else {
								plaintext = ed.decryption(word, ciphertext);

								System.out.println("Plaintext : " + plaintext);
							}

							break;
						}
						case 2: {

							System.out.println("Enter new encrypted Message : ");
							enmsg = new String(br.readLine()).toLowerCase();

							System.out.println("Enter a word used for encryption : ");
							enword = new String(br.readLine()).toLowerCase();

							plaintext = ed.decryption(enword, enmsg);

							System.out.println("Plaintext : " + plaintext);

							break;
						}
						default:
							System.out.println("Invalid Option!");
					}

					break;
				}
				case 3: {

					i = 1;
					System.out.println("Thank you!");
					break;
				}
				default:
					System.out.println("Invalid Selection!!");
			}
		} while(i==0);

	}
}
