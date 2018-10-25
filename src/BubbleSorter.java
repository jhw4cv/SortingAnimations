import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BubbleSorter {

	private int [] nums;
	private int swapPosition = -1;
	private int currentPosition = -1;
	private int alreadySorted = -1;
	private JComponent component;

	private static final int DELAY = 50;

	public BubbleSorter(int [] nums, JComponent component) {
		this.nums = nums;
		this.component = component;
	}


	public void pause(int steps) throws InterruptedException{
		this.component.repaint(); 
		Thread.sleep(steps * DELAY);
	}

	public void sort() throws InterruptedException{
		for(int i = 0; i < nums.length; i++) {
			this.alreadySorted = nums.length-i;
			for(int j = 0; j < nums.length - 1 - i; j++) {
				this.currentPosition = j;
				this.swapPosition = j + 1;
				try {
					if(nums[j+1] < nums[j]) {
						pause(1);
						swap(j, j+1);
					}
				}finally {
				} 
				pause(1);
			}
		}
	}

	public void swap(int a, int b) {
		int hold = nums[a];
		nums[a] = nums[b];
		nums[b] = hold;
	}

	public void draw(Graphics g) {
		try {
			int deltaX = this.component.getWidth() / nums.length;
			for(int i = 0; i < nums.length; i++) {
				if(i == this.currentPosition) {
					g.setColor(Color.GREEN);
				}
				else if(i == this.swapPosition) {
					g.setColor(Color.ORANGE);
				}
				else if(i >= this.alreadySorted) {
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