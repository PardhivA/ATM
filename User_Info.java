package ATM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.time.Clock;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
public class User_Info {
//      void update_name(String n);
//      void update_phone_number(String n);
//      void update_address(String s);
       private String Name;
       private String Phone_number;
       private String address;
       private String Acc_num;
       private AccStatus Acc_status;
       private Double Acc_balance;
       private String Acc_Pwd;
       private HashMap <Double,Instant> Acc_statement;
       User_Info(){
    	   Acc_statement = new HashMap <Double,Instant> ();
       }
       
        void set_Name(String Name) {
        	this.Name = Name;
        }
        void set_Phone_number(String Name) {
        	this.Phone_number = Name;
        }
        void set_address(String Name) {
        	this.address = Name;
        }
        void set_Acc_Num(String Name) {
        	this.Acc_num = Name;
        }
        void set_Acc_status(AccStatus Name) {
        	this.Acc_status = Name;
        }
        void set_Acc_balance(Double Amnt) {
        	this.Acc_balance = Amnt;
        }
        void set_Acc_pwd(String Name) {
        	this.Acc_Pwd = Name;
        }
        void set_Acc_Statement(double amnt, Instant time) {
        	Acc_statement.put(amnt, time);
//        	File Obj = new File("Transactions.txt");
//        	try {
//				if(Obj.createNewFile()) {
//					
//				}
//				else {
//					
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	FileWriter writer = null;
//			try {
//				writer = new FileWriter("Transcations.txt");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	if(amnt < 0)
//				try {
//					writer.write("Amount withdrawn is ");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        	try {
//				writer.write((int)amnt);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
        
        
        
        String get_Name() {
            return Name;
        }
        String get_Phone_number() {
            return Phone_number; 
        }
        String get_address() {
            return address; 
        }
        String get_Acc_Num() {
            return Acc_num;
        }
        AccStatus get_Acc_status() {
            return Acc_status;
        }
        Double get_Acc_balance() {
            return Acc_balance; 
        }
        String get_Acc_pwd() {
            return Acc_Pwd;
        }
        void get_Acc_statement() {
        
//        	Iterator iter = Acc_statement.entrySet().iterator();
//        	for(iter.hasNext()) {
//        		Map.Entry mapElement = 
//        	}
        	Acc_statement.forEach((k,v) -> DisplayScreen.Transaction_statement(k,v));
        	
        	
        }
}
