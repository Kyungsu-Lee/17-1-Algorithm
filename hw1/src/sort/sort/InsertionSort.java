package sort.sort;

public class InsertionSort extends SortManager
{
	@Override
	protected void sort(int[] array)
	{
		for (int i = 1; i < array.length; i++) {
			int standard = array[i];
			int aux = i - 1;   

			while (aux >= 0 && standard < array[aux]) {
				array[aux + 1] = array[aux];   
				aux--;
			}
			array[aux + 1] = standard;  
		}
	}
}

