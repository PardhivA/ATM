package ATM;
import java.util.HashMap;
import java.io.*;
import java.util.*;
//import java.sql.*;
import java.time.*;
public class DataBase {
	
	
	
	     protected static HashMap<String,String> AC_PD = new HashMap<String,String>();
	     protected static HashMap<String,AccStatus> AC_PD_status = new HashMap<String,AccStatus>();
	     protected static HashMap<String,Double> AC_PD_balance = new HashMap<String,Double>();
	     protected static HashMap<Denominations,Integer> DenVal = new HashMap<Denominations,Integer>();
		 protected static HashMap<String,User_Info> All_Info = new HashMap<String,User_Info>();
		 DataBase(){
		    	    try {
		    	    	File myObj = new File("input_ATM.txt");
		    	    	Scanner input_reader = new Scanner(myObj);
		    	    	int i =1;
		    	    	while(input_reader.hasNextLine()) {
		    	    		User_Info test = create_new_userInfo();
		    	    		String Acc_num = input_reader.nextLine();
		    	    
		    	    		test.set_Acc_Num(Acc_num);
		    	    		test.set_Acc_pwd(input_reader.nextLine());
		    	    		test.set_Name(input_reader.nextLine());
		    	    		test.set_Phone_number(input_reader.nextLine());
		    	    		test.set_Acc_balance(10000.00);
		    	    		if(i!=14 || i!=15)
		    	    		test.set_Acc_status(AccStatus.INUSE);
		    	    		else
		    	    	    test.set_Acc_status(AccStatus.HIBERNATE);
		    	    		All_Info.put(Acc_num, test);
		    	    		i++;
		    	    	}
		    	    }
		    	    catch(FileNotFoundException e) {
		    	    	System.out.println("IO Exception");
		    	    }
		    		

		    		
		    		DenVal.put(Denominations.Thousand, 50);
		    		DenVal.put(Denominations.Five_Hundred, 30);
		    		DenVal.put(Denominations.One_Hundred, 100);
		    		DenVal.put(Denominations.Fifty, 100);
		    		DenVal.put(Denominations.Ten, 250);
		    	}
		    public boolean check_acc(String Ac) {
		    	return All_Info.containsKey(Ac);
		    }
		    public boolean check_pwd(String Ac,String Pwd) {
		    	User_Info temp = All_Info.get(Ac);
		    	String this_pwd = temp.get_Acc_pwd();
		    	if(this_pwd.compareTo(Pwd)==0) return true;
		    	else return false;
		    }
		    
		    void set_acc_status(String Ac, AccStatus set) {
		    	User_Info temp = All_Info.get(Ac);
		    	temp.set_Acc_status(set);
		    }
		    AccStatus get_acc_status(String Ac) {
		    	User_Info temp = All_Info.get(Ac);
		    	return temp.get_Acc_status();
		    }
		    double Acc_Bal(String Acc) {
		    	User_Info temp = All_Info.get(Acc);
		    	return temp.get_Acc_balance();
		    }
		    int get_denval(Denominations den) {
		    	return DenVal.get(den);
		    }
		    
		   void set_denval(Denominations den, int val) {
		    	int cr_val = DenVal.get(den);
			   DenVal.put(den,cr_val - val); 
		    }
		   void set_Acc_balance_WithDraw(String Ac,Double Amnt) {
				User_Info temp = All_Info.get(Ac);
			  double temp1 = temp.get_Acc_balance();
			   temp.set_Acc_balance(temp1 - Amnt);
		   }
		   
		   User_Info create_new_userInfo() {
			   User_Info obj = new User_Info();
			   return obj;
		   }
		   
		   String getName(String Ac) {
			   User_Info temp = All_Info.get(Ac);
			   return temp.get_Name();
		   }
		   void changeName(String Ac,String S) {
			   User_Info temp = All_Info.get(Ac);
			   temp.set_Name(S);
		   }
		   void changePh(String Ac,String S) {
			   User_Info temp = All_Info.get(Ac);
			   temp.set_Phone_number(S);
		   }
		   void changeAdd(String Ac,String S) {
			   User_Info temp = All_Info.get(Ac);
			   temp.set_address(S);
		   }
		   void Transaction(String Acc_num, double amnt, Instant time) {
			   User_Info temp = All_Info.get(Acc_num);
			   temp.set_Acc_Statement(amnt, time);
		   }
		   void Transaction_list(String Acc_num) {
			   User_Info temp = All_Info.get(Acc_num);
			   temp.get_Acc_statement();
		   }
	



}
