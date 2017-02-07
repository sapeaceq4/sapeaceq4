package App;

public class TestMergeSort {

	public static void main(String[] args) {

		int[] A = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		MergeSort.sort(A);

		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}
