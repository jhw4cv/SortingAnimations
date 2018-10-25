import java.awt.Graphics;

import javax.swing.JComponent;

public class BubbleSortComponent extends JComponent implements Runnable{

	private BubbleSorter sorter;
	
	public BubbleSortComponent(int [] nums) {
		sorter = new BubbleSorter(nums, this);
	}
	
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}

	@Override
	public void run() {
		try {
			sorter.sort();
		} catch(InterruptedException e) {
			
		}
	}
}