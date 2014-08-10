package utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unicode {

public static void main(String[] args) {
System.out.println("Use CTRL+C to quite to program.");

// Create the reader for reading in the text typed in the console. 
InputStreamReader inputStreamReader = new InputStreamReader(System.in);
BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

try {
  String line = null;
  while ((line = bufferedReader.readLine()).length() > 0) {
    for (int index = 0; index < line.length(); index++) {

      // Convert the integer to a hexadecimal code.
      String hexCode = Integer.toHexString(line.codePointAt(index)).toUpperCase();


      // but the it must be a four number value.
      String hexCodeWithAllLeadingZeros = "0000" + hexCode;
      String hexCodeWithLeadingZeros = hexCodeWithAllLeadingZeros.substring(hexCodeWithAllLeadingZeros.length()-4);

      System.out.println("\\u" + hexCodeWithLeadingZeros);
    }

  }
} catch (IOException ioException) {
       ioException.printStackTrace();
  }
 }
}