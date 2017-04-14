package main.algorithms.graph.DijkstraPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Edge {

	private Vertex v1;
	private Vertex v2;
	private int value;

	public Edge(Vertex v1, Vertex v2, int value) {
		this.v1 = v1;
		this.v2 = v2;
		this.value = value;
	}

	public Vertex getOtherVertex(Vertex currentVertex) {
		if (currentVertex.equals(v1)) {
			return v2;
		} else if (currentVertex.equals(v2)) {
			return v1;
		} else {
			return null;
		}

	}

	public String toString() {
		return v1.getLabel() + " - " + v2.getLabel() + " value: " + value;
	}

	public int getValue() {
		return value;
	}

	public List<Vertex> getVertices() {
		List<Vertex> list = new ArrayList<Vertex>();
		list.add(v1);
		list.add(v2);
		return list;
	}
}
