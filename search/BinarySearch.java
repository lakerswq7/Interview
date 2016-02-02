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
			// ������ܴ��ʱ�򣬷�ֹhigh + low���
			mid = low + (high - low) / 2;
			if (A[mid] == a) {
				// ���û��duplicate��ֱ�ӷ��أ�����У�Ҫ������ǰ�滹��������һ������ʱ��Ҫ����
				high = mid;
			} else if (A[mid] > a) {
				high = mid;
			} else if (A[mid] < a) {
				low = mid;
			}
		}
		// �����жϵ�˳��Ҳ��Ҫǰ��һ�����Ǻ���һ���й�
		if (A[low] == a) {
			return low;
		}
		if (A[high] == a) {
			return high;
		}
		return -1;
	}
}
