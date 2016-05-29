package pie.chapter04;

public class QuickSort {

	public void quicksort(int[] array) {
		quicksort(array, 0, array.length-1);
	}
	
	private void quicksort(int[] array, int from, int to) {
		if (from > to) {
			return;
		}		
		int p = partition(array, from, to);
		quicksort(array, from, p-1);
		// p-th element is pivot (and stays untouched after partitioning)
		quicksort(array, p+1, to);
	}
	
	public int partition(int[] array, int from, int to) {
		int pivot = array[to];
		int i = from; // use for swapping
		for (int j=from; j<to; j++) {
			if (array[j] <= pivot) {
				int swap = array[i];
				array[i] = array[j];
				array[j] = swap;
				i = i + 1;
			}
		}
		int swap = array[i];
		array[i] = array[to];
		array[to] = swap;
		return i;
	}

		
	public static void main(String[] args) {
				
		QuickSort qs = new QuickSort();
		
		int[] array = {8,1,2,3,9,5,19,7,0};						
		for (Integer i: array) {
			System.out.print(i.toString() + " ");
		}
		System.out.println();
		qs.quicksort(array);

		for (Integer i: array) {
			System.out.print(i.toString() + " ");
		}
	}

}
