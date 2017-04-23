import heapsort.*;
import java.util.*;

public class main
{
	public static void main(String[] args)
	{
			int[] arr = new int[]{8, 2, 6, 3, 27, 16, 19, 21, 15, 11, 23};
		

			System.out.print("before sort : ");
			for(int item : arr)
				System.out.print(item + " ");
			System.out.println("");

			Heap heap = new Heap(arr.length);

			for(int i=0; i<arr.length; i++)
				heap.insertItem(arr[i]);


			heap.sort();



			System.out.print("after sort : ");
			for(int item : heap.toArray())
				System.out.print(item + " ");
			System.out.println("");


	}
}
