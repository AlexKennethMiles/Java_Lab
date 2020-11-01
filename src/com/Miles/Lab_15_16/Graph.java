package com.Miles.Lab_15_16;

import java.util.ArrayList;

public class Graph {
    Node S1 = new Node();
    Node S2 = new Node();
    Node S3 = new Node();
    Node S4 = new Node();
    Node S5 = new Node();
    Node head = S1; // current state (under the terms)
    private ArrayList<String> result = new ArrayList<>(); // list of resulting instructions

    public Graph() { // create Graph
        S1.setNode(0, "create_project", S2);
        S1.setNode(1, "add_library", S5);
        S2.setNode(0, "test", S3);
        S2.setNode(1, "drop_db", S4);
        S3.setNode(0, "drop_db", S4);
        S3.setNode(1, "add_library", S5);
        S4.setNode(0, "restart", S3);
        S4.setNode(1, "deploy", S5);
        S5.setNode(0, "deploy", S1);
        S5.setNode(1, "restart", S3);
    }

    public void move(int connection) {
        for (int i = 0; i < head.getConnections().size(); i++) { // looking at the list of node links
            if (head.getConnections().get(i) == connection) { // did we find this connection?
                result.add(head.getInstructions().get(i)); // write the action in the result
                head = head.getStates().get(i); // moving along this connection in the graph
            }
        }
    }

    public void getInstructions() {
        for (String res : result) {
            System.out.println(res);
        }
    }
}
