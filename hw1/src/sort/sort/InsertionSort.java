package sort.sort;

public class InsertionSort extends SortManager
{
	@Override
		protected void sort(int[] array)
		{
			for (int i = 1; i < array.length; i++) {
				int pivot = array[i]; 
				int tmp = i - 1;

				while (tmp >= 0 && pivot > array[tmp]) {
					array[tmp + 1] = array[tmp]; 
					tmp--;
				}
				array[tmp + 1] = pivot;
			}
		}

}
