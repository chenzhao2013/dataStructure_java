package com.cz.ch28_ch29_graph;

public interface BasicGraphInterface<T> {

	boolean addVertex(T vertexLabel);
	boolean addEdge(T begin, T end, double weight);
	boolean addEdge(T begin, T end);
	boolean hasEdge(T begin, T end);
	boolean isEmpty();
	int getNOOfVertex();
	int getNOOfEdge();
	void clear();
}
