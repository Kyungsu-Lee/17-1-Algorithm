package sort.sort;

import java.util.Arrays;

public class CollectionSort extends SortManager
{
	public CollectionSort()
	{	
	}

	@Override
	protected void sort(int[] array)
	{
		Arrays.sort(array);
	}

}
