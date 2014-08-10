package utility;

public class RandomStringFL {
	  public void getString(){
	    StringBuffer sb = new StringBuffer();  
	    for (int x = 0; x < length; x++){  
	      sb.append((char)((int)(Math.random()*26)+97));  
	    }  //uses ISO/IEC 8859-1 coding.
	    System.out.println(sb.toString());  
	  } 
	  private final int length=8;
	}  