package recursion;
//n! = n * (n-1)! for n > 0;
public class Fractional {
public Fractional(int aCount){
		count=aCount;
		checkIfFunction();
}
public void checkIfFunction(){
	if (count==0|count==1){
		answer=1;
	System.out.print(answer);
	System.exit(1);
	}
	else return;
}
public void getFractional(){
	int aNumber=partAnswer;
	while (count>=fractional){
		partAnswer=(fractional*(aNumber));
		System.out.println(number+": "+partAnswer);
		number++;
		fractional++;
		getFractional();
	}
answer=partAnswer;
}
public int returnAnswer(){
	return answer;
}
private static int fractional=2,partAnswer=1;
private int answer,count;
private int number=2;
}
