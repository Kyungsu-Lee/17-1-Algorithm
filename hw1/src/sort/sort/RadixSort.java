package sort.sort;

public class RadixSort extends SortManager
{
	@Override
	public void sort(int[] array) 
	{
		for (int shift = Integer.SIZE - 1; shift > -1; shift--) 
		{
			int[] tmp = new int[array.length];
			int j = 0;
			for (int i = 0; i < array.length; i++) 
			{
				boolean move = array[i] << shift >= 0;
				if (shift == 0 ? !move : move) 
				{
					tmp[j] = array[i];
					j++;
				} 
				else 
				{
					array[i - j] = array[i];
				}
			}
			for (int i = j; i < tmp.length; i++) 
			{
				tmp[i] = array[i - j];
			}
			array = tmp;
		}
	}
}
