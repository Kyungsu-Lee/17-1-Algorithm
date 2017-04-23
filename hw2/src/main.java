import heapsort.*;
import java.util.*;

public class main
{
	public static void main(String[] args)
	{
		for(int k=100; k<101; k++)
		{
			Random rd = new Random();

			int[] arr = new int[k];
			for(int i=0; i<arr.length; i++)
				arr[i] = Math.abs(rd.nextInt() % (k+1));

			for(int item : arr)
				System.out.print(item + " ");
			System.out.println("");

			Heap heap = new Heap(arr.length);

			for(int i=0; i<arr.length; i++)
				heap.insertItem(arr[i]);


			heap.sort();

			boolean flag = true;

			for(int item : heap.toArray())
				System.out.print(item + " ");
			System.out.println("");

			for(int i=0; i<heap.toArray().length-1; i++)
				flag &= heap.toArray()[i] <= heap.toArray()[i+1];

			System.out.println(flag);
			if(!flag)
			{
				System.out.println("error : " + k);
				return;
			}
		}

		System.out.println("success");
	}
}
