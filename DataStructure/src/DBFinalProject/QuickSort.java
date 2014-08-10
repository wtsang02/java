package DBFinalProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class QuickSort{
	public QuickSort(int[] anArray,JComponent aComponent){
		a=anArray;
		sortStateLock=new ReentrantLock();
		component=aComponent;
	}
	private JComponent component;
	private ReentrantLock sortStateLock;
	private int markedPosition;
public void sort(int from,int to) throws ArrayIndexOutOfBoundsException, InterruptedException{
	if(from>=to){
		if(to==a.length){
			markedPosition=a.length;
			alreadySorted=a.length;
			
		}
			
		return;
	}
	sortStateLock.lock();
	int p=partition(from,to);
	pause(1);
	sort(from,p);
	sort(p+1,to);
	alreadySorted=to;
	
	}
private int partition(int from,int to)throws ArrayIndexOutOfBoundsException, InterruptedException{
	int pivot=a[from];

	int j=to+1;
	int i=from-1;
	try{
		while(i<j){
			
			i++;
			while(a[i]<pivot)i++;
			j--;
			while(a[j]>pivot)j--;
			if(i<j)	swap(i,j);
		
		}
		
		
	}catch (ArrayIndexOutOfBoundsException e){
		System.out.println(e);
		return j;
	}
	
	finally{
		sortStateLock.unlock();
	}

	markedPosition=i;
	pause(50);
	return j;
}
public void pause(int steps) throws InterruptedException{
	component.repaint();
	Thread.sleep(steps*DELAY);
}
private final static int DELAY=5;//sets speed.
private void swap(int i,int j){
	int temp=a[i];
	a[i]=a[j];
	a[j]=temp;
}
public void draw(Graphics2D g2){
	sortStateLock.lock();
	try{
		int deltaX=component.getWidth()/a.length;
		for(int i=0;i<a.length;i++){
			if(i==markedPosition)
				g2.setColor(Color.RED);
			else if(i<=markedPosition&&i<=alreadySorted)
				g2.setColor(Color.BLUE);
			else
				g2.setColor(Color.BLACK);
			g2.draw(new Line2D.Double(i*deltaX,0,i*deltaX,a[i]));
		}
	}
	finally{
		sortStateLock.unlock();
	}
}
private int[] a;
private int alreadySorted;
}