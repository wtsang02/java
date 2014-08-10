package DBFinalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

import utility.ArrayUtil;

public class SelectionSortComponent extends JComponent {
	public void paintComponent(Graphics g){
		if(sorter==null) return;
		Graphics2D g2=(Graphics2D) g;
		sorter.draw(g2);
	}
	public void startAnimation(){
		int[] values=ArrayUtil.randomIntArray(100, 300);
		sorter=new SelectionSorter(values,this);
		class AnimationRunnable implements Runnable{
			public void run(){
				try{
					sorter.sort();
				}
				catch(InterruptedException excetion){
				}
			}
		}
	Runnable r=new AnimationRunnable();
	Thread t=new Thread(r);
	t.start();
	}
	private SelectionSorter sorter;
}
