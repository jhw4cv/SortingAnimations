import java.awt.Graphics;

import javax.swing.JComponent;

public class InsertionSortComponent extends JComponent implements Runnable{

	private InsertionSorter sorter;

	public InsertionSortComponent(int [] nums) {
		sorter = new InsertionSorter(nums, this);
	}

	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}

	@Override
	public void run() {
		try {
			sorter.sort();
		}
		catch(InterruptedException e) {
		}
	}
}


