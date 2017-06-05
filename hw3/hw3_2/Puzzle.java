public class Puzzle
{
	Puzzle up;
	Puzzle down;
	Puzzle left;
	Puzzle right;

	private Puzzle parent;

	int[] state = new int[9];
	int index;
	int f, g, h;

	public void setState(int[] state)
	{
		this.state = state;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public int getIndex()
	{
		return this.index;
	}

	public Puzzle getParent()
	{
		return this.parent;
	}

	public void setParent(Puzzle parent)
	{
		this.parent = parent;
	}

	public void makeVoid()
	{
		up = down = left = right = null;
	}
}
