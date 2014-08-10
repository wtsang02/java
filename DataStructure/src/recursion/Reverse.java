package recursion;
public class Reverse {
public Reverse(String s){
	sentence=s;
	}
public void splitSentence(){
	 anArray=sentence.split("\\s");
	 i=anArray.length-1;
}
public void reverse(){
		int letters=anArray[count].length();
	for(int n=letters;n>0;n--){
		char c=anArray[count].charAt(n-1);
		System.out.print(c);
	}
	System.out.print(" ");
	count++;
	if(count!=i+1)
	reverse();
	}
private int i,count;
private String sentence;
private String[] anArray;
}
