package ctci.ch06.ds;

public class FindPivotInRotatedSortedArray {
	
	
	public int findPivot(int[] array) {
		// finds the index of the minimum element in the array
		int l = 0;
		int r = array.length-1;
		while (l<r) {
			int m = l + (r-l)/2;
			if (array[m]>array[r]) {
				// pivot must be to the right of m
				l = m+1;
			} else {
				// pivot must be to the left of m
				r = m;
			}
			if (l==r) {
				return l;
			}
		}
		return -1;
	}
		
	public static void main(String[] args) {
		int[] array = {6,7,8,9,1,2,3,4,5};		
		System.out.print("Array   : ");
		for (int n : array) {
			System.out.print(n+" ");
		}
		System.out.println();
		System.out.println("Pivot at: "+ new FindPivotInRotatedSortedArray().findPivot(array));
		
	}

}
