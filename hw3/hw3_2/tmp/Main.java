import java.util.*;

public class Main 
{
	public static int num = 0;
	public static int imx = 0;

	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static HashSet<Integer> block = new HashSet<Integer>();
	public static Stack<Integer> stack = new Stack<Integer>();

	public static Grid g;

	public static void main(String[] args)
	{
		int n = 523619874;

		g = new Grid(n);
		map.put(g.getValue(), imx++);
		stack.push(g.getValue());
		g.show();
		System.out.println("");
		if(g.check())
			return;

		if(g.toUp() > 0)
			move(g.toUp());
		if(g.toDown() > 0)
			move(g.toDown());
		if(g.toRight() > 0)
			move(g.toRight());
		if(g.toLeft() > 0)
			move(g.toLeft());

		g.show();
	}

	public static boolean move(int idx)
	{
		Grid origin = new Grid(g.getValue());

		g.changeElement(g.getPosition(), idx);
		Grid tmp = new Grid(g.getValue());		
		if(g.check())	return true;
		if(map.containsKey(g.getValue()) || block.contains(g.getValue()) || imx > 20) 
			return false;

		System.out.println("=======");
		System.out.println(origin.getPosition() + "=>" + idx);
		System.out.println(imx);
		origin.show();
		System.out.println("");
		g.show();
		System.out.println("");
		System.out.println("");
	

		map.put(g.getValue(), imx);
		int tmp_idx = imx++;
		
		boolean flag = false;
	
		if(g.toUp() > 0)
			flag |= move(g.toUp());
		if(!flag)
			g = new Grid(tmp.getValue());
		if(!flag && g.toDown() > 0)
			flag |= move(g.toDown());
		if(!flag)
			g = new Grid(tmp.getValue());
		if(!flag && g.toRight() > 0)
			flag |= move(g.toRight());
		if(!flag)
			g = new Grid(tmp.getValue());
		if(!flag && g.toLeft() > 0)
			flag |= move(g.toLeft());

		if(!flag)
		{
			block.add(g.getValue());
			g = new Grid(tmp.getValue());
			map.remove(tmp.getValue());
			imx = tmp_idx;
		}

		return flag;
	}
}


