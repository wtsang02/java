package DBFinalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

import utility.ArrayUtil;

public class QuickSortComponent extends JComponent {
	
	public void paintComponent(Graphics g){
		if(sorter==null) return;
		Graphics2D g2=(Graphics2D) g;
		sorter.draw(g2);
		
	}
	public final int length=100;
	public void startAnimation(){
		
		int[] values=ArrayUtil.randomIntArray(length, 300);
		sorter=new QuickSort(values,this);
		
		class AnimationRunnable implements Runnable{
			public void run(){
				try {
					sorter.sort(0,length-1);
					sorter.pause(1);
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	Runnable r=new AnimationRunnable();
	Thread t=new Thread(r);
	t.start();
	
	}
	private QuickSort sorter;
}
