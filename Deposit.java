package OnlineBankingSystem;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Deposit extends AccDetails{
	void add(String id, int i) throws IOException {
		//String user = id;
		Scanner sc = new Scanner(System.in);
		String file = id + ".txt";
		String line;
		int dep, balance;
		BufferedReader br = new BufferedReader(new FileReader("E:\\BankingSystem\\Users\\" + file));
		if(i == 0)
		System.out.println("Enter the amount you want to deposit : ");
		else if(i == 1)
			System.out.println("Enter the amount you want to tranfer : ");
			
		dep = sc.nextInt();
		String bal = null;
		String data = "";
		while ((line = br.readLine()) != null) {
			
			bal = line;
		}
		int i1 = 0;
		String s2 = bal.substring(10);
		int b = Integer.parseInt(s2);
		balance = b + dep;
		br.close();
		BufferedReader br2 = new BufferedReader(new FileReader("E:\\BankingSystem\\Users\\" + file));
		while ((line = br2.readLine()) != null) {
			i1++;
			data += line + "\n";
			if(i1 == 6) {
				break;
			}
		}
		br2.close();
		FileOutputStream fos = new FileOutputStream("E:\\BankingSystem\\Users\\" + file);
		data = data + "Balance : " + balance;
		fos.write(data.getBytes());
		fos.close();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    String s = formatter.format(date);
	    String name = id + "THistory" + ".txt";
	    String receipt = "Date and Time : \n" + s + "\nAmount deposited : " + dep + "\nBalance : " + balance + "\n-------------------------------------------\n";
	    String t = "";
	    
	    if(i==0) {
	    	System.out.println("-------- RECEIPT -------\n" + receipt);
	    try {
	         File f1 = new File("E:\\BankingSystem\\Transaction History\\" + name);
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }
	    	 BufferedReader br3 = new BufferedReader(new FileReader("E:\\BankingSystem\\Transaction History\\" + name));
	    	 while ((line = br3.readLine()) != null) {
	 			t += line + "\n";
	 		 }
	    	 t = t + receipt;
	         FileOutputStream out = new FileOutputStream("E:\\BankingSystem\\Transaction History\\" + name);
	         out.write(t.getBytes());
	         out.close();
	         br3.close();
	      } catch(IOException e){
	    	  System.out.println("Exception .. ");
	      }
	    }
	    else {
		   receipt = "Tranferred \nDate and Time : \n" + s + "\nAmount deposited : " + dep + "\nBalance : " + balance + "\n-------------------------------------------\n";

	    	try {
		         File f1 = new File("E:\\BankingSystem\\Transaction History\\" + name);
		         if(!f1.exists()) {
		            f1.createNewFile();
		         }
		    	 BufferedReader br3 = new BufferedReader(new FileReader("E:\\BankingSystem\\Transaction History\\" + name));
		    	 while ((line = br3.readLine()) != null) {
		 			t += line + "\n";
		 		 }
		    	 t = t + receipt;
		         FileOutputStream out = new FileOutputStream("E:\\BankingSystem\\Transaction History\\" + name);
		         out.write(t.getBytes());
		         out.close();
		         br3.close();
		      } catch(IOException e){
		    	  System.out.println("Exception .. ");
		      }
	    }
		}
		
}
