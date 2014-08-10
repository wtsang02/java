package recursion;
import java.util.Scanner;
public class SubStringGenTester {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String word=in.next();
		SubStringGen ssg=new SubStringGen(word);
		ssg.SubString();
	}

}
