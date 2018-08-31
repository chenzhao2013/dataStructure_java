package com.cz.ch28_ch29_graph;

import java.util.HashMap;
import java.util.Map;

public class DirectedGraph<T> implements BasicGraphInterface<T> {

	private Map<T, VertexInterface<T>> vertextMap;
	private int edgeCount;
	
	public DirectedGraph() {
		vertextMap = new HashMap<>();
		edgeCount = 0;
	}
	@Override
	public boolean addVertex(T vertexLabel) {
		VertexInterface<T> vertexInterface = vertextMap.put(vertexLabel, new Vertex<T>(vertexLabel));
		return vertexInterface == null;
	}

	@Override
	public boolean addEdge(T begin, T end, double weight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNOOfVertex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNOOfEdge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
