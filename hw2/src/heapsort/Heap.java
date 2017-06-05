package heapsort;

public class Heap extends HeapIterator
{
	private final int DEFAULT_SIZE = 15;


	public Heap()
	{
		items = new int[DEFAULT_SIZE+1];
	}

	public Heap(int size)
	{
		items = new int[size+1];
	}

	public boolean isEmpty()
	{
		return this.currentIdx == 1;
	}

	public boolean isFull()
	{
		return this.currentIdx == items.length + 1;
	}

	public void insertItem(int item)
	{
		if(isEmpty())
			addLength();			

		System.out.print("before insert : ");
		for(int i=0; i<currentIdx; i++)
			System.out.print(items[i] + " ");
		System.out.println("");

		this.items[currentIdx++] = item;

		makeTree(currentIdx-1);

		System.out.print("after insert : ");
		for(int i=0; i<currentIdx; i++)
			System.out.print(items[i] + " ");
		System.out.println("\n");
	}

	private void swap(int idx1, int idx2)
	{
		int tmp = items[idx1];
		items[idx1] = items[idx2];
		items[idx2] = tmp;	
	}

	private int getParent(int idx)	throws Exception
	{
		if(idx == 1)
			throw new Exception("OUT OF IDX");

		return this.items[idx/2];
	}

	private void makeTree(int idx)
	{
		if(idx == 1)
			return;

		try
		{
			if(items[idx] > getParent(idx))
			{	
				swap(idx, idx/2);	//swap items with idx
				makeTree(idx/2);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void makeTreeReverse(int idx, int maxIdx)
	{
		if(idx >= maxIdx || maxIdx == 1)
			return;

		int max = 0;

		try
		{
			max = items[idx * 2] > items[idx * 2 + 1] ? idx * 2 : idx * 2 + 1;
		}
		catch(Exception e)
		{
			return;
		}

		if(max > maxIdx)
			return;

		if(items[idx] >= items[max])
			return;

		swap(idx, max);

		makeTreeReverse(max, maxIdx);
	}

	private void sort(int idx)
	{	System.out.print("sorting : ");
		for(int item : toArray())
			System.out.print(item + " ");
		System.out.println("");
			

		if(idx == 1)
			return;

		if(idx != 2 || idx == 2 && items[1] > items[idx])
			swap(1, idx);
		makeTreeReverse(1, idx-1);

		sort(idx-1);
	}

	private boolean checkTree()
	{
		boolean flag = true;

		for(int i=1; i < currentIdx; i++)
		{
			if(i * 2 >= currentIdx || i * 2 + 1 >= currentIdx)
				continue;

			flag &= (items[i] > items[2 * i] && items[i] > items[2 * i + 1]);
		}

		return flag;
	}

	public void sort()
	{
		sort(currentIdx-1);
	}

	public int[] toArray()
	{	
		int[] arr = new int[items.length-2];
		for(int i=1; i < items.length-1; i++)
			arr[i-1] = items[i];

		return arr;
	}
}
