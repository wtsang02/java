package utility;
import java.io.FileReader;
import java.io.IOException;

/**
   A class to count the number characters, words, and lines in a file.
*/
public class FileCounter{
   /**
      Construct a FileCounter object.
   */
   public FileCounter() {
      chars = 0;
      words = 0;
      lines = 0; 
   }
   
   /**
      Read the input file and count the number.
      of words, characters, and lines.
      @param file the file to count
   */
   public void read(FileReader reader) throws IOException
   {
      boolean space = true;
      boolean more = true;
      
      while (more)
      {  
         int ic = reader.read();
         if (ic == -1) more = false;
         else
         {  
            chars++;
            char c = (char) ic;
            if (c == '\n') 
            { 
               lines++; 
               space = true; 
            }
            else if (c == ' ' || c == '\r') 
               space = true;
            else
            {  
               if (space)
                  words++;
               space = false;
            }
         }
         lines++;
      }
   }
   
   /**
      Gets the number of characters in a file.
      @return the number of characters
   */
   public int getCharacterCount() 
   {
      return chars;
   }

   /**
      Gets the number of words in a file.
      @return the number of words
   */   
   public int getWordCount()
   {
      return words;
   }

   /**
      Gets the number of lines in a file.
      @return the number of lines
   */   
   public int getLineCount()   
   {
      return lines;
   }    
      
   private int chars;
   private int words;
   private int lines;
}