package DBFinalProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

public class SelectionSorter {
	private JComponent component;
	private ReentrantLock sortStateLock;
	private int markedPosition;
	public SelectionSorter(int[] anArray,JComponent aComponent){
		a=anArray;
		sortStateLock=new ReentrantLock();
		component=aComponent;
	}
	public void sort() throws InterruptedException{
		for(int i=0;i<a.length-1;i++){
			int minPos=minimumPosition(i);
			swap(minPos,i);
			alreadySorted=i;
			checkIfDone();
		}
	}
	public void checkIfDone() throws InterruptedException{
		if((markedPosition==a[a.length-1])&&alreadySorted==a[a.length-2]){
			alreadySorted=markedPosition-1;
			pause(1);
		}
	}
	private int minimumPosition(int from) throws InterruptedException{
		int minpos=from;
		for(int i=from+1;i<a.length;i++){
			sortStateLock.lock();
			try{
				if(a[i]<a[minpos])
					minpos=i;
				markedPosition=i;
			}
			finally
			{
				sortStateLock.unlock();
			}
			pause(1);
		}
		return minpos;
	}
	private void pause(int steps) throws InterruptedException{
		component.repaint();
		Thread.sleep(steps*DELAY);
	}
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
				else if(i<=alreadySorted&&i<markedPosition)
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
	private int alreadySorted;
	private final static int DELAY=5;//sets speed.
	private int[]a;
}

