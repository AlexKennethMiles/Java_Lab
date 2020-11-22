package com.Miles.Lab_15_16;

import java.util.ArrayList;

public class Node {
    private String name;
    private ArrayList<Integer> connections = new ArrayList<>();
    private ArrayList<String> instructions = new ArrayList<>();
    private ArrayList<Node> states = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void setNode(int connection, String instruction, Node state) {
        // each communication number will correspond to the instruction number
        // and what state the current state will change to
        connections.add(connection);
        instructions.add(instruction);
        states.add(state);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public ArrayList<Node> getStates() {
        return states;
    }

}