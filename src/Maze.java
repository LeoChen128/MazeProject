import java.util.ArrayList;

public class Maze {
    private String[][] maze;
    private ArrayList<Coordinate> steps;
    private Coordinate end;

    public Maze(String[][] maze) {
        this.maze = maze;
        this.steps = new ArrayList<>();
        int lastRow = maze.length - 1;
        int lastCol = maze[0].length - 1;
        this.end = new Coordinate(lastRow, lastCol);
    }

    private boolean canMove(int r, int c) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length) {
            return false;
        }
        return maze[r][c].equals(".");
    }

    private boolean atEnd(Coordinate p) {
        return p.getRow() == end.getRow() && p.getColumn() == end.getColumn();
    }

    public String solveMaze() {
        Coordinate current = new Coordinate(0, 0);
        steps.add(current);
        maze[0][0] = "#";

        while (!atEnd(current)) {
            boolean moved = false;
            int r = current.getRow();
            int c = current.getColumn();

            //left
            if (!moved && canMove(r, c - 1)) {
                current = new Coordinate(r, c - 1);
                steps.add(current);
                maze[r][c - 1] = "#";
                moved = true;
            }
            //right
            if (!moved && canMove(r, c + 1)) {
                current = new Coordinate(r, c + 1);
                steps.add(current);
                maze[r][c + 1] = "#";
                moved = true;
            }
            //up
            if (!moved && canMove(r - 1, c)) {
                current = new Coordinate(r - 1, c);
                steps.add(current);
                maze[r - 1][c] = "#";
                moved = true;
            }
            //down
            if (!moved && canMove(r + 1, c)) {
                current = new Coordinate(r + 1, c);
                steps.add(current);
                maze[r + 1][c] = "#";
                moved = true;
            }

            if (!moved) {
                steps.remove(steps.size() - 1);
                current = steps.get(steps.size() - 1);
            }
        }

        String output = "";
        for (int i = 0; i < steps.size(); i++) {
            output += steps.get(i).toString();
            if (i < steps.size() - 1) {
                output += " ---> ";
            }
        }
        return output;
    }
}
