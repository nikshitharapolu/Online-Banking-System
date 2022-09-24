package OnlineBankingSystem;
import java.io.*;
public class AccDetails {
	public void display(String id) throws IOException {
		String file = id + ".txt";
		String line;
		System.out.println("----- ACCOUNT DETAILS -----");
		BufferedReader br = new BufferedReader(new FileReader("E:\\BankingSystem\\Users\\" + file));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("-----------------------------------");
		br.close();
	}
}
