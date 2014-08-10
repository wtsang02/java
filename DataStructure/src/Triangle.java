public class Triangle {
	public Triangle ( int aWidth) {
		width = aWidth;
	}
	public int getArea(){
		if (width<0) return 0;
		if (width ==1) return 1;
		Triangle smallerTriangle = new Triangle( width-1);
		System.out.print(width+"  ");
	int smallerArea = smallerTriangle.getArea();
	return smallerArea+width;
	}
private int width;
}