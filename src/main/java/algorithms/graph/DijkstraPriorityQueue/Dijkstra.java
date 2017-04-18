package main.java.algorithms.graph.DijkstraPriorityQueue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Dijkstra {

	private static Graph graph;

	public static void main(String[] args) {

		graph = new Graph();

		Dijkstra dijkstra = new Dijkstra();
		dijkstra.fillGraphWithSampleData();
		graph.printEdges();
		List<Vertex> shortestPath = dijkstra.findShortestPath("barneveld", "leiden");
		graph.printVertices();
		System.out.println("Shortest path is:" + shortestPath);

	}

	public void fillGraphWithSampleData() {
		String fileName = "./graph.txt";
		System.out.println(fileName);
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(line -> graph.addEdge(line.split(",")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setValue(PriorityQueue<Vertex> vertices, Vertex v, int value) {
		vertices.remove(v);
		v.setValue(value);
		vertices.add(v);
	}

	public List<Vertex> findShortestPath(String from, String to) {
		Vertex fromVertex = graph.findVertexByLabel(from);
		Vertex toVertex = graph.findVertexByLabel(to);
		PriorityQueue<Vertex> vertices = graph.getVertices();
		setValue(vertices, fromVertex, 0);
		while (!vertices.isEmpty()) {
			setValueForNeighbouringVertices(vertices, vertices.poll());
		}
		return getRoute(fromVertex, toVertex);
	}

	public List<Vertex> getRoute(Vertex from, Vertex to) {
		LinkedList<Vertex> list = new LinkedList<Vertex>();
		while (to.getRoute() != null) {
			list.addFirst(to);
			to = to.getRoute();
		}
		list.addFirst(from);
		return list;

	}

	public void setValueForNeighbouringVertices(PriorityQueue<Vertex> vertices, Vertex vertex) {

		vertex.setVisited();
		for (Edge e : vertex.getEdges()) {
			Vertex linkedVertex = e.getOtherVertex(vertex);

			if (!linkedVertex.isVisited()) {
				if (linkedVertex.getValue() >= e.getValue() + vertex.getValue()) {

					setValue(vertices, linkedVertex, e.getValue() + vertex.getValue());
					linkedVertex.setPreviousVertex(vertex);
				}
			}
		}

	}
}
