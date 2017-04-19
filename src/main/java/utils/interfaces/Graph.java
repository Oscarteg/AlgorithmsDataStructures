package utils.interfaces;

import java.util.Set;

/**
 * Created by Oscar on 08/04/2017.
 */
public interface Graph {
	boolean addVertex(Integer t);

	Double addEdge(Integer from, Integer to);

	boolean addEdge(Integer from, Integer to, Double weight);

	boolean removeVertex(Integer t);

	boolean removeEdge(Integer from, Integer to);

	Set<Integer> getVertices();

	Set<Integer> getNeighbors(Integer ver);

	int size();
}
