package ATM;

import java.io.IOException;
import java.time.Clock;
import java.util.*;
import java.io.*;

class Transaction implements Deposit,Withdraw{
    private DataBase Person;
//    private int type;
    private String acc_num;
   private Clock time;

    Transaction(DataBase Person, String acc_num) throws IOException{
    	this.Person = Person;
    	this.acc_num = acc_num;
    }
     public void  CalDen(double amnt) {
    	time = Clock.systemUTC();
    	Person.Transaction(acc_num, -(amnt), time.instant());
    	
    	int thousand_Den = (int)(amnt / 1000);
    	int fivehundred_den = (int)( amnt/500);
    	int hundred_den = (int)( amnt/100);
    	int fifty_den = (int)( amnt/50);
    	int ten_den = (int)( amnt/10);
    	if(thousand_Den < Person.get_denval(Denominations.Thousand)) {
    		DisplayScreen.Thousand_num(thousand_Den);
    		Person.set_denval(Denominations.Thousand, thousand_Den);
    		Person.set_Acc_balance_WithDraw(acc_num, (double)thousand_Den*1000);
    	    amnt = (int)amnt %1000;
    		fivehundred_den = (int)( amnt/500);
    		if(fivehundred_den < Person.get_denval(Denominations.Five_Hundred)) {
    			Person.set_denval(Denominations.Five_Hundred, fivehundred_den);
    			Person.set_Acc_balance_WithDraw(acc_num, (double)fivehundred_den*500);
    			DisplayScreen.FiveHundred_num(fivehundred_den);
    			amnt = amnt%500;
    			hundred_den = (int)( amnt/100);
    			if(hundred_den < Person.get_denval(Denominations.One_Hundred)) {
    			DisplayScreen.Hundred_num(hundred_den);
    			Person.set_Acc_balance_WithDraw(acc_num, (double)hundred_den*100);
    			Person.set_denval(Denominations.One_Hundred,hundred_den);
    			amnt = amnt%100;
        			 fifty_den = (int)( amnt/50);
        			if(fifty_den < Person.get_denval(Denominations.Fifty)) {
        				DisplayScreen.Fifty_num(fifty_den);
        				Person.set_Acc_balance_WithDraw(acc_num, (double)fifty_den*50);
        				Person.set_denval(Denominations.Fifty, fifty_den);
            			amnt = amnt%50;
            			ten_den = (int)( amnt/10);
            			DisplayScreen.Ten_num(ten_den);
        				Person.set_denval(Denominations.Ten, ten_den);
        				Person.set_Acc_balance_WithDraw(acc_num, (double)ten_den*10);
        			}
    			}
    		}
    	}
    	else if(fivehundred_den < Person.get_denval(Denominations.Five_Hundred)){
    		 fivehundred_den = (int)( amnt/500);
    		if(fivehundred_den < Person.get_denval(Denominations.Five_Hundred)) {
    			Person.set_denval(Denominations.Five_Hundred, fivehundred_den);
    			Person.set_Acc_balance_WithDraw(acc_num, (double)fivehundred_den*500);
    			DisplayScreen.FiveHundred_num(fivehundred_den);
    			amnt = amnt%500;
    			hundred_den = (int)( amnt/100);
    			if(hundred_den < Person.get_denval(Denominations.One_Hundred)) {
    			DisplayScreen.Hundred_num(hundred_den);
    			Person.set_denval(Denominations.One_Hundred,hundred_den);
    			Person.set_Acc_balance_WithDraw(acc_num, (double)hundred_den*100);
    			amnt = amnt%100;
        		fifty_den = (int)( amnt/50);
        			if(fifty_den < Person.get_denval(Denominations.Fifty)) {
        				DisplayScreen.Fifty_num(fifty_den);
        				Person.set_denval(Denominations.Fifty, fifty_den);
        				Person.set_Acc_balance_WithDraw(acc_num, (double)fifty_den*50);
        				amnt = amnt%50;
            			ten_den = (int)( amnt/10);
            			DisplayScreen.Ten_num(ten_den);
        				Person.set_denval(Denominations.Ten, ten_den);
        				Person.set_Acc_balance_WithDraw(acc_num, (double)ten_den*10);
        			}
    			}
    		}
    	}
    	else if(hundred_den < Person.get_denval(Denominations.One_Hundred)){
    		 hundred_den = (int)( amnt/100);
			if(hundred_den < Person.get_denval(Denominations.One_Hundred)) {
			DisplayScreen.Hundred_num(hundred_den);
			Person.set_Acc_balance_WithDraw(acc_num, (double)hundred_den*100);
			Person.set_denval(Denominations.One_Hundred,hundred_den);
			amnt = amnt%100;
    			fifty_den = (int)( amnt/50);
    			if(fifty_den < Person.get_denval(Denominations.Fifty)) {
    				DisplayScreen.Fifty_num(fifty_den);
    				Person.set_denval(Denominations.Fifty, fifty_den);
    				Person.set_Acc_balance_WithDraw(acc_num, (double)fifty_den*50);
    				amnt = amnt%50;
        		    ten_den = (int)( amnt/10);
        			DisplayScreen.Ten_num(ten_den);
    				Person.set_denval(Denominations.Ten, ten_den);
    				Person.set_Acc_balance_WithDraw(acc_num, (double)ten_den*10);
    			}
			}
    	
    	}
    	
    
    }
     public void DepAmnt() {
    	 time = Clock.systemUTC();
    	 Scanner input = new Scanner(System.in);
    	 int total_sum = 0;

    	 DisplayScreen.Thousand_deposit();
		  int add_amnt_Thousand = input.nextInt();
	    	 Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_Thousand)*1000);
		  total_sum +=  add_amnt_Thousand*1000;
		  Person.set_denval(Denominations.Thousand, add_amnt_Thousand);
		  DisplayScreen.FiveHundred_deposit();
		  int add_amnt_FiveHundred = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_FiveHundred)*500);
		  total_sum += add_amnt_FiveHundred*500;
		  Person.set_denval(Denominations.Five_Hundred, add_amnt_FiveHundred);
		  DisplayScreen.OneHundred_deposit();
		  int add_amnt_OneHundred = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_OneHundred)*100);
		  total_sum += add_amnt_OneHundred*100;
		  Person.set_denval(Denominations.One_Hundred, add_amnt_OneHundred);
		  DisplayScreen.Fifty_deposit();
		  int add_amnt_Fifty = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_Fifty)*50);
		  total_sum +=  add_amnt_Fifty*50;
		  Person.set_denval(Denominations.Fifty, add_amnt_Fifty);
		  DisplayScreen.Ten_deposit();
		  int add_amnt_Ten = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_Ten)*10);
		  total_sum +=  add_amnt_Ten*10;
		  Person.set_denval(Denominations.Ten, add_amnt_Ten);
		  DisplayScreen.OneRupee_coin_deposit();
		  int add_amnt_One = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_One)*1);
		  total_sum +=  add_amnt_One*1;
		  
		  DisplayScreen.TwoRupee_coin_deposit();
		  int add_amnt_Two = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_Two)*2);
		  total_sum +=  add_amnt_Two*2;
		  
		  DisplayScreen.FiveRupee_coin_deposit();
		  int add_amnt_Five = input.nextInt();
		  Person.set_Acc_balance_WithDraw(acc_num, -((double)add_amnt_Five)*5);
		  total_sum +=  add_amnt_Five*5;
		  
		  DisplayScreen.Total_Sum(total_sum);
		  Person.Transaction(acc_num, total_sum, time.instant());
     }
    
}
