package com.cz.ch28_ch29_graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DirectedGraph<T> implements BasicGraphInterface<T> {

	private Map<T, VertexInterface<T>> vertexMap;
	private int edgeCount;
	
	public DirectedGraph() {
		vertexMap = new HashMap<>();
		edgeCount = 0;
	}
	@Override
	public boolean addVertex(T vertexLabel) {
		VertexInterface<T> vertexInterface = vertexMap.put(vertexLabel, new Vertex<T>(vertexLabel));
		return vertexInterface == null;
	}

	@Override
	public boolean addEdge(T begin, T end, double weight) {
		boolean result = false;
		VertexInterface<T> beginV = vertexMap.get(begin);
		VertexInterface<T> endV = vertexMap.get(end);
		if(beginV != null && endV != null) {
			result = beginV.connect(endV, weight);
		}
		if(result)
			edgeCount++;
		return result;
	}

	@Override
	public boolean addEdge(T begin, T end) {
		return addEdge(begin, end, 0);
	}

	@Override
	public boolean hasEdge(T begin, T end) {
		boolean found = false;
		VertexInterface<T> beginV = vertexMap.get(begin);
		VertexInterface<T> endV = vertexMap.get(end);
		if(beginV!=null && endV!=null) {
			Iterator<VertexInterface<T>> neighborIte = beginV.getNeighborIterator(); 
			while(!found && neighborIte.hasNext()) {
				VertexInterface<T> vertex = neighborIte.next();
				if(endV.equals(vertex))
					found = true;
			}
		}
		return found;
	}

	@Override
	public boolean isEmpty() {
		return vertexMap.isEmpty();
	}

	@Override
	public int getNOOfVertex() {
		return vertexMap.size();
	}

	@Override
	public int getNOOfEdge() {
		return edgeCount;
	}

	@Override
	public void clear() {
		vertexMap.clear();
	}

	protected void resetVertex() {
		Iterator<Map.Entry<T, VertexInterface<T>>> entryIte = vertexMap.entrySet().iterator();
		while(entryIte.hasNext()) {
			Map.Entry<T, VertexInterface<T>> entry = entryIte.next();
			VertexInterface<T> vertex = entry.getValue();
			vertex.setCost(0);
			vertex.setPredecessor(null);
			vertex.unvisit();
		}
	}
	
	public LinkedList<T> getBreadthFirstTraversal(T origin) {
		resetVertex();
		LinkedList<T> traversalOrder = new LinkedList<>();
		LinkedList<VertexInterface<T>> vertexQueue = new LinkedList<>();
		VertexInterface<T> startVertex = vertexMap.get(origin);
		startVertex.visit();
		traversalOrder.offerLast(origin);
		vertexQueue.offerLast(startVertex);
		while(!vertexQueue.isEmpty()) {
			VertexInterface<T> currVertex = vertexQueue.pollFirst();
			Iterator<VertexInterface<T>> neighborIte = currVertex.getNeighborIterator();
			while(neighborIte.hasNext()) {
				VertexInterface<T> nextNeighbor = neighborIte.next();
				if(!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					vertexQueue.offerFirst(nextNeighbor);
					traversalOrder.offerLast(nextNeighbor.getLabel());
				} //end if
			} //end while
		} // end while
		return traversalOrder;
	}
	public LinkedList<T> getDepthFirstTraversal(T origin){
		LinkedList<T> traversalOrder = new LinkedList<>();
		LinkedList<VertexInterface<T>> vertexStack = new LinkedList<>();
		VertexInterface<T> startVertex = vertexMap.get(origin);
		startVertex.visit();
		vertexStack.push(startVertex);
		traversalOrder.offerLast(origin);
		while(!vertexStack.isEmpty()) {
			VertexInterface<T> currVer = vertexStack.peek();
			VertexInterface<T> unvistedNeighbor = currVer.getUnvisitedNeighbor();
			if(unvistedNeighbor != null) {
				unvistedNeighbor.visit();
				traversalOrder.push(unvistedNeighbor.getLabel());
				vertexStack.push(unvistedNeighbor);
			} else {
				vertexStack.pop();
			}
		}
		return traversalOrder;
	}
}
