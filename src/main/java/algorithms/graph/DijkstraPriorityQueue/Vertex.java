package algorithms.graph.DijkstraPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private List<Edge> listEdges = new ArrayList<Edge>();
	private String label;
	private int value = Integer.MAX_VALUE;
	private boolean visited = false;
	private Vertex previousVertext;


	public Vertex(String label) {
		this.label = label;
	}

	public void addEdge(Edge edge) {
		listEdges.add(edge);
	}


	public String getLabel() {
		return label;
	}

	public List<Edge> getEdges() {
		return listEdges;
	}

	public String toString() {
		return value + " " + label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setVisited() {
		visited = true;
	}

	public boolean isVisited() {
		return visited;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		return ((Integer) value).compareTo(otherVertex.getValue());
	}


	public void setPreviousVertex(Vertex previousVertext) {
		this.previousVertext = previousVertext;
	}


	public Vertex getRoute() {
		return previousVertext;
	}
}

