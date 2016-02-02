package search;

public class BinarySearch {
	public int binarySearch(int a, int[] A) {
		if ((A == null) || (A.length == 0)) {
			return -1;
		}
		int low = 0;
		int high = A.length - 1;
		int mid;
		while (low + 1 < high) {
			// 在数组很大的时候，防止high + low溢出
			mid = low + (high - low) / 2;
			if (A[mid] == a) {
				// 如果没有duplicate就直接返回，如果有，要返回最前面还是最后面的一个，这时需要处理
				high = mid;
			} else if (A[mid] > a) {
				high = mid;
			} else if (A[mid] < a) {
				low = mid;
			}
		}
		// 这里判断的顺序也跟要前面一个还是后面一个有关
		if (A[low] == a) {
			return low;
		}
		if (A[high] == a) {
			return high;
		}
		return -1;
	}
}
