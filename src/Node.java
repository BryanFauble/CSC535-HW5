import java.util.*;

public class Node {

    private int nodeID;
    private Map<Node, Integer> neighborNodes = new HashMap<>();
    private List<Node> shortestPath = new ArrayList<>();
    private char nodeDescription;
    private int distanceFromSource = 9999;

    public Node(int pNodeID, char pNodeDescription) {
        nodeID = pNodeID;
        nodeDescription = pNodeDescription;
    }

    //Default constructor, shouldn't be used except to access methods.
    public Node() {

    }

    //Sets up the graph for the nodes in problem 1
    public List<Node> createNodesForProblem1() {
        Node nodeS = new Node(0, 'S');
        Node nodeA = new Node(1, 'A');
        Node nodeB = new Node(2, 'B');
        Node nodeC = new Node(3, 'C');
        Node nodeD = new Node(4, 'D');
        Node nodeT = new Node(5, 'T');

        nodeS.addNeighbor(nodeA, 4);
        nodeS.addNeighbor(nodeB, 6);

        nodeA.addNeighbor(nodeC, 2);
        nodeA.addNeighbor(nodeD, 1);

        nodeB.addNeighbor(nodeA, 2);
        nodeB.addNeighbor(nodeD, 2);

        nodeC.addNeighbor(nodeD, 1);
        nodeC.addNeighbor(nodeT, 3);

        nodeD.addNeighbor(nodeT, 7);

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(nodeS);
        nodeList.add(nodeA);
        nodeList.add(nodeB);
        nodeList.add(nodeC);
        nodeList.add(nodeD);
        nodeList.add(nodeT);
        return nodeList;
    }

    //Sets up the graph for the nodes in problem 2
    public List<Node> createNodesForProblem2() {
        Node nodeA = new Node(0, 'A');
        Node nodeB = new Node(1, 'B');
        Node nodeC = new Node(2, 'C');
        Node nodeD = new Node(3, 'D');
        Node nodeE = new Node(4, 'E');

        nodeA.addNeighbor(nodeB, 10);
        nodeA.addNeighbor(nodeE, 5);

        nodeB.addNeighbor(nodeC, 1);
        nodeB.addNeighbor(nodeE, 2);

        nodeC.addNeighbor(nodeD, 4);

        nodeD.addNeighbor(nodeC, 6);
        nodeD.addNeighbor(nodeA, 7);

        nodeE.addNeighbor(nodeB, 3);
        nodeE.addNeighbor(nodeC, 9);
        nodeE.addNeighbor(nodeD, 2);

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(nodeA);
        nodeList.add(nodeB);
        nodeList.add(nodeC);
        nodeList.add(nodeD);
        nodeList.add(nodeE);
        return nodeList;
    }

    //Sets up the graph for the nodes in problem 3
    public List<Node> createNodesForProblem3() {
        Node nodeA = new Node(0, 'A');
        Node nodeB = new Node(1, 'B');
        Node nodeC = new Node(2, 'C');
        Node nodeD = new Node(3, 'D');
        Node nodeE = new Node(4, 'E');
        Node nodeF = new Node(5, 'F');
        Node nodeG = new Node(6, 'G');
        Node nodeH = new Node(7, 'H');
        Node nodeJ = new Node(8, 'J');
        Node nodeK = new Node(9, 'K');


        nodeA.addNeighbor(nodeB, 1);
        nodeA.addNeighbor(nodeE, 1);

        nodeB.addNeighbor(nodeA, 1);
        nodeB.addNeighbor(nodeC, 1);

        nodeC.addNeighbor(nodeB, 1);
        nodeC.addNeighbor(nodeF, 3);
        nodeC.addNeighbor(nodeG, 1);
        nodeC.addNeighbor(nodeJ, 4);

        nodeD.addNeighbor(nodeE, 5);
        nodeD.addNeighbor(nodeH, 1);
        nodeD.addNeighbor(nodeK, 1);
        nodeD.addNeighbor(nodeJ, 2);

        nodeE.addNeighbor(nodeA, 1);
        nodeE.addNeighbor(nodeG, 1);
        nodeE.addNeighbor(nodeD, 5);

        nodeF.addNeighbor(nodeK, 1);
        nodeF.addNeighbor(nodeC, 3);

        nodeG.addNeighbor(nodeE, 5);
        nodeG.addNeighbor(nodeC, 1);
        nodeG.addNeighbor(nodeH, 1);

        nodeH.addNeighbor(nodeG, 1);
        nodeH.addNeighbor(nodeD, 1);

        nodeJ.addNeighbor(nodeC, 4);
        nodeJ.addNeighbor(nodeD, 2);

        nodeK.addNeighbor(nodeD, 1);
        nodeK.addNeighbor(nodeF, 1);


        List<Node> nodeList = new ArrayList<>();
        nodeList.add(nodeA);
        nodeList.add(nodeE);
        nodeList.add(nodeF);
        nodeList.add(nodeH);
        nodeList.add(nodeK);
        nodeList.add(nodeD);
        nodeList.add(nodeB);
        nodeList.add(nodeG);
        nodeList.add(nodeC);
        nodeList.add(nodeJ);

        return nodeList;
    }

    //Getters and setts for instance variables of Node ============
    public void addNeighbor(Node pNode, int pWeight) {
        this.neighborNodes.put(pNode, pWeight);
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public Map<Node, Integer> getNeighborNodes() {
        return neighborNodes;
    }

    public void setNeighborNodes(Map<Node, Integer> neighborNodes) {
        this.neighborNodes = neighborNodes;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public char getNodeDescription() {
        return nodeDescription;
    }

    public void setNodeDescription(char nodeDescription) {
        this.nodeDescription = nodeDescription;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    @Override
    public String toString() {
        String retString = "Node{" +
                "nodeID=" + nodeID;

        for (Map.Entry<Node, Integer> nNodes : neighborNodes.entrySet()) { //Need to print like this otherwise it'll infinite loop try to print neighbor nodes
            retString.concat("" + nNodes.getKey().getNodeID() + nNodes.getValue()); //Bad, will cause memory leak in large applications.
        }

        return retString +
                ", nodeDescription=" + nodeDescription + '}';
    }
}
