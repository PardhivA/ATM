package ATM;
import java.io.IOException;
import java.util.*;
class ATMMain{
	
	public static void main(String args[]) throws IOException{
	boolean condition_Atm = true;
    String Acc_num = " ";
	String Pwd;
	AccStatus status = AccStatus.FALSE;
	 Scanner input = new Scanner(System.in);
	 DataBase check = new DataBase();
      while(condition_Atm == true) {
    	  DisplayScreen Obj = new DisplayScreen();
    	  
	      
	       boolean acc_check = false;
	       int counter_acc = 1;
	      while(acc_check == false && counter_acc<=5) {
	    	  Acc_num = input.next();
	       if(check.check_acc(Acc_num)) {
	    	   Obj.greeting(Acc_num, check);
	    	    acc_check = true;
	    	    status = check.get_acc_status(Acc_num);
	    	   continue;  
	       }
	       else {
	    	  Obj.InvalidAccNum();
	    	   counter_acc++;
	       }
	      }
	      if(counter_acc > 5) {
	    	 Obj.Acc_Prob();
	    	 continue;
	      }
	      if(acc_check == true && status != AccStatus.AUTO_BLOCKED) {
	    	  int counter_pwd = 1;
	    	  boolean pwd_check = false;
	    	  //boolean change_pwd = false;
	    	  while(pwd_check == false && counter_pwd <=5){
	    		  Obj.Ask_Pwd();
	    		  Pwd = input.next();
	    		  if(check.check_pwd(Acc_num, Pwd)== true)
	    		  {
	    			  pwd_check = true;
	    			  continue;
	    		  }
	    		  else{
	    			 Obj.InvalidPwd();
	    			  counter_pwd++;
	    		  }
	    	  }
	    	  if(counter_pwd>5) {  
	    		 Obj.Pwd_Prob();
	    	      check.set_acc_status(Acc_num,AccStatus.AUTO_BLOCKED);
	    	      continue;
	    	  }
	    	  
	    	  if(check.get_acc_status(Acc_num)==AccStatus.HIBERNATE) {
	    		Obj.Acc_Hib();
	    		  check.set_acc_status(Acc_num,AccStatus.INUSE);
	    	  }
	    	  if(check.get_acc_status(Acc_num)==AccStatus.INUSE) {
	    		  status = AccStatus.INUSE;
	    	  }
	    	  
	    	  
	      }
	      if(check.get_acc_status(Acc_num)==AccStatus.AUTO_BLOCKED) {
    		  Obj.Pwd_Prob();
    	  }
	      
	      if(status == AccStatus.INUSE) {
	    	  int mode = 0;
	    	  boolean status_now = true;
	    	  while(status_now) {
	    	  Obj.Acc_Modes();
	    	  mode = input.nextInt();
	    	  switch(mode) {
	    	  case 1:
	    		  Obj.dispBal(check,Acc_num);
	    		  Obj.menu_select();
	    		  int temp = input.nextInt();
	    		  if(temp == 1) {
	    			 status_now = false;
	    		  }
	    		  else  status_now = true;
	    		  break;
	    			  
	    	  case 2:
	    		 Obj.WithDraw();
	    		 double amnt = input.nextDouble();
	    		 if(amnt > Transaction.max_limit) {
	    			 Obj.entlessmax();
	    			 continue;
	    		 }
	    		 else {
	    			 if(check.Acc_Bal(Acc_num)<amnt) {
	    				 Obj.entless();
	    				 continue;
	    			 }
	    			 else {
	    				 Transaction Obj2 = new Transaction(check,Acc_num);
	    				 Obj2.CalDen(amnt);
	    				 
	    				 Obj.slip_question();
	    				 int i = input.nextInt();
	    				 if(i==1) Obj.slip();
	    				 
	    			 }
	    		 }
	    		 Obj.menu_select();
	    		 int temp1 = input.nextInt();
	    		  if(temp1 == 1) {
	    			 status_now = false;
	    		  }
	    		  else  status_now = true;
	    		 break;
	    	  case 3:
	    		  Transaction Obj2 = new Transaction(check,Acc_num);
	    		  Obj2.DepAmnt();
	    		  Obj.slip_question();
 				 int i1 = input.nextInt();
 				 if(i1==1) Obj.slip();
	    		  Obj.menu_select();
	    		  
	    		  int temp_11 = 0;
	    		  temp_11 = input.nextInt();
	    		  if(temp_11 == 1) {
	    			 status_now = false;
	    		  }
	    		  else  status_now = true;
	    		  break;
	    	  case 4:
	    		  Obj.EditDetails();
	    		  int op = input.nextInt();
	    		  switch(op) {
	    		  case 1:
	    			  Obj.EnterNamechange();
	    			  String Change_name = input.next();
	    			  check.changeName(Acc_num, Change_name);
	    			  Obj.Namechange();
	    			  break;
	    		  case 2:
	    			  Obj.EnterPhone_number_change();
	    			  String Change_Ph = input.next();
	    			  check.changePh(Acc_num, Change_Ph);
	    			  Obj.Phone_number_change();
	    			  break;
	    		  case 3:
	    			  Obj.EnterAddress_change();
	    			  String Change_Add = input.next();
	    			  check.changeAdd(Acc_num, Change_Add);
	    			  Obj.Address_change();
	    			  break;	  
	    		  }
	    		  Obj.menu_select();
	    		  int temp_12 = 0;
	    		  temp_12 = input.nextInt();
	    		  if(temp_12 == 1) {
	    			 status_now = false;
	    		  }
	    		  else  status_now = true;
	    		  break;
	    	  case 5:
	    		  check.Transaction_list(Acc_num);
	    		  Obj.slip_question();
 				 int i2 = input.nextInt();
 				 if(i2==1) Obj.slip();
	    		  Obj.menu_select();
	    		  int temp_13 = 0;
	    		  temp_13 = input.nextInt();
	    		  if(temp_13 == 1) {
	    			 status_now = false;
	    		  }
	    		  else  status_now = true;
	    		  break;
	    	  }
	      }
	      }
	      
      }
   
}
}
