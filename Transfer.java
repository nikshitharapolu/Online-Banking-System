package OnlineBankingSystem;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Transfer extends AccDetails{
	void deposit(String id) throws IOException{
		Scanner sc = new Scanner(System.in);
		int chance1 = 0, flag = 0, flag1 = 0;
		int balance;
		String acc;
		String fname;
		String cif, branch_code;
		BufferedReader br, br2;
		while (true) {
			System.out.println("Enter the details of the account to which you want to tranfer money : ");
			while (true) {
				System.out.println("Account Number : ");
				acc = sc.next();
				if (acc.length() != 11) {
					System.out.println("Invalid Account number !!");
					chance1++;
				}
				if (chance1 == 3) {
					System.out.println("You have tried 3 times. Try again in 30 seconds ");
					break;
				}
				
				if(acc.length() == 11) {
					fname = acc + ".txt";
				try {
					br = new BufferedReader(new FileReader("E:\\BankingSystem\\Account Details\\" + fname));
					String line;
					while ((line = br.readLine()) != null) {
						if (line.equals("Account No : " + acc)) {
							flag = 1;
							break;
						}
					}
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Account not found");
				}
				}
				if (flag == 0) 
					System.out.println("Wrong details");
				else
					break;
			}
			if (chance1 == 3)
				break;
			fname = acc + ".txt";
			br2 = new BufferedReader(new FileReader("E:\\BankingSystem\\Account Details\\" + fname));
			String line;
			while (true) {
				flag = 0;
				System.out.println("CIF Number : ");
				cif = sc.next();
				while ((line = br2.readLine()) != null) {
					if (line.equals("CIF number : " + cif)) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) 
					System.out.println("Wrong details ");
				else 
					break;
			}
			while (true) {
				flag = 0;
				System.out.println("Branch code : ");
				branch_code = sc.next();
					while ((line = br2.readLine()) != null) {
						if (line.equals("Branch code : " + branch_code)) {
							flag = 1;
							break;
						}
					}
					if(flag == 0) 
						System.out.println("Wrong details");
					else 
						break;
			}
			flag1 = 1;
			
			if(flag1 == 1) 
				break;
		}
		System.out.println("Enter their username : ");
		String user = sc.next();
		Deposit dep = new Deposit();
		dep.add(user, 1);
		Withdraw w = new Withdraw();
		w.drawMoney(id, 1);
		
	}
}
