package ctci.ch06.ds;

public class BinSearchInRotatedSortedArray {

	public int findPivot(int[] array) {
		// finds the index of the minimum element in the array
		int l = 0;
		int r = array.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (array[m] > array[r]) // pivot must be to the right of m
				l = m + 1;
			else // pivot must be to the left of m
				r = m;
		}
		return l;
	}

	public int findIndex(int[] array, int n) {
		int pivot = findPivot(array);

		int l, r;
		if (pivot == 0) {
			l = 0;
			r = array.length - 1;
		} else {
			l = pivot;
			r = pivot - 1;
			if (array[0] > n) {
				l = r;
				r = array.length;
			} else {
				l = 0;
				r = pivot - 1;
			}
		}

		int m = l;
		while (l < r) {
			m = l + (r - l) / 2;
			if (array[m] == n)
				return m;
			if (array[m] < n)
				l = m + 1;
			else
				r = m - 1;
			if (l == r)
				return m;
		}
		return m;
	}

	public static void main(String[] args) {
		BinSearchInRotatedSortedArray rbs = new BinSearchInRotatedSortedArray();

		int[] array = { 6, 7, 8, 9, 1, 2, 3, 4, 5 };
		System.out.print("Array is : ");
		for (int n : array) {
			System.out.print(n + " ");
		}
		System.out.print("\nPivot at : " + rbs.findPivot(array));
		System.out.println();
		for (int n : array) {
			System.out.println(n + " is at index " + rbs.findIndex(array, n));
		}

	}

}
