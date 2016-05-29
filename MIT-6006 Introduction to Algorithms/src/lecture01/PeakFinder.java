package lecture01;

import java.util.*;

class PeakFinder<T extends Comparable> {

	/**
	 * Checks if the array contains a peak
	 * 
	 * @param array
	 * @return boolean
	 */
	public boolean hasPeak(T[] array) {
		return array.length > 0;
	}

	/**
	 * Finds the first peak in array
	 * 
	 * @param array
	 *            T[]
	 * @return T
	 */
	public T findPeak(T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (isPeakAt(array, i)) {
				return array[i];
			}
		}
		return null; // should only happen when the array is empty
	}

	/**
	 * Returns whether the element at position index in array is a peak or not
	 * 
	 * @param array
	 *            T[]
	 * @param index
	 *            int
	 * @return
	 */
	public boolean isPeakAt(T[] array, int index) {
		if (array.length <= 1) { // no elements and one element
			return array.length == 1;
		}
		if (index == 0) { // left edge
			return array[index].compareTo(array[index + 1]) >= 0;
		}
		if (index == array.length - 1) { // right edge
			return array[index].compareTo(array[index - 1]) >= 0;
		}
		// somewhere in between
		if ((array[index].compareTo(array[index + 1]) >= 0) && (array[index].compareTo(array[index - 1]) >= 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a list of all peaks in array
	 * 
	 * @param array
	 *            T[]
	 * @return List<T> containing all peak elements
	 */
	public List<T> findAllPeaks(T[] array) {
		List<T> ret = new LinkedList<T>();
		for (int i = 0; i < array.length; i++) {
			if (isPeakAt(array, i)) {
				ret.add(array[i]);
			}
		}
		return ret;
	}

	// Testing
	public static void main(String[] args) {

		// Generate an array of random integers
		int n = 10;
		Integer[] array = new Integer[n];
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			array[i] = rnd.nextInt() % n;
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// Find peaks
		PeakFinder<Integer> finder = new PeakFinder<Integer>();
		System.out.println("hasPeak:" + finder.hasPeak(array));
		System.out.println("findPeak:" + finder.findPeak(array));
		List<Integer> peaks = finder.findAllPeaks(array);
		for (Integer p : peaks) {
			System.out.println("allPeaks:" + p);
		}
	}
}
