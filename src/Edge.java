public class Edge {

    Node sourceNode;
    Node destinationNode;
    int weight;

    Edge() {
        weight = 0;
        sourceNode = new Node();
        destinationNode = new Node();
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Node getDestinationNode() {
        return destinationNode;
    }

    public void setDestinationNode(Node destinationNode) {
        this.destinationNode = destinationNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}