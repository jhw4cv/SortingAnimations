import java.awt.Graphics;

import javax.swing.JComponent;

public class SelectionSortComponent extends JComponent implements Runnable{

	private SelectionSorter sorter;


	public SelectionSortComponent(int [] nums) {

		sorter = new SelectionSorter(nums, this);
	}

	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}

	@Override
	public void run()  {
		try {
			sorter.sort();
		}
		catch(InterruptedException e) {
		}
	}
}
