package scc.graph;

import java.util.ArrayList;

public class Vertex
{
	private static int index = 0;

	private boolean WHITE 	= true;	// unvisited.
	private boolean GRAY	= false;	// visited, not visit near vertex
	private boolean BLACK	= false;	// visited.
	
	private String name = "";

	private ArrayList<Vertex> adj;	
	private ArrayList<Vertex> re_adj;

	public Vertex(String name)
	{
		this.name = name;
		make_unvisit();

		adj = new ArrayList<Vertex>();
		re_adj = new ArrayList<Vertex>();
	}

	public void make_direct(Vertex v)
	{
		this.adj.add(v);
		v.re_direct(this);
	}

	public void re_direct(Vertex v)
	{
		this.re_adj.add(v);
	}

	public String getName()
	{
		return this.name;
	}

	public ArrayList<Vertex> adjVertex()
	{
		return adj;
	}

	public ArrayList<Vertex> re_adjVertex()
	{
		return re_adj;
	}
	
	public void make_unvisit()
	{
		this.WHITE 	= true;
		this.GRAY 	= false;
		this.BLACK 	= false;
	}

	public void visit()
	{
//		System.out.println("+ visit " + this.name);
		
		this.WHITE 	= false;
		this.GRAY	= true;
		this.BLACK 	= false;
	}

	public void leave()
	{
//		System.out.println("- leave " + this.name);

		this.WHITE	= false;
		this.GRAY	= false;
		this.BLACK	= true;
	}

	public boolean isVisit()
	{
		return !this.WHITE;
	}

}
