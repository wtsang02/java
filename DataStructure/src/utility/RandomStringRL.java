package utility;
import java.util.Random;
public class RandomStringRL {
	  public String getString(){  
	   int length=(generator.nextInt(3))+6;
	    StringBuilder sb = new StringBuilder();  
	    for (int x = 0; x < length; x++){  
	      sb.append((char)((int)(Math.random()*26)+97));  
	    }  //uses ISO/IEC 8859-1 coding.
	   return sb.toString();
	  }  
	  private static Random generator= new Random();
	}  