package main.java.algorithms.graph;

import main.java.datastructures.graph.Edge;
import main.java.datastructures.graph.WeightedGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Dijkstra {
	Map<Integer, Double> distance;
	private WeightedGraph graph;

	public Dijkstra(WeightedGraph graph) {
		this.graph = graph;
		distance = new HashMap<>();
	}

	public void shortestPath(Integer source) {

		Set<Integer> openSet = new TreeSet<>();
		for (Integer vertex : graph.getVertices()) {
			if (source.equals(vertex)) {
				distance.put(source, 0d);
			} else {
				distance.put(source, Double.POSITIVE_INFINITY);
			}
			openSet.add(vertex);
		}
		while (!openSet.isEmpty()) {

			Integer min = 0;
			double minDis = Double.POSITIVE_INFINITY;
			for (Integer vertex : openSet) {
				if (minDis > distance.get(vertex)) {
					minDis = distance.get(vertex);
					min = vertex;
				}
			}

			openSet.remove(min);
			for (Edge edge : graph.getEdges(min)) {
				Double newPath = distance.get(min) + edge.getWeight();
				if (distance.get(edge.getTo()) > newPath) {
					distance.put(edge.getTo(), newPath);
				}
			}
		}


	}


}

