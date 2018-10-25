import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class InsertionSorter {

	private int [] nums;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private int insertingIndex = -1;
	private JComponent component;

	private static final int DELAY = 600;

	public InsertionSorter(int [] nums, JComponent component) {
		this.nums = nums;
		this.component = component;
	}

	public void sort() throws InterruptedException {
		for(int i = 1; i < nums.length; i++) {
			int key = nums[i];
			int j = i -1;
			try {
				this.markedPosition = i;
				while(j >= 0 && nums[j] > key) {
					this.insertingIndex = j;
					nums[j+1] = nums[j];
					j = j-1;
				}
				nums[j+1] = key;
				} finally {
			}
			this.alreadySorted = i;
			pause(2);
		}
	}

	public void pause(int steps) throws InterruptedException{
		this.component.repaint(); 
		Thread.sleep(steps * DELAY);
	}

	public void draw(Graphics g) {
		try {
			int deltaX = this.component.getWidth() / nums.length;
			for(int i = 0; i < nums.length; i++) {
				if(i == this.markedPosition) {
					g.setColor(Color.ORANGE);
				}
				else if(i == this.insertingIndex) {
					g.setColor(Color.GREEN);
				}
				else if(i <= this.alreadySorted) {
					g.setColor(Color.BLUE);
				}
				else {
					g.setColor(Color.RED);
				}
				g.fillRect(i*deltaX, 0, 4, 2*nums[i]);
			}			
		} finally {
		}
	}
}
