package DBFinalProject;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class SelectionSortComponentTester {

	public static void main(String[] args) {
		SelectionSortComponent ssc=new SelectionSortComponent();
		QuickSortComponent qsc=new QuickSortComponent();
		JFrame frame=new JFrame("Project");
		frame.setBounds(0, 0, 1000, 600);
		frame.setLayout (new GridLayout(2, 1));
		ssc.startAnimation();
		qsc.startAnimation();
		frame.add(ssc);
		frame.add(qsc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
