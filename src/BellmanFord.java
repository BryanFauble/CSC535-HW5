import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    //This works on edges, rather than vertices. Need to create an edge list to work on.

    /**
     * Prints out the bellman algorithm for a given list of nodes in a graph.
     * @param pProblemNodes List of nodes.
     */
    public void doBellman(List<Node> pProblemNodes) {
        pProblemNodes.get(0).setDistanceFromSource(0);

        final List<Edge> edgeList = this.createListOfEdges(pProblemNodes);

        for (int loop = 1; loop < pProblemNodes.size(); loop++) {
            for (int j = 0; j < edgeList.size(); j++) {
                final int weight = edgeList.get(j).getWeight();
                final Node sourceNode = edgeList.get(j).getSourceNode();
                final Node destinationNode = edgeList.get(j).getDestinationNode();

                if (sourceNode.getDistanceFromSource() + weight < destinationNode.getDistanceFromSource()) {
                    destinationNode.setDistanceFromSource(sourceNode.getDistanceFromSource() + weight);

                    //Adds nodes to the shortest path list to print out the order later on.
                    List<Node> emptyNodeList = new ArrayList<>();
                    destinationNode.setShortestPath(emptyNodeList);
                    destinationNode.getShortestPath().addAll(sourceNode.getShortestPath());
                    destinationNode.getShortestPath().add(sourceNode);
                }
            }
        }

        //Print to console
        for (Node printNodes : pProblemNodes) {
            for (Node shortNodeToPrint : printNodes.getShortestPath()) {
                System.out.print("node" + shortNodeToPrint.getNodeDescription() + " -> ");
            }
            System.out.println("node" + printNodes.getNodeDescription() + " (Cost: " + printNodes.getDistanceFromSource() + ")");
        }

        System.out.println("\nComplete with Bellman");
    }

    /**
     * Creates a list of edges using a given graph contains a bunch of nodes.
     * @param pNodeList List of nodes.
     * @return List of Edges.
     */
    public List<Edge> createListOfEdges(List<Node> pNodeList) {
        //Creates a list of edges in the graph from the existing Node list.
        List<Edge> edgeList = new ArrayList<>();
        for (Node node : pNodeList) {
            for (Node nNode : node.getNeighborNodes().keySet()) {
                Edge newEdge = new Edge();

                newEdge.sourceNode = node;
                newEdge.destinationNode = nNode;

                newEdge.weight = node.getNeighborNodes().get(nNode);
                edgeList.add(newEdge);
            }
        }

        return edgeList;
    }

}
