package searching_sorting;

public class QuickSortV2 {
	private int[] data;

	public QuickSortV2(int[] data) {
		this.data = data;

	}

	public void quickSort(int left, int right) {
		if (right - left <= 0) {
			return;// finish sorting.
		} else {
			int pivot = data[right];
			int partition = partition(left, right, pivot);
			quickSort(left, partition - 1);
			quickSort(partition + 1, right);
		}
	}

	public int partition(int left, int right, int pivot) {
		int leftPart = left - 1;
		int rightPart = right;

		while (true) {
			while (data[++leftPart] < pivot)
				;

			while (rightPart > 0 && data[--rightPart] > pivot)
				;
			if (leftPart >= rightPart) {
				break;
			} else {
				swap(leftPart, rightPart);
			}
			
		}
		swap(leftPart, right);
		return leftPart;
	}

	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;

	}
}
