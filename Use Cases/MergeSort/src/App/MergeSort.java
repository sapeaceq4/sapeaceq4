package App;

public class MergeSort {

	public static void sort(int[] A) {
		if (null == A || A.length < 1) {
			return;
		}
		mergeSort(A, 0, A.length - 1);
	}

	private static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r - 1) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	private static void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int[] left = new int[n1 + 2];
		int[] right = new int[n2 + 2];

		for (int i = 1; i <= n1; i++) {
			left[i] = A[p + i - 1];
		}
		// left [n1+1] = infinite
		left[left.length - 1] = 99999999;

		for (int j = 1; j <= n2; j++) {
			right[j] = A[q + j];
		}
		// right [n2+1] = infinite
		right[right.length - 1] = 99999999;

		int i = 1;
		int j = 1;

		for (int k = p; k <= r; k++) {
			if (left[i] <= right[j]) {
				A[k] = left[i];
				i++;
			} else {
				A[k] = right[j];
				j++;
			}
		}

	}
}
