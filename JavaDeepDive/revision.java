// Java Revision 
import java.util.*;

public class JavaRevision{
	public static void main(String[] args){
		
		//Hello World 
		System.out.println("Hello World");
		
		// Variables
		int a = 34; 
		double b = 3.2;
		String s = "BOb";
		boolean isActive = true; 
		
		System.out.println(a+b+" My Name is not " + s + isActive);
		System.out.println(s.length());
		// Arrays
		
		int[] numbers = {65, 82};
		System.out.println(numbers.length); 
		System.out.println(numbers[1]);
		
		// List
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add("Taj Mahal");
		
		list.remove(1);
		
		System.out.println(list.toString()); 
		System.out.println(list.get(1));
		
		System.out.println(list.size());
		
		
		// Maps
		
		Map map = new HashMap();
		
		map.put("Father", "F1");
		map.put("Mother", "M2");
		map.put("Child", "C1");
		
		System.out.println(map.toString());
		
		System.out.println(map.get("Mother"));
		
		map.remove("Mother");
		
		System.out.println(map.toString());
		
		
	}
}