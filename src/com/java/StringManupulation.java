package com.java;

import java.util.Scanner;

public class StringManupulation {

	
	
	public static void main(String[] args) {
		
		Scanner SC=new Scanner(System.in);
		
		System.out.println("Enter the Desired String");
		
		String s=SC.nextLine();
		
		System.out.println("Entered String ::"+s);
		
		//StringBuffer SB=new StringBuffer(s);//makes the size of string buffer to be (size of string)+16
		//SB.ensureCapacity(24);//makes the size of string buffer to be (2*currentsize)+2 only if argumented size is greater tahn current size
		
		
		
		int end=0,start=0;
		//StringBuffer outputString=new StringBuffer();
		StringBuffer SubString =new StringBuffer();
		char ch1 = 0;
	   
		
		for (int i=0;i<s.length();i++) {
			
			
			start=i;
			end=i;
			for(int k=i;k<s.length();k++) {
				
				ch1=s.charAt(k);
				 
				if(Character.isDigit(ch1)) {
					
					end=k;
				}
				else {
					
					break;
				}
				
				
			}
			
		if(end==start) {
			if(Character.isDigit(s.charAt(end))) {
				//System.out.println("Starting Value"+start+"end value"+end);	
			
            SubString.append(s.charAt(end));
            SubString.append(" ");
			}
			else {
				continue;
			}
		}
		else {	
			 //System.out.println("Start Value"+start+"end value"+end);
			 end=end+1;
			  SubString.append(s.substring(start, end));
			  
	            SubString.append(" ");
			
		}
		
		i=end;
		
			
						
		}
		System.out.println("String With only digits::"+SubString);
		//String outputString=new String(SubString);
		
		int sum=0;
		String ST=new String(SubString);
		String arr[]=ST.split(" ");
		
		for(String elements: arr) {
			
			//System.out.println(elements);
			int k=Integer.parseInt(elements);
			sum=sum+k;
		}
		
		System.out.println("Total Sum of the elemets enteres in string is ::"+sum);
		
		//System.out.println("Sum of nUmber in the given String:"+sum);
		
		
		
		SC.close();
	}
}
