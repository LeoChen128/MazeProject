import java.util.ArrayList;

public class Maze {
    private int currentX;
    private int currentY;
    private String[][] maze;
    private boolean[][] visited;
    private int rows;
    private int cols;

    public Maze(String[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.visited = new boolean[rows][cols];
        this.currentX = 0;
        this.currentY = 0;
    }
    
    public int getY() {
        return currentY;
    }
    
    public int getX() {
        return currentX;
    }
    
    public String getCoords() {
        return "(" + getX() + ", " + getY() + ")";
    }

    public ArrayList<String> solve() {
        ArrayList<String> solution = new ArrayList<>();
        visited[0][0] = true;
        currentX = 0;
        currentY = 0;
        solution.add(getCoords());
        findPath(0, 0, solution);
        return solution;
    }

    public boolean findPath(int x, int y, ArrayList<String> path) {
        // Check if at end
        if (x == cols - 1 && y == rows - 1) {
            return true;
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

             if (isValidMove(newX, newY)) {
                visited[newY][newX] = true;
                currentX = newX;
                currentY = newY;
                path.add(getCoords());
                if (findPath(newX, newY, path)) {
                    return true;
                }
                 //goes back
                path.remove(path.size() - 1);
                currentX = x;
                currentY = y;
            }
        }
        return false;
    }

    public boolean isValidMove(int x, int y) {
    //checks if the person is inside the maze bounds
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
            return false;
        }
    //checksif it's a path and person has not went there
        return maze[y][x].equals(".") && !visited[y][x];
    }
    
    public void goRight() {
        if (isValidMove(currentX + 1, currentY)) {
            currentX++;
        }
    }
    
    public void goLeft() {
        if (isValidMove(currentX - 1, currentY)) {
            currentX--;
        }
    }
    
    public void goUp() {
        if (isValidMove(currentX, currentY - 1)) {
            currentY--;
        }
    }
    
    public void goDown() {
        if (isValidMove(currentX, currentY + 1)) {
            currentY++;
        }
    }
}
