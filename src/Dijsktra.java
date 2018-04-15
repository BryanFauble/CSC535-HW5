import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dijsktra {

    public Dijsktra() {

    }

    //Finds the node with the lowest cost from the source node, and then finds the next until all node costs are found. This guarantees an optimal solution because it is solved recursively.
    //Fun fact, I had a working algorithm, but on changing what order nodes were stored in on the list i'd get different results.
    //The problem being that the previously stored results the cost was relying on wasn't optimal, so it wasn't getting an optimal solution. This is required for best solution, not for 'ANY' solution.
    private Node getLowestNode(List<Node> pNodeList) {
        Node lowestNode = new Node();
        int lowDistance = 9999;

        for (Node node: pNodeList) {
            int distanceFromSource = node.getDistanceFromSource();
            if (distanceFromSource < lowDistance) {
                lowDistance = distanceFromSource;
                lowestNode = node;
            }
        }

        return lowestNode;
    }

    private void findMinimumDistance(Node pNodeToCheck, int pEdgeWeight, Node pSourceNode) {
        int sourceDistance = pSourceNode.getDistanceFromSource();

        if (sourceDistance + pEdgeWeight < pNodeToCheck.getDistanceFromSource()) {
            pNodeToCheck.setDistanceFromSource(sourceDistance + pEdgeWeight);
            List<Node> emptyNodeList = new ArrayList<>(); //This is needed otherwise if a path is found, but not taken it will have that old path information still there. Need to clear it
            pNodeToCheck.setShortestPath(emptyNodeList);
            pNodeToCheck.getShortestPath().addAll(pSourceNode.getShortestPath());
            pNodeToCheck.getShortestPath().add(pSourceNode);
        }
    }

    public void doDijsktra(List<Node> problemNodes) {
        Node source = problemNodes.get(0);
        source.setDistanceFromSource(0);

        List<Node> nodesCalculated = new ArrayList<>(); //nodes that have already been found
        List<Node> nodesToCalculate = new ArrayList<>(); //nodes that need to be found

        nodesToCalculate.add(source);

        while (!nodesToCalculate.isEmpty()) {
            Node currentNode = this.getLowestNode(nodesToCalculate);
            nodesToCalculate.remove(currentNode);

            //Checks each of the neighbors to see if pathing through the current node will produce a better solution than it already has. If it does then a new optimal solution was found.
            for (Map.Entry<Node, Integer> neighborNodeEntry : currentNode.getNeighborNodes().entrySet()) {
                int pathCost = neighborNodeEntry.getValue();
                Node neighborNode = neighborNodeEntry.getKey();

                if (!nodesCalculated.contains(neighborNode)) {
                    this.findMinimumDistance(neighborNode, pathCost, currentNode);
                    nodesToCalculate.add(neighborNode);
                }
            }

            nodesCalculated.add(currentNode);
        }

        //Remove any duplicates, happens when a path was foregone for a better path
        List<Node> nodesToUniqueify = new ArrayList<>();
        for (Node nodesToOrganize : nodesCalculated) {
            if (!nodesToUniqueify.contains(nodesToOrganize)) {
                nodesToUniqueify.add(nodesToOrganize);
            }
        }

        //Print to console
        for (Node printNodes : nodesToUniqueify) {
            for (Node shortNodeToPrint : printNodes.getShortestPath()) {
                System.out.print("node" + shortNodeToPrint.getNodeDescription() + " -> ");
            }
            System.out.println("node" + printNodes.getNodeDescription() + " (Cost: " + printNodes.getDistanceFromSource() + ")");
        }

        System.out.println("\nComplete with Dijsktra");
    }
}
