package sort.sort;

public class InsertionSort extends SortManager
{
	@Override
	protected void sort(int[] arr)
	{
		for (int i = 1; i < arr.length; i++) {
			int standard = arr[i];
			int aux = i - 1;   

			while (aux >= 0 && standard < arr[aux]) {
				arr[aux + 1] = arr[aux];   
				aux--;
			}
			arr[aux + 1] = standard;  
		}
	}
}

