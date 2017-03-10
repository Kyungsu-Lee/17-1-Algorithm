
import sort.sort.*;

import java.util.*;

class main
{
	public static void main(String[] args)
	{
		SortManager sM = new InsertionSort();
	
		Random rd = new Random();
		int[] arr = new int[10000];
		for(int i=0; i<arr.length; i++)
			arr[i] = rd.nextInt();
		
		sM.setArrayForSort(arr);

		//sM.printArray();
		//System.out.println(sM.getAverageSortTime(100));
		System.out.println(sM.getAverageSortTime(1000));
		//sM.printSortedArray();
		
		SortManager sM2 = new MergeSort();
		sM2.setArrayForSort(arr);

		//sM2.printArray();
		System.out.println(sM2.getAverageSortTime(1000));
		//sM2.printSortedArray();
	}
}
