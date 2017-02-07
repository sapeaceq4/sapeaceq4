package App;

//@author akash
public class kthLargest {

	private static int QuickSortPartition(int[] A, int p, int r, int pivotIndex) {
		int index = p - 1;
		int pivot = A[pivotIndex];

		for (int j = p; j <= r; j++) {
			if (A[j] < pivot) {
				index++;
			}
		}
		return index + 1;
	}

	public static int findKthLargest(int[] A, int k) {
		if (null == A || A.length < 1 || (k > A.length || k < 1)) {
			// wrong input
			return -1;
		}
		int kth = k - 1;
		int index = -1;
		int pivotIndex = A.length - 1;
		while (kth != index && pivotIndex > -1) {
			index = QuickSortPartition(A, 0, A.length - 1, pivotIndex);
			pivotIndex--;
		}
		return A[index];
	}
}
