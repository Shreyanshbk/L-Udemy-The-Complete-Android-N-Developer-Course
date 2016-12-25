import java.util.*;

public class Class{
	public static void main(String[] args){
		class Number{
			int value; 
			public boolean isPositive(){
				if (value>0){
					return true;
				}
				else{
					return false;
				}
			}
		}
		Number n  = new Number();
		n.value = -2;
		if (n.isPositive()){
			System.out.println(n.value + " is is Positive");
		}
		else{
			System.out.println(n.value + " is not Positive");
		}
	}
}