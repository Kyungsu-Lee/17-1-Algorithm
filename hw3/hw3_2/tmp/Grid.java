
public class Grid
{
	public enum DIRECTION {UP, DOWN, RIGHT, LEFT};

	private int value = -1;
	private int position;

	public Grid(int num)
	{
		this.value = num;
		position = Integer.toString(value).indexOf("9");
	}

	public void toDirection(DIRECTION direction)  
	{
		switch(direction)
		{
			case UP: toUp(); break;
			case DOWN : toDown(); break;
			case RIGHT : toRight(); break;
			case LEFT : toLeft(); break;
		}
	}


	public int toUp()  
	{
		if(position <= 2)
			return -1;

		return position-3;
	}

	public int toDown()  
	{
		if(position >= 6)
			return -1;

		return position+3;
	}

	public int toRight()  
	{
		if(position%3 == 2)
			return -1;

		return position+1;
	}

	public int toLeft()  
	{
		if(position%3 == 0)
			return -1;

		return position-1;
	}

	public void changeElement(int n, int m)	 
	{
		String str = Integer.toString(value);

		char tmp1 = str.charAt(n);
		char tmp2 = str.charAt(m);
		
		str = str.replace(tmp1, '-');
		str = str.replace(tmp2, tmp1);
		str = str.replace('-', tmp2);

		try
		{
			value = Integer.parseInt(str);
		}
		catch(Exception e)
		{
		}
		position = m;
	}
	

	@Override
	public String toString()
	{
		return Integer.toString(value);
	}

	public void show()
	{
		String str = Integer.toString(value);

		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(str.charAt(i*3 + j) != '9')
				System.out.print(str.charAt(i*3+j) + "");
				else
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public int getValue()
	{
		return value;
	}

	public int getPosition()
	{
		return this.position;
	}

	public boolean check()
	{
		return value == 123894765;
	}
}

