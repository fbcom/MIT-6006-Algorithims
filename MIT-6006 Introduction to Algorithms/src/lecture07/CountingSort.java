package lecture07;

import java.util.List;
import java.util.LinkedList;

public class CountingSort<T extends HasIntKey> {

	/**
	 * Sorts stable in O(n) time and space.
	 * 
	 * @param array
	 */
	public void sort(T[] array) {
		if (array == null || array.length == 0)
			return;

		int k = array[0].getKey();
		for (T e : array) {
			int i = e.getKey();
			if (i < 0)
				throw new IllegalArgumentException("Unexpected negative number in array");
			k = i > k ? i : k;
		}
		k++;

		// initialize counters
		List<T>[] counter = new LinkedList[k];
		for (int i = 0; i < k; i++)
			counter[i] = new LinkedList();

		// count
		for (T e : array)
			counter[e.getKey()].add(e);

		// insert elements in sorted order back into the original array
		for (int i = 0, j = 0; i < k; i++)
			while (!counter[i].isEmpty())
				array[j++] = counter[i].remove(0);
	}

	public static void main(String[] args) {

		// compile an array to sort
		int[] tmp = { 4, 6, 1, 2, 2, 5, 6, 7, 3, 1, 0 };
		Sortable<String>[] array = new Sortable[tmp.length];
		int j = 0;
		for (int key : tmp) {
			array[j++] = new Sortable<String>(key, "v=" + (key));
		}

		// show
		System.out.print("Array : ");
		for (Sortable<String> e : array)
			System.out.print("(" + e.getKey() + ":" + e.getValue() + ") ");
		System.out.println();

		// sort
		CountingSort<Sortable<String>> foo = new CountingSort<>();
		foo.sort(array);

		// show
		System.out.print("Sorted: ");
		for (Sortable<String> e : array)
			System.out.print(e + " ");
		System.out.println();
	}

}
