package sort.sort;

public class SelectionSort extends SortManager
{
	@Override
		protected void sort(int array[]) 
		{
			for(int i=0; i<array.length-1; i++) 
			{
				int min = i;
				for(int j=i+1; j<array.length; j++) 
					if(array[j] < array[min]) 
						min = j;

				swap(array, min, i); 
			}
		}

	public  void swap(int a[], int idx1, int idx2) 
	{
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}    
}
