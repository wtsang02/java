package recursion;

public class SubStringGen {
public SubStringGen(String aWord){
	word=aWord;
	count(word);
}
public void count(String aWord){
	count=aWord.length();
}
public void SubString(){
	for(int i=0;i<count;i++){
		for(int j=0;j<i;j++)
			System.out.print(word.charAt(j));
		System.out.print(word.charAt(i)+" ");
	}
	word=word.replaceFirst("(.)", "");
	if(count<1){
		return;
		}
	SubStringGen ssg=new SubStringGen(word);
	ssg.SubString();
}
private String word;
private int count;
}
