package heapsort;

public abstract class HeapIterator
{
	
	protected int[] items;
	protected int currentIdx = 1;
	private int iteratorIdx = 1;

	protected void addLength()
	{
		int[] newItems = new int[items.length + 1];
		
		for(int i=0; i<items.length; i++)
			newItems[i] = items[i];

		items = newItems;
	}

	public int getCurrentItem()
	{	
		System.out.println("idx : " + iteratorIdx);
		return this.items[iteratorIdx];
	}

	public void toParent()
	{
		if(this.iteratorIdx == 1)
			return;

		iteratorIdx /= 2;
	}

	public void toLeft()
	{
		int tmpIdx = iteratorIdx;
		
		iteratorIdx = 2* iteratorIdx ;
		
		if(iteratorIdx > items.length)
			iteratorIdx = tmpIdx;
	
	}

	public void toRight()
	{
		int tmpIdx = iteratorIdx;
		
		iteratorIdx = 2* iteratorIdx + 1;
		
		if(iteratorIdx > items.length)
			iteratorIdx = tmpIdx;
	}

}
