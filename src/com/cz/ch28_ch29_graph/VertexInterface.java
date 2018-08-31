package com.cz.ch28_ch29_graph;

import java.util.Iterator;

public interface VertexInterface<T> {
	T getLabel();
	void visit();
	void unvisit();
	boolean isVisited();
	boolean connect(VertexInterface<T> endVertex, double weight);
	boolean connect(VertexInterface<T> endVertex);
	Iterator<VertexInterface<T>> getNeighborIterator();
	Iterator<Double> weightIterator();
	boolean hasNeighbor();
	VertexInterface<T> getUnvisitedNeighbor();
	void setPredecessor(VertexInterface<T> predecessor);
	VertexInterface<T> getPredcessor();
	void setCost(double newCost);
	double getCost();
}
