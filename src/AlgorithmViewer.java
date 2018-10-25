import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Project done for software development course
 * to illustrate basic sorting algorithms.
 */

public class AlgorithmViewer {

	public static void main(String [] args) {

		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 350;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Visualization of Sorting Algorithms");
		frame.setLayout(new GridLayout(3, 2));
		
		//Fills array 1-50
		int [] nums1 = new int[50];
		for(int i = 0; i < nums1.length; i++) {
			nums1[i] = i+1;
		}
		//Begin the swapping and shuffling numbers
		int swap;
		int hold;
		for(int i = 0; i < nums1.length; i++) {
			swap = (int)(Math.random()*50);
			hold = nums1[swap];
			nums1[swap] = nums1[i];
			nums1[i] = hold;
		}
		
		//create deep copy for nums2 and nums3
		int [] nums2 = new int[50];
		int [] nums3 = new int[50];
		for(int i = 0; i < nums1.length; i++) {
			nums2[i] = nums1[i];
			nums3[i] = nums1[i];
		}

		frame.add(new JLabel("<html>Selection Sort, black searches for minimum (green) and swaps with first element in unsorted section (red), increasing the sorted section (blue) by one.", SwingConstants.CENTER));
		final SelectionSortComponent selectionComponent = new SelectionSortComponent(nums1);
		frame.add(selectionComponent, BorderLayout.CENTER);
		
		frame.add(new JLabel("<html>Insertion Sort, inserts next element (orange) into proper spot (green) of sorted section (blue).", SwingConstants.CENTER));
		final InsertionSortComponent insertionComponent = new InsertionSortComponent(nums2);
		frame.add(insertionComponent, BorderLayout.CENTER);
		
		frame.add(new JLabel("<html>Bubble Sort, compares blue and orange, swaps if necessary, blue denotes sorted.", SwingConstants.CENTER));
		final BubbleSortComponent bubbleComponent = new BubbleSortComponent(nums3);
		frame.add(bubbleComponent, BorderLayout.CENTER);

		frame.setVisible(true);

		Thread bubbleThread = new Thread(bubbleComponent);
		Thread insertionThread = new Thread(insertionComponent);
		Thread selectionThread = new Thread(selectionComponent);
		
		insertionThread.start();
		bubbleThread.start();
		selectionThread.start();
		
	}

}
