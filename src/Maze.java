import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    private int x;
    private int y;
    private String[][] maze;

    public Maze(String[][] maze){
        this.maze = maze;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String getCoords(){
        return "(" + getX() + ", " + getY() + ")";
    }

    public void goRight(){

    }

}
