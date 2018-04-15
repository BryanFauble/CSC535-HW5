import java.util.Scanner;

public class Main {

    private static final Node NODE = new Node();
    private static final Dijsktra DIJSKTRA = new Dijsktra();
    private static final BellmanFord BELLMAN_FORD = new BellmanFord();

    public static void main(String args[]) {
        Scanner scanner = new Scanner( System.in );

        boolean continueProgram = true;
        while (continueProgram) {

            System.out.print( "Type (1-6) on which program you want to run, or 7 for Help: " );
            String input = scanner.nextLine();
            System.out.println( "input = " + input );
            Integer readInt;

            try {
                readInt = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Oi, that ain't no number! " + ex);
            }

            switch (readInt) {
                case 1:
                    System.out.println("Starting Problem 1 with DIJSKTRA\n");
                    DIJSKTRA.doDijsktra(NODE.createNodesForProblem1());
                    break;
                case 2:
                    System.out.println("\nStarting Problem 2 with DIJSKTRA");
                    DIJSKTRA.doDijsktra(NODE.createNodesForProblem2());
                    break;
                case 3:
                    System.out.println("\nStarting Problem 3 with DIJSKTRA");
                    DIJSKTRA.doDijsktra(NODE.createNodesForProblem3());
                    break;
                case 4:
                    System.out.println("\nStarting Problem 1 with BELLMAN-FORD");
                    BELLMAN_FORD.doBellman(NODE.createNodesForProblem1());
                    break;
                case 5:
                    System.out.println("\nStarting Problem 2 with BELLMAN-FORD");
                    BELLMAN_FORD.doBellman(NODE.createNodesForProblem2());
                    break;
                case 6:
                    System.out.println("\nStarting Problem 3 with BELLMAN-FORD");
                    BELLMAN_FORD.doBellman(NODE.createNodesForProblem3());
                    break;
                case 7:
                    System.out.println("The following is a list of the program series:"
                            + "\n1) Graph 1 - DIJSKTRA"
                            + "\n2) Graph 2 - DIJSKTRA"
                            + "\n3) Graph 3 - DIJSKTRA"
                            + "\n4) Graph 1 - BELLMAN-FORD"
                            + "\n5) Graph 2 - BELLMAN-FORD"
                            + "\n6) Graph 3 - BELLMAN-FORD"
                            + "\n7) Help");
                    break;
                default:
                    continueProgram = false;
            }
        }
    }

}
