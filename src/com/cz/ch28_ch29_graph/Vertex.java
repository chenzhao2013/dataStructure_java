package com.cz.ch28_ch29_graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T> {

	private T label;
	private List<Edge> edgeList;
	private boolean visited = false;
	private VertexInterface<T> preVertex;
	private double cost;
	
	public Vertex(T vertexLabel) {
		this.label = vertexLabel;
		edgeList = new LinkedList<>();
		visited = false;
		preVertex = null;
		cost = 0;
	}
	@Override
	public T getLabel() {
		return label;
	}

	@Override
	public void visit() {
		this.visited = true;
	}

	@Override
	public void unvisit() {
		this.visited = false;
	}

	@Override
	public boolean isVisited() {
		return visited;
	}

	/**
	 * 不添加自身、不添加重复边
	 */
	@Override
	public boolean connect(VertexInterface<T> endVertex, double weight) {
		boolean result = false;
		if(!this.equals(endVertex)) {
			Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
			boolean dumplicatEdge = false;
			while(!dumplicatEdge && neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if(this.equals(nextNeighbor)) {
					dumplicatEdge = true;
				}
			}
			if(!dumplicatEdge) {
				edgeList.add(new Edge(endVertex, weight));
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex, 0);
	}
	
	@Override
	public Iterator<VertexInterface<T>> getNeighborIterator() {
		return new NeighborIterator();
	}

	@Override
	public Iterator<Double> weightIterator() {
		return new WeightIterator();
	}

	@Override
	public boolean hasNeighbor() {
		return !edgeList.isEmpty();
	}

	public boolean hasUnvisitedNeigh() {
		boolean has = false;
		Iterator<VertexInterface<T>> neiIte = getNeighborIterator();
		while(!has && neiIte.hasNext()) {
			VertexInterface<T> next = neiIte.next();
			if(!next.isVisited()) {
				has = true;
				//break;
			}
		}
		return has;
	}
	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {
		boolean found = false;
		VertexInterface<T> neighbor = null;
		Iterator<VertexInterface<T>> iterator = getNeighborIterator();
		while(!found && iterator.hasNext()) {
			VertexInterface<T> nextNeighbor = iterator.next();
			if(!nextNeighbor.isVisited()) {
				found = true;
				neighbor = nextNeighbor;
			}
		}
		return neighbor;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		this.preVertex = predecessor;
	}

	@Override
	public VertexInterface<T> getPredcessor() {
		return this.preVertex;
	}

	@Override
	public void setCost(double newCost) {
		this.cost = newCost;
	}

	@Override
	public double getCost() {
		return cost;
	}

	protected class Edge{
		private VertexInterface<T> endVertex;
		private double weight;
		protected Edge(VertexInterface<T> endVertext, double weight) {
			this.endVertex = endVertext;
			this.weight = weight;
		}
		public VertexInterface<T> getEndVertex() {
			return endVertex;
		}
		public double getWeight() {
			return weight;
		}
	}

	private class NeighborIterator implements Iterator<VertexInterface<T>>{
		private Iterator<Edge> edgeIte;
		private NeighborIterator() {
			edgeIte = edgeList.iterator();
		}
		@Override
		public boolean hasNext() {
			return edgeIte.hasNext();
		}
		@Override
		public VertexInterface<T> next() {
			VertexInterface<T> vertex = null;
			if(edgeIte.hasNext()) {
				Edge edge = edgeIte.next();
				vertex = edge.getEndVertex();
			} else {
				throw new NoSuchElementException();
			}
			return vertex;
		}
	}
	private class WeightIterator implements Iterator<Double>{
		private Iterator<Edge> edgeIte;
		public WeightIterator() {
			edgeIte = edgeList.iterator();
		}
		@Override
		public boolean hasNext() {
			return edgeIte.hasNext();
		}
		@Override
		public Double next() {
			if(edgeIte.hasNext()) {
				Edge edge = edgeIte.next();
				return edge.getWeight();
			}
			return null;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj==null || getClass() != obj.getClass()) {
			result = false;
		} else {
			@SuppressWarnings("unchecked")
			Vertex<T> otherVertex = (Vertex<T>) obj;
			result = this.label.equals(otherVertex.getLabel());
		}
		return result;
	}
}
