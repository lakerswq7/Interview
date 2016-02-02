package sort;

public class ArrayQuickSort {
	public void quickSort(int[] Array, int low, int high) {
		if (low < high) {
			int index = partition(Array, low, high);
			quickSort(Array, low, index - 1);
			quickSort(Array, index + 1, high);
		}
	}
	public int partition(int[] Array, int low, int high) {
		int middle = (low + high) / 2;
		int pivot = Array[middle];
		swap(Array, low, middle);
		int last = low;
		for (int i = low + 1; i <= high; i++) {
			if (Array[i] <= pivot) {
				last++;
				swap(Array, last, i);
			}
		}
		swap(Array, low, last);
		return last;
	}
	public void swap(int[] Array, int a, int b) {
		if (a != b) {
			Array[a] = Array[a] + Array[b];
			Array[b] = Array[a] - Array[b];
			Array[a] = Array[a] - Array[b];
		}
	}
	
	public static void main(String[] args) {
		int[] Array = {2, 2, 3, 3, 2, 5, 3, 2, 1, 0, 8, 9, 99, 2, 3, 3, 3, 3, 4, 5, -1};
		ArrayQuickSort d = new ArrayQuickSort();
		d.quickSort(Array, 0, Array.length - 1);
		for (int c : Array)
			System.out.println(c);
	}
}
