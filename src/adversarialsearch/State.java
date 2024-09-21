package adversarialsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public class State {
    char[][] board; // The board as a 2D character array [height][width]
    int[] agentX;   // The x-coordinates of the agents, agentX[0] = x_agent0 
    int[] agentY;   // The y-coordinates of the agents, agentY[0] = y_agent0 
    int[] score;    // The amount of food eaten by each agent
    int turn;       // Whose turn it is, agent 0 or agent 1
    int food;       // The total amount of food still available

    public State() {
        // Initialize the game state
        agentX = new int[2];
        agentY = new int[2];
        score = new int[2];
        turn = 0;
        food = 0;
    }

    // Read the board from a file
    public void read(String file) {
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(file));

            // Read the dimensions of the board
            String[] dimensions = lines.get(0).split(" ");
            int height = Integer.parseInt(dimensions[0]);
            int width = Integer.parseInt(dimensions[1]);

            // Initialize the board with the dimensions
            board = new char[height][width];

            // Read the board content
            for (int i = 0; i < height; i++) {
                String line = lines.get(i + 1);
                for (int j = 0; j < width; j++) {
                    board[i][j] = line.charAt(j);
                    // Identify agent positions and count food
                    if (line.charAt(j) == 'A') {
                        agentX[0] = j;
                        agentY[0] = i;
                    } else if (line.charAt(j) == 'B') {
                        agentX[1] = j;
                        agentY[1] = i;
                    } else if (line.charAt(j) == 'F') {
                        food++;
                    }
                }
            }
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    // Method to return the state as a string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Board:\n");
        for (char[] row : board) {
            sb.append(new String(row)).append("\n");
        }
        sb.append("Agent 0 Position: (").append(agentX[0]).append(", ").append(agentY[0]).append(")\n");
        sb.append("Agent 1 Position: (").append(agentX[1]).append(", ").append(agentY[1]).append(")\n");
        sb.append("Scores: Agent 0 = ").append(score[0]).append(", Agent 1 = ").append(score[1]).append("\n");
        sb.append("Turn: Agent ").append(turn).append("\n");
        sb.append("Remaining Food: ").append(food).append("\n");
        return sb.toString();
    }

    // Method to return a copy of the state
    public State copy() {
        State copy = new State();
        copy.board = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy.board[i] = board[i].clone();
        }
        copy.agentX = agentX.clone();
        copy.agentY = agentY.clone();
        copy.score = score.clone();
        copy.turn = turn;
        copy.food = food;
        return copy;
    }

    // Method to get legal moves for an agent
    public Vector<String> legalMoves(int agent) {
        Vector<String> moves = new Vector<>();
        // Add logic to generate legal moves for the agent
        return moves;
    }

    // Method to get legal moves for the current agent
    public Vector<String> legalMoves() {
        return legalMoves(turn);
    }

    // Method to execute a move
    public void execute(String action) {
        // Add logic to execute the move
    }

    // Method to check if the state is a leaf
    public boolean isLeaf() {
        // Add logic to check if the state is a leaf
        return false; // Placeholder
    }

    // Method to evaluate the state
    public double value(int agent) {
        // Add logic to evaluate the state
        return 0; // Placeholder
    }

    // Test method
    public void test() {
        // Print the current state of the board
        System.out.println(this.toString());
    }
}