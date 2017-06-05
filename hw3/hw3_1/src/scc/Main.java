package scc;

import java.util.Stack;
import java.util.ArrayList;

import scc.graph.*;

public class Main
{
	private static Stack<Vertex> stack = new Stack<>();
	private static ArrayList<Scc> scc = new ArrayList<>();

	public static void main(String[] args)
	{
		Graph G = new Graph(8);

		G.connect("a", "b");
		G.connect("b", "c");
		G.connect("b", "e");
		G.connect("b", "f");
		G.connect("c", "d");
		G.connect("c", "g");
		G.connect("d", "c");
		G.connect("d", "h");
		G.connect("e", "a");
		G.connect("e", "f");
		G.connect("f", "g");
		G.connect("g", "f");
		G.connect("g", "h");
		G.connect("h", "h");

		G.make_unvisit();

		DFS(G);

		for(int i=0; i<scc.size(); i++)
		{
			Scc s = scc.get(i);

			System.out.print(i + " : ");
			for(Vertex v : s.getAllVertex())
			{
				System.out.print(v.getName() + " ");
			}
			System.out.println("");
		}
	}

	public static void DFS(Graph G)
	{
		for(Vertex v : G.getAllVertex())
		{
			if(!v.isVisit())
				DFS_VISIT(v);
		}

		G.make_unvisit();

		while(!stack.empty())
		{
			Vertex v = stack.pop();

			if(!v.isVisit())
			{
				Scc s = new Scc();
				scc.add(s);
				makeScc(v, s);
			}
		}
	}


	public static void DFS_VISIT(Vertex v)
	{
		v.visit();	//make gray

		for(Vertex u : v.adjVertex())
		{
			if(!u.isVisit())
				DFS_VISIT(u);
		}	

		v.leave();
		stack.push(v);
	}

	public static void makeScc(Vertex v, Scc s)
	{
		v.visit();
		s.add(v);

		for(Vertex u : v.re_adjVertex())
		{
			if(!u.isVisit())
				makeScc(u, s);
		}	
	}
}
