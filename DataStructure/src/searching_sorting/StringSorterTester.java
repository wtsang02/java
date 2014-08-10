package searching_sorting;
import utility.StopWatch;
//sorts an array with random letters.
//6-8 letters, array with 30 length.
public class StringSorterTester {
	public static void main(String[] args) {
	StringSorter ss=new StringSorter(50);
	StopWatch sw=new StopWatch();
	sw.start();
	ss.storeStrings();
	ss.sort();
	sw.stop();
	ss.print();
	sw.printTime();

	}

}
