import sort.sort.*;

import java.util.*;

class main
{
	public static final int TESTNUM = 5100;

	public static void main(String[] args)
	{
		SortManager insertionSort 	= new InsertionSort();
		SortManager mergeSort 		= new MergeSort();
		SortManager selectionSort 	= new SelectionSort();
		SortManager javaSort		= new CollectionSort();
		//for best case (already sorted)
		String result = "";

		System.out.println("FOR BEST CASE");
		result += "\t\tinsertion sort  merge sort  selection sort  java sort\n\n";
		for(int length = 100; length <= TESTNUM; length += 50)
		{
			int[] arr = new int[length];

			for(int i=0; i<length; i++)
				arr[i] = i;
		
			insertionSort.setArrayForSort(arr);
			mergeSort.setArrayForSort(arr);
			selectionSort.setArrayForSort(arr);
			javaSort.setArrayForSort(arr);

			result += "1~"+length;
			result += "\t\t" + insertionSort.getAverageSortTime(100);
			result += "\t\t" + mergeSort.getAverageSortTime(100);
			result += "\t\t" + selectionSort.getAverageSortTime(100);
			result += "\t\t" + javaSort.getAverageSortTime(100);
			result += "\n\n";
	
			System.out.println(result);
			result = "";
		}

		System.out.println("FOR WORST CASE");
		result += "\t\tinsertion sort  merge sort  selection sort  java sort\n\n";
		for(int length = 100; length <= TESTNUM; length += 50)
		{
			int[] arr = new int[length];

			for(int i=0; i<length; i++)
				arr[i] = length - i;
		
			insertionSort.setArrayForSort(arr);
			mergeSort.setArrayForSort(arr);
			selectionSort.setArrayForSort(arr);
			javaSort.setArrayForSort(arr);

			result += "1~"+length;
			result += "\t\t" + insertionSort.getAverageSortTime(100);
			result += "\t\t" + mergeSort.getAverageSortTime(100);
			result += "\t\t" + selectionSort.getAverageSortTime(100);
			result += "\t\t" + javaSort.getAverageSortTime(100);
			result += "\n\n";
	
			System.out.println(result);
			result = "";
		}

		ArrayList<int[]> array = new ArrayList<int[]>();
		System.out.println("FOR RANDOM CASE");
		result += "\t\tinsertion sort  merge sort  selection sort  java sort\n\n";
		for(int length = 100; length <= TESTNUM; length += 50)
		{
			int[] arr = new int[length];

			Random rd = new Random();

			for(int i=0; i<length; i++)
				arr[i] = Math.abs(rd.nextInt());
			array.add(arr);		

			insertionSort.setArrayForSort(arr);
			mergeSort.setArrayForSort(arr);
			selectionSort.setArrayForSort(arr);
			javaSort.setArrayForSort(arr);

			result += "1~"+length;
			result += "\t\t" + insertionSort.getAverageSortTime(100);
			result += "\t\t" + mergeSort.getAverageSortTime(100);
			result += "\t\t" + selectionSort.getAverageSortTime(100);
			result += "\t\t" + javaSort.getAverageSortTime(100);
			result += "\n\n";
	
			System.out.println(result);
			result = "";
		}

		System.out.println("\n\nRamdom Array");
		for(int[] arr : array)
		{
			for(int i=0; i < arr.length; i++)
			{
				System.out.print(arr[i] + " " );
			}
			System.out.println("");
		}
	}
}
