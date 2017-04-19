package algorithms.graph.DijkstraPriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {

	private List<Edge> listEdges = new ArrayList<Edge>();

	public void addEdge(String[] line) {
		Vertex v1 = findVertexByLabel(line[0].trim());

		if (v1 == null) {
			v1 = new Vertex(line[0].trim());
		}

		Vertex v2 = findVertexByLabel(line[1].trim());
		if (v2 == null) {
			v2 = new Vertex(line[1].trim());
		}

		int value = Integer.parseInt(line[2].trim());
		addEdge(v1, v2, value);
	}

	public void addEdge(Vertex v1, Vertex v2, int value) {
		Edge e = new Edge(v1, v2, value);
		v1.addEdge(e);
		v2.addEdge(e);
		listEdges.add(e);
	}

	public PriorityQueue<Vertex> getVertices() {
		PriorityQueue<Vertex> vertices = new PriorityQueue<Vertex>();
		for (Edge e : listEdges) {
			for (Vertex v : e.getVertices()) {
				if (!vertices.contains(v)) {
					vertices.add(v);
				}
			}
		}
		return vertices;
	}

	public void printVertices() {
		for (Vertex v : getVertices()) {
			System.out.println(v);
		}
	}

	public void printEdges() {
		for (Edge e : listEdges) {
			System.out.println(e);
		}
	}

	public Vertex findVertexByLabel(String label) {
		for (Vertex v : getVertices()) {
			if (v.getLabel().equalsIgnoreCase(label)) {
				return v;
			}
		}
		return null;
	}

}
