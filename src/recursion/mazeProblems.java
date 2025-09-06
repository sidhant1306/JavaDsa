import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mazeProblems {
    public static void main(String[] args) {
//        int count = countPaths(8, 3);
//        System.out.println(count);


//        List<List<String>> ans = printPathsList(new ArrayList<>(), 3, 3, new ArrayList<>());
//        System.out.println(ans);


//        printPaths2("", 3, 3);

        boolean maze[][] = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

//        pathRes("",0, 0, maze);


//        allPaths(maze, 0, 0, "");


//        printSteps(maze, 0, 0, "", 0);


//        int[][] path = new int[maze.length][maze[0].length];
//        printPath(maze, 0, 0, "", 0, path);

    }





    // question (7): print the matrics in which we show the steps (step by step of where did we go to reach the end like sequentially showing what was the block that we chose to reach the end):




    public static void printPath(boolean[][] maze, int col, int row, String p, int steps, int[][] path){
        // base condition:
        // when we reach the last row(by maze.length - 1) && we reach the last col of that last row (by maze[0].length -1)
        if(row == maze.length - 1 && col == maze[0].length - 1){

            for(int[] pathway : path){
                path[row][col] = steps;     // the last step is also a step so to count that too we are doing this
                System.out.println(Arrays.toString(pathway));       //print the row of the matrics
            }
            System.out.println(p);
            return;
        }


        if(!maze[row][col]) return;     // if it is false for that box, we return the whole current recursion call

        maze[row][col] = false;     // assigning all the boxes with false at first
        path[row][col] = steps;     // assign the value of step(step number) at each box
        if(row < maze.length - 1){
            printPath(maze, col, row + 1, p + "D", steps + 1, path);
        }

        if(col < maze[0].length - 1){
            printPath(maze, col + 1, row, p + "R", steps + 1, path);
        }

        if(row > 0){
            printPath(maze, col, row - 1, p + "U", steps + 1, path);
        }

        if(col > 0){
            printPath(maze, col - 1, row, p + "L", steps + 1, path);
        }

        maze[row][col] = true;      // this is the backtracking step:
        // what we are doing here is that we are assigning all the values of the boxes to true one by one while moving back in the recursion call
    }








    // question (6): print the number of steps in each recursion call, the number of steps you take in each recursion call:

    // same as allPaths, return steps + 1 instead of p
    public static void printSteps(boolean[][] maze, int col, int row, String p, int steps){
        // base condition:
        // when we reach the last row(by maze.length - 1) && we reach the last col of that last row (by maze[0].length -1)
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(steps);
            return;
        }


        if(!maze[row][col]) return;     // if it is false for that box, we return the whole current recursion call

        maze[row][col] = false;     // assigning all the boxes with false at first

        if(row < maze.length - 1){
            printSteps(maze, col, row + 1, p + "D", steps + 1);
        }

        if(col < maze[0].length - 1){
            printSteps(maze, col + 1, row, p + "R", steps + 1);
        }

        if(row > 0){
            printSteps(maze, col, row - 1, p + "U", steps + 1);
        }

        if(col > 0){
            printSteps(maze, col - 1, row, p + "L", steps + 1);
        }

        maze[row][col] = true;      // this is the backtracking step:
        // what we are doing here is that we are assigning all the values of the boxes to true one by one while moving back in the recursion call
    }







    // question (5): print all paths (you can move in any direction, up,down,right,left):


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

        maze[row][col] = true;      // this is the backtracking step:
        // what we are doing here is that we are assigning all the values of the boxes to true one by one while moving back in the recursion call
    }







    // question (4): print paths but the matrics have restrictions(such as a river) so you cannot go at that position:

    public static void pathRes(String p, int row, int col, boolean[][] maze){

        //Perspective: It asks, "From my current spot, where can I go next?"

        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[row][col]) return;

        if(row < maze.length - 1){
            pathRes(p + "D", row + 1, col, maze);
        }
        if(col < maze[0].length - 1){
            pathRes(p + "R", row, col + 1, maze);
        }
    }



    //question (3): print paths(same as question 2) but you can move diagonally as well:




    public static void printPaths2(String p, int row, int col) {

        //Perspective: It asks, "To have arrived at my current spot, where must I have come from?"
        // let down = 'V'
        // let right = 'H'
        // let diagonal = 'D'

        if (row == 1 && col == 1) {       // we only consider the current recursion call finished when both row and col are 1 because we need to return the whole path
            System.out.println(p);
            return;
        }
        if (row > 1) {        // if we can move more in rows
            printPaths2(p + "V", row - 1, col);
        }
        if (col > 1) {        // if we can move more in cols
            printPaths2(p + "H", row, col - 1);
        }
        if(row > 1 && col > 1){
            printPaths2(p + "D", row - 1, col - 1);
        }
    }






    // Que: Storing the output of question 2 in an Arraylist :



    public static List<List<String>> printPathsList(List<String> p, int row, int col,List<List<String>> result){
        if(row == 1 && col == 1){
            result.add(new ArrayList<>(p));
            return result;
        }


        if(row > 1){
            p.add("D");
            printPathsList(p, row - 1, col, result);
            p.remove(p.size() - 1);
        }

        if(col > 1){
            p.add("R");
            printPathsList(p, row, col - 1, result);
            p.remove(p.size() - 1);
        }

        return result;
    }





    //question (2): print all the paths possible to reach the end of the matrics (you can only move in right and down direction) from a given position in a matrics



    public static void printPaths(String p, int row, int col) {
        // base case :

        if (row == 1 && col == 1) {       // we only consider the current recursion call finished when both row and col are 1 because we need to return the whole path
            System.out.println(p);
            return;
        }

        if (row > 1) {        // if we can move more in rows
            printPaths(p + "D", row - 1, col);
        }
        if (col > 1) {        // if we can move more in cols
            printPaths(p + "R", row, col - 1);
        }
    }





    // question (1): count all the possible ways to reach the end from a position in the matrics (you can only move right or bottom in the matrics) :

    public static int countPaths(int row, int col){
        if(row == 1 || col == 1) return 1;   // if we reach 1 in any of the values, it means we can go only in one direction from there to reach the end

        int left = countPaths(row, col - 1);  // we are in the left so we have to move to the right
        int right = countPaths(row - 1, col); // we are in the right, so to move downwards we have to do col - 1

        // return the total count :
        return left + right;
    }


}
