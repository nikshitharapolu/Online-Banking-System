package OnlineBankingSystem;
import java.util.*;
import java.io.*;

public class WelcomePage {
	String username;
	String password;
	Scanner sc = new Scanner(System.in);

	void loginDetails() throws IOException {
		int flag = 0, flag2 = 0, flag3 = 0, attempts = 0;
		
		while (true) {
			flag3 = 0;
			flag = 0;
			System.out.println("** Sign in **");
			System.out.println("Enter your user ID : ");
			String id = sc.next();
			String filename = id + ".txt";
			try {
				FileInputStream fis = new FileInputStream("E:\\BankingSystem\\Users\\" + filename);
				System.out.println("Enter password : ");
				String pw = sc.next();
				attempts++;
				BufferedReader br = new BufferedReader(new FileReader("E:\\BankingSystem\\Users\\" + filename));
				String line;
				while ((line = br.readLine()) != null) {
					if (line.equals("Password : " + pw)) {
						flag = 1;
						System.out.println(" * Signed in *");
						break;
					}
				}
				br.close();
				if (flag == 1) {
					while(true) {
					System.out.println("What do you want to do ? ");
					System.out.println(
							"1. Display account details\n2. Deposit\n3. Withdraw\n4. Transfer\n5. View Transaction History\n6. Sign out");
					int option = sc.nextInt();
					switch(option) {
					case 1:
						AccDetails disp = new AccDetails();
						disp.display(id);
						break;
					case 2 :
						Deposit dep = new Deposit();
						dep.add(id, 0);
						break;
					case 3:
						Withdraw w = new Withdraw();
						w.drawMoney(id, 0);
						break;
					case 4:
						Transfer tr = new Transfer();
						tr.deposit(id);
						break;
					case 5:
						transactionHistory t = new transactionHistory();
						t.receipt(id);
						break;
					default :
						if(option > 6)
							System.out.println("Invalid choice");
					}
					if(option == 6) {
						flag3 = 1;
						break;
					}
				}
				
				}
			} catch (FileNotFoundException e) {
				System.out.println(" -- Not found -- ");
				System.out.println("Do you want to try again ? ");
				String cont = sc.next();
				if (cont.equalsIgnoreCase("yes")) {
					System.out.println("Enter again ");
					flag = 1;
					flag2 = 1;
				}
				else {
					System.out.println("Okay bye");
					break;
				}
			}
			if(flag3 == 1) {
				System.out.println("Signing out...");
				break;
			}
			if (flag == 0) 
				System.out.println("Wrong password");
			if(attempts == 3) {
				System.out.println("You have tried 3 times. Try again in 30 seconds");
				break;
			}
			if(flag2 == 0) {
				System.out.println("Do you want to try again ?");
				String choice = sc.next();
				if(choice.equalsIgnoreCase("no")) {
					break;
				}
			}
			
		}
	}

	void register() throws IOException {
		int chance1 = 0, flag = 0, flag1 = 0;
		int balance;
		String acc, dob;
		String pw1, pw2, email;
		String fname;
		String cif, branch_code, phone_num, filename;
		BufferedReader br, br2;
		while (true) {
			System.out.println("** New User Activation / Register page **");
			System.out.println("Account Details :");
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
				System.out.println("Date of birth : (DD/MM/YYYY)");
				dob = sc.next();
				if (dob.length() != 10) 
					System.out.println("Inavlid !!");
				while ((line = br2.readLine()) != null) {
					if (line.equals("DOB : " + dob)) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) 
					System.out.println("Wrong details");
				else 
					break;
			}
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
			while (true) {
				flag = 0;
				System.out.println("Phone number : ");
				phone_num = sc.next();
				while ((line = br2.readLine()) != null) {
					if (line.equals("Phone number : " + phone_num)) {
						flag = 1;
						break;
					}
				}
				if(flag == 0) 
					System.out.println("Wrong details");
				else 
					break;
			}
			while (true) {
				flag = 0;
				System.out.println("Email address : ");
				email = sc.next();
				while ((line = br2.readLine()) != null) {
					if (line.equals("Email : " + email)) {
						flag = 1;
						break;
					}
				}
				
				if(flag == 0) 
					System.out.println("Wrong details");
				else 
					break;
			}
			System.out.println("Enter you current balance : ");
			balance = sc.nextInt();
			System.out.println("Create an user ID : ");
			username = sc.next();
			while (true) {
				System.out.println("Set a password : ");
				pw1 = sc.next();
				if (pw1.length() < 8) {
					System.out.println("Password length too short. Enter again ");
				} 
				else {
					System.out.println("Re-enter your password : ");
					pw2 = sc.next();
					if (pw1.equals(pw2)) {
						System.out.println("You can now login and continue with online banking. Thank you.");
						filename = username;
						FileOutputStream fos = new FileOutputStream("E:\\BankingSystem\\Users\\" + filename + ".txt");
						String data = "User ID : " + username + "\nPassword : " + pw1 + "\nAccount Number : " + acc + "\nCIF number : " + cif + "\nPhone number : " + phone_num + "\nEmail : " + email + "\nBalance : " + balance;
						fos.write(data.getBytes());
						flag1 = 1;
						fos.close();
						break;
					} 
					else 
						System.out.println("Passwords do not match");
				}
			}
			if(flag1 == 1) 
				break;
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		Thread t1, t2;
		while (true) {
			System.out.println("*** BANK OF HYDERABAD ***");
			System.out.println("     NET BANKING");
			System.out.println("   --- Welcome ---\n");
			System.out.println("1. Sign in using Internet Banking ID\n2. Register with my Account Details\n3. Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Registration for existing customers : ");
				System.out.println("Do you have bank internet ID ?");
				String opt = sc.next();
				if (opt.equalsIgnoreCase("yes")) {
					//WelcomePage user = new WelcomePage();
					//user.loginDetails();
					t1 = new Thread(new Runnable() {
						public void run() {
							WelcomePage user = new WelcomePage();
							try {
								user.loginDetails();
							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("\n");
						}
					});
					t1.start();
					try {
						t1.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Select an other option");
				}
				break;
			case 2:
				//WelcomePage user = new WelcomePage();
				//user.register();
				t2 = new Thread(new Runnable() {
					public void run() {
						WelcomePage user = new WelcomePage();
						try {
							user.register();
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("\n");
					}
				});
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Application closing...");
				flag = 1;
				break;
			default:
				System.out.println("Choose a valid option ");
			}
			if (flag == 1) {
				break;
			}
		}
		sc.close();
	}
}
