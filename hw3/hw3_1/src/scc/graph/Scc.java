package scc.graph;

import java.util.ArrayList;

public class Scc
{
	private ArrayList<Vertex> vertex;
	
	public Scc()
	{
		this.vertex = new ArrayList<Vertex>();
	}

	public void add(Vertex v)
	{
		this.vertex.add(v);
	}

	public ArrayList<Vertex> getAllVertex()
	{
		return this.vertex;
	}
}
