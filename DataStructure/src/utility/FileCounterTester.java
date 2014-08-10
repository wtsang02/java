package utility;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class FileCounterTester 
	
	{
	   public static void main(String[] args)
	   {  
	      Scanner in = new Scanner(System.in);
	      String input = "";
	      
	      try
	      {  
	         boolean done = false;
	         while (!done)
	         {
	            System.out.print("Filename : ");
	            input = in.next();
	            if (input.equals("-1")) 
	               done = true;
	            else
	            {
	               FileReader fin = new FileReader(input);
	               FileCounter fileCounter = new FileCounter();
	               fileCounter.read(fin);          
	               System.out.println(
	                     fileCounter.getCharacterCount() + " chars, " 
	                     + fileCounter.getWordCount() + " words, " 
	                     + fileCounter.getLineCount() + " lines");
	               fin.close();
	            }
	         }
	      }
	      catch (IOException e)
	      {  
	         e.printStackTrace();
	      }
	   }
	}