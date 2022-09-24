package OnlineBankingSystem;
import java.io.*;
public class transactionHistory extends AccDetails {
	void receipt(String id) throws IOException {
		String line;
		String name = id + "THistory" + ".txt";
		System.out.println("---- TRANSACTION HISTORY ----");
		try {
		BufferedReader br = new BufferedReader(new FileReader("E:\\BankingSystem\\Transaction History\\" + name));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		}
		catch(Exception e) {
			System.out.println("No transactions were made");
			System.out.println("-------------------------------");
		}
	}
}
