package com.wtsang02.io;

import java.io.File;
import java.io.IOException;

public class FileTextIOTester {

	public static void main(String[] args){
		//Create an FileTextIO Object.
		FileTextIO data = new FileTextIO();
		
		/*Generate the source file. If 'false' , it will automaticlly
		 * generate static data, if 'true' user can input the data; Then it
		 * returns the NAME of the source file generated.
		 */
		String dataFileName = data.generateData(true);
		
		//creates a reference to the sourcefile. Before it was just a name, not we call it a file.
		File dataFile = new File(dataFileName);
		
		String dataToBeTransfered=null;
		try {
			/*Gets matched data from first paras (dataFile) , checks each line
			 * and returns the lines that contain the String from 2nd params (grade is 100).
			 */
			dataToBeTransfered = data.getMatchedData(dataFile, "grade is 100");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Creates a blank target file to transfer the data.
		File targetFile = new File("TargetFile.txt");

		try {
			/*Takes 2nd params (datatobetransfered)
			and writes it to 1st params ( targetFile)
			*/
			data.writeToFile(targetFile,dataToBeTransfered);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
