import java.util.Arrays;

public class HelloWorld {
  public static void main(String[] args) {
    
    
    int[] a = new int[3];
    try {
    
    	for(int i = 0; i< 4; i++){
    	
    		a[i] = i;
   	}
   }
   catch (ArrayIndexOutOfBoundsException e){
   	
   	System.out.println("Array Out of Bound!!");
   	
   	
   }
   catch (Exception e){
   	System.out.println(e);
   }
   
   System.out.println(Arrays.toString(a));
   
    
  }
}
