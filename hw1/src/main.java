import sort.sort.*;

class main
{
	public static void main(String[] args)
	{
		SortManager sM = new InsertionSort();
		int[] arr = {2,10,8,7,6};
		sM.setArrayForSort(arr);

		sM.printArray();
		System.out.println(sM.getSortTime());
		sM.printArray();
	}
}
