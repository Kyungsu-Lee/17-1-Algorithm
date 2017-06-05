package scc.graph;

import java.util.ArrayList;

public class Graph
{
	private int size;
	private Vertex[] vertexes;

	public Graph(int size)
	{
		this.size = size;
		this.vertexes = new Vertex[size];

		for(int i=0; i<size; i++)
			vertexes[i] = new Vertex(Character.toString((char)('a' + i)));
	}

	public void connect(String a, String b)
	{
		Vertex v1 = null;
		Vertex v2 = null;
	
		for(int i=0; i<this.size; i++)
		{
			if(vertexes[i].getName().equals(a))
				v1 = vertexes[i];
		
			if(vertexes[i].getName().equals(b))
				v2 = vertexes[i];
		}

		v1.make_direct(v2);
	}

	public Vertex[] getAllVertex()
	{
		return this.vertexes;
	}

	public void make_unvisit()
	{
		for(Vertex v : vertexes)
			v.make_unvisit();
	}
}
