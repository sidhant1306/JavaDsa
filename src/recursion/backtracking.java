public class backtracking {
    public static void main(String[] args) {
        boolean maze[][] = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        allPaths(maze, 0, 0, "");
    }

    // what is backtracking:
    // You are making some changes when you go below some recursion calls, so when you go outside these recursion calls, the changes that were made via these recursion calls should also not be available.

    //When the function is returned, the changes that you made previously for that recursion call


    public static void allPaths(boolean[][] maze, int col, int row, String p){
        // base condition:
        // when we reach the last row(by maze.length - 1) && we reach the last col of that last row(by maze[0].length -1)
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }


        if(!maze[row][col]) return;     // if it is false for that box, we return the whole current recursion call

        maze[row][col] = false;     // assigning all the boxes with false at first

        if(row < maze.length - 1){
            allPaths(maze, col, row + 1, p + "D");
        }

        if(col < maze[0].length - 1){
            allPaths(maze, col + 1, row, p + "R");
        }

        if(row > 0){
            allPaths(maze, col, row - 1, p + "U");
        }

        if(col > 0){
            allPaths(maze, col - 1, row, p + "L");
        }


//      When the function is returned, the changes that you made previously for that recursion call:
        maze[row][col] = true;      // this is the backtracking step:
        // what we are doing here is that we are assigning all the values of the boxes to true one by one while moving back in the recursion call
    }
}
