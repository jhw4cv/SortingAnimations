import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SelectionSorter {

	private int [] nums;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private int currentMin = -1;
	private JComponent component;

	private static final int DELAY = 50;

	public SelectionSorter(int [] nums, JComponent component) {
		this.nums = nums;
		this.component = component;
	}

	public void sort() throws InterruptedException{
		for(int i = 0; i < nums.length - 1; i++) {
			int minPos = minimumPosition(i);
			try {
				swap(minPos, i);
				this.alreadySorted = i;
			} finally {
			}
		}
		pause(2);
	}

	public void swap(int minPos, int index) {
		int hold = nums[minPos];
		nums[minPos] = nums[index];
		nums[index] = hold;
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
					g.setColor(Color.BLACK);
				}
				else if(i == this.currentMin) {
					g.setColor(Color.GREEN);
				}
				else if (i <= this.alreadySorted) {
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

	private int minimumPosition(int from) throws InterruptedException {
		int minPos = from;
		for(int i = from + 1; i < nums.length; i++) {
			try {
				if(nums[i] < nums[minPos]) {
					minPos = i;
					this.currentMin = i;
				}
				this.markedPosition = i;
			} finally {
			}
			pause(1);
		}
		return minPos;
	}
}
