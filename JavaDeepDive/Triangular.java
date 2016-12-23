//Triangualr Numbers

import java.util.*;

public class Triangular{
	//Loops basics 
	/*
	int x = 1;
	while(x<=10){
		System.out.println(x);
		x++;
	}

	for (int y = 10 ; y> 0 ; y-- ){
		System.out.println(y); 
	}
	*/
	public static void main(String[] args){
		
		for(int i = 1; i<=10; i++){
			System.out.println((i*(i+1))/2);
		}

		List<String> familyMember = new ArrayList<String>();
		familyMember.add("Papa Dog");
		familyMember.add("Mom Dog");
		familyMember.add("Brother Dog");
		familyMember.add("Sister Dog");
		
		//A new type of looping through elements like in python

		for (String a : familyMember){
			System.out.println(a);
		}
	}
}