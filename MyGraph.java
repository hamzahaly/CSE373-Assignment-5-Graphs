import java.util.*;

/**
 * A representation of a graph. Assumes that we do not have negative cost edges
 * in the graph.
 */
public class MyGraph implements Graph {
	// you will need some private fields to represent the graph
	// you are also likely to want some private helper methods

	private Map<Vertex, Set<Vertex>> adjacencyList;
	private List<Vertex> vertexList; 
	private List<Edge> edgeList;
	private Map<Vertex, Set<Edge>> graphInfo;
	
	
	/**
	 * Creates a MyGraph object with the given collection of vertices and the
	 * given collection of edges.
	 * 
	 * @param v
	 *            a collection of the vertices in this graph
	 * @param e
	 *            a collection of the edges in this graph
	 */
	public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
		// YOUR CODE HERE
		adjacencyList = new HashMap<Vertex, Set<Vertex>>();
		vertexList = new ArrayList<Vertex>();
		edgeList = new ArrayList<Edge>();
		graphInfo = new HashMap<Vertex, Set<Edge>>();
		
//		Iterator<Vertex> vertexItr = v.iterator();
		Iterator<Edge> edgeItr = e.iterator();
		
		
		while (edgeItr.hasNext()) {
			Edge edge = edgeItr.next();
			if (!adjacencyList.containsKey(edge.getSource())) {
				adjacencyList.put(edge.getSource(), new HashSet<Vertex>());	
			}
			adjacencyList.get(edge.getSource()).add(edge.getDestination());
			adjacencyList.put(edge.getSource(), adjacencyList.get(edge.getSource()));
		}
		
		// Create a map to efficiently look up information about a particular vertex.
//		for (Vertex vertex: v) {
//			if(!graphInfo.containsKey(vertex)){
//				graphInfo.put(vertex, new HashSet<Edge>());
//			}
//			graphInfo.put(vertex, edge);
//		}
	}

	/**
	 * Return the collection of vertices of this graph
	 * 
	 * @return the vertices as a collection (which is anything iterable)
	 */
	@Override
	public Collection<Vertex> vertices() {
		return vertexList;

	}

	/**
	 * Return the collection of edges of this graph
	 * 
	 * @return the edges as a collection (which is anything iterable)
	 */
	@Override
	public Collection<Edge> edges() {
		return edgeList;
	}

	/**
	 * Return a collection of vertices adjacent to a given vertex v. i.e., the
	 * set of all vertices w where edges v -> w exist in the graph. Return an
	 * empty collection if there are no adjacent vertices.
	 * 
	 * @param v
	 *            one of the vertices in the graph
	 * @return an iterable collection of vertices adjacent to v in the graph
	 * @throws IllegalArgumentException
	 *             if v does not exist.
	 */
	@Override
	public Collection<Vertex> adjacentVertices(Vertex v) { // JUST RETURN THE VALUE FROM THE GIVEN KEY
		List<Vertex> adjacentVerticies = new ArrayList<Vertex>();
		if (adjacencyList.containsKey(v)) {
			Iterator<Vertex> vertexItr = adjacencyList.get(v).iterator();
			while (vertexItr.hasNext()) {
				Vertex adjacentVertex = vertexItr.next();
				adjacentVerticies.add(adjacentVertex);
			}
		}
		return adjacentVerticies;
	}

	/**
	 * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed
	 * graph. Assumes that we do not have negative cost edges in the graph.
	 * 
	 * @param a
	 *            one vertex
	 * @param b
	 *            another vertex
	 * @return cost of edge if there is a directed edge from a to b in the
	 *         graph, return -1 otherwise.
	 * @throws IllegalArgumentException
	 *             if a or b do not exist.
	 */
	@Override
	public int edgeCost(Vertex a, Vertex b) {
		if (!adjacencyList.containsKey(a) || !adjacencyList.containsKey(b)) {
			throw new IllegalArgumentException();
		}
		if (isAdjacent(a, b)) {
			Set<Edge> edgeList = graphInfo.get(a);
			Iterator<Edge> edgeItr = edgeList.iterator();
			while (edgeItr.hasNext()) {
				Edge edge = edgeItr.next();
				if (edge.getDestination().equals(b)) {
					return edge.getWeight();
				}
			}
		}
		return -1;
	}

	/**
	 * Test to see if vertex b is adjacent to vertex a in a directed graph.
	 * Assumes that we do not have negative cost edges in the graph.
	 * @param a
	 * 				one vertex
	 * @param b
	 * 				another vertex
	 * @return true if the b is adjacent to a. Otherwise false.
	 */
	private boolean isAdjacent(Vertex a, Vertex b) {
		return adjacencyList.get(a).contains(b);
	}

	/**
	 * Returns the shortest path from a to b in the graph, or null if there is
	 * no such path. Assumes all edge weights are nonnegative. Uses Dijkstra's
	 * algorithm.
	 * 
	 * @param a
	 *            the starting vertex
	 * @param b
	 *            the destination vertex
	 * @return a Path where the vertices indicate the path from a to b in order
	 *         and contains a (first) and b (last) and the cost is the cost of
	 *         the path. Returns null if b is not reachable from a.
	 * @throws IllegalArgumentException
	 *             if a or b does not exist.
	 */
	public Path shortestPath(Vertex a, Vertex b) {

		// YOUR CODE HERE (you might comment this out this method while doing
		// Part 1)
		
		Path path = new Path(vertexList, 0);
		return path;

	}

}
