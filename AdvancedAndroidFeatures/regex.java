import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld {
  public static void main(String[] args) {
    
    // str.split("") --> Helps to split a string on any given character.
    // str.substring(2,4) --> Helps to get the substring of the given string.
    
    String sr = "<div class=\"image\"><img src=\"http://cdn.posh24.com/images/:profile/03f352f71ffab135cd81821eb190d4832\" alt=\"Kanye West\"/></div>";
					
   
   Pattern p = Pattern.compile("src=\"(.*?)\" alt=\"(.*?)\"/>");
   Matcher m = p.matcher(sr);
   
   while(m.find()){
   	System.out.println(m.group(1));
   	System.out.println(m.group(2));
   }
      
      
      
   /*   
      
   String s = "Missipdaslndsf";
   Pattern p = Pattern.compile("Mi(.*?)sf");
   Matcher m = p.matcher(s);
   
   while(m.find()){
   	System.out.println(m.group(1));
   }
   */
  }
}
