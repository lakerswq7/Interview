package sort;

public class ArrayMergeSort {
	public void mergeSort(int[] Array,int[] help, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(Array, help, low, middle);
			mergeSort(Array, help, middle + 1, high);
			merge(Array, help, low, middle, high);
		}
	}
	
	public void merge(int[] Array, int[] help, int low, int middle, int high) {
		int current = low;
		int left = low;
		int right = middle + 1;
		for (int i = low; i <= high; i++) {
			help[i] = Array[i];
		}
		while ((left <= middle) && (right <= high)) {
			if (help[left] <= help[right]) {
				Array[current] = help[left];
				left++;
			} else {
				Array[current] = help[right];
				right++;
			}
			current++;
		}
		while(left <= middle) {
			Array[current] = help[left];
			current++;
			left++;
		}
	}
	public static void main(String[] args) {
		int[] Array = {2, 2, 3, 3, 2, 5, 3, 2, 1, 0, 8, 9, 99, 2, 3, 3, 3, 3, 4, 5, -1};
		int[] help = new int[Array.length];
		ArrayMergeSort a = new ArrayMergeSort();
		a.mergeSort(Array, help, 0, Array.length - 1);
		for (int r : Array) {
			System.out.print(r + " ");
		}
		
	}
}
