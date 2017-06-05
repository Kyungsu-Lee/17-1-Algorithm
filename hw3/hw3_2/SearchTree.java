import java.util.ArrayList;

public class SearchTree
{
	private ArrayList<Puzzle> stack = new ArrayList<>();
	private ArrayList<Integer> init = new ArrayList<>();

	private Puzzle root;

	private int numOfNodes;
	private int length;
	
	private boolean success;

	public SearchTree()
	{
		this.root = null;
	}

	public boolean isEmpty()
	{
		return this.root == null;
	}

	public boolean move(Puzzle from, Puzzle to, char direction)
	{
		int index = from.getIndex();
		to.state = new int[length * length];

		if(to.state == null)
			System.out.println("aa");
		if(from.state == null)
			System.out.println(from);

		for(int i=0; i < numOfNodes; i++)
			to.state[i] = from.state[i];

		int tmp;
		switch(direction)
		{
			case 'u' : 
				to.setIndex(index - length);
				if(from.getParent() != null)
					if(to.getIndex() == from.getParent().getIndex())
						return false;
				//swap
				tmp = to.state[index];
				to.state[index] = to.state[index - length];
				to.state[index - length] = tmp;

				from.up = to;
				break;

			case 'd' : 
				to.setIndex(index + length);
				if(from.getParent() != null)
					if(to.getIndex() == from.getParent().getIndex())
						return false;
				//swap
				tmp = to.state[index];
				to.state[index] = to.state[index + length];
				to.state[index + length] = tmp;

				from.down = to;
				break;
			case 'l' : 
				to.setIndex(index - 1);
				if(from.getParent() != null)
					if(to.getIndex() == from.getParent().getIndex())
						return false;
				//swap
				tmp = to.state[index];
				to.state[index] = to.state[index -1];
				to.state[index - 1] = tmp;

				from.left = to;
				break;
			case 'r' : 
				to.setIndex(index + 1);
				if(from.getParent() != null)
					if(to.getIndex() == from.getParent().getIndex())
						return false;
				//swap
				tmp = to.state[index];
				to.state[index] = to.state[index + 1];
				to.state[index + 1] = tmp;

				from.right = to;
				break;
		}
		return true;
	}

	public void checkSuccess(Puzzle puzzle)
	{
		boolean u, d, l, r;
		u = d = r = l = true;

		if(puzzle.up != null)
		{
			for(int i=0; (i < numOfNodes) && u; i++)
				u &= (puzzle.up.state[i] == i);
		}
		else
			u = false;

		if(puzzle.down != null)
		{
			for(int i=0; (i < numOfNodes) && d; i++)
				d &= (puzzle.down.state[i] == i);
		}
		else
			d = false;

		if(puzzle.left!= null)
		{
			for(int i=0; (i < numOfNodes) && l; i++)
				l &= (puzzle.left.state[i] == i);
		}
		else
			l = false;

		if(puzzle.right != null)
		{
			for(int i=0; (i < numOfNodes) && r; i++)
				r &= (puzzle.right.state[i] == i);
		}
		else
			r = false;

		if(u) print(puzzle.up);
		if(d) print(puzzle.down);
		if(l) print(puzzle.left);
		if(r) print(puzzle.right);

		success = u | d | r | l;

		if(success)
		{
			stack = new ArrayList<>();
			System.out.println("succ");
		}
	}

	public void build()
	{
		make();
		this.setRoot(init);
		while(!success)
			insert();
	}

	public void setRoot(ArrayList<Integer> init)
	{
		Puzzle tmp = new Puzzle();
		tmp.state = new int[length * length];

		for(int i=0; i<numOfNodes; i++)
			tmp.state[i] = init.get(i);

		tmp.up = tmp.down = tmp.left = tmp.right = null;
		tmp.g = 0;
		setHash(tmp);
		tmp.f = tmp.g + tmp.h;

		for(int i=0; i< numOfNodes; i++)
			if(tmp.state[i] == 0)
				tmp.setIndex(i);

		if(isEmpty())
		{
			root = tmp;
			stack.add(root);
		}
	}

	public void insert()
	{
		Puzzle u = new Puzzle();
		Puzzle d = new Puzzle();
		Puzzle l = new Puzzle();
		Puzzle r = new Puzzle();
	
		Puzzle from = stack.get(0);
		stack.remove(0);
		

		if(from.index / length != 0 && move(from, u, 'u'))
		{
			u.g = from.g + 1;
			setHash(u);
			u.f = u.g + u.h;
			u.makeVoid();
			u.setParent(from);
			stack.add(u);
			if(u.state == null) System.out.printf("1");
		}
		if(from.index / length != length - 1 && move(from, d, 'd'))
		{
			d.g = from.g + 1;
			setHash(d);
			d.f = d.g + d.h;
			d.makeVoid();
			d.setParent(from);
			stack.add(l);
			if(d.state == null) System.out.printf("2");
		}
		if(from.index % length != 0 && move(from, l, 'l'))
		{
			l.g = from.g + 1;
			setHash(l);
			l.f = l.g + l.h;
			l.makeVoid();
			l.setParent(from);
			stack.add(l);
			if(l.state == null) System.out.printf("3");
		}
		if(from.index % length != length - 1 && move(from, r, 'r'))
		{
			r.g = from.g + 1;
			setHash(r);
			r.f = r.g + r.h;
			r.makeVoid();
			r.setParent(from);
			stack.add(r);
			if(r.state == null) System.out.printf("4");
		}

		checkSuccess(from);
		sortTree();
	}

	public void sortTree()
	{
		Puzzle tmp;

		for(int i=0; i< stack.size() - 1; i++)
		{
			for(int j = 0; j < stack.size() - 1; j++)
			{
				if(stack.get(j).f > stack.get(j+1).f)
				{
					tmp = stack.get(j);
					stack.set(j, stack.get(j+1));
					stack.set(j+1, tmp);
				}
			}
		}
	}

	public void setHash(Puzzle puzzle)
	{
		int h = 0;
		puzzle.h = 0;
		
		for(int i=0; i < numOfNodes; i++)
		{
			h = Math.abs(puzzle.state[i] - i);
			h = (h%length) + (h/length);
			puzzle.h += h;
		}
	}

	public void make()
	{
		numOfNodes = 9;
	
		for(int i=0; i<9; i++)
			init.add(i);	

		length = 3;
	}

	public void print(Puzzle from)
	{
		ArrayList<Puzzle> puzzle = new ArrayList<>();

		while(from != null)
		{
			puzzle.add(from);
			from = from.getParent();
		}

		for(int i = puzzle.size() - 1; i >= 0; i--)
		{
			for(int j=0; j<numOfNodes; j++)
			{
				System.out.print(puzzle.get(i).state[j] + " ");
				if(j%length == length-1)
				System.out.println("");
			}
			System.out.println("");
		}
	}
}
