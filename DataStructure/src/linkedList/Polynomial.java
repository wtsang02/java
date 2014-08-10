package linkedList;

public class Polynomial {
	public Polynomial(int firstNum, int secondNum){
		coef=firstNum;
		base=secondNum;
	}
	private int coef;
	private int base;
	public int getDerivative(){
		return coef;
	}
	
}
