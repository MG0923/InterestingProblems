/*Program to find total number of islands and the largest island
* */
public class NoOfIslands {

    static int ROW = 5;
    static int COL= 5;
    static int length;

    private static void dfs(int[][] matrix, int x, int y, boolean[][] visited){
        int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[x][y] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; k++)
        {
            if (isSafe(matrix, x + rowNbr[k], y + colNbr[k],
                    visited))
            {
                // increment region length by one
                length++;
                dfs(matrix, x + rowNbr[k], y + colNbr[k],
                        visited);
            }
        }
        //longer version
        /*if (isSafe(matrix, x - 1, y, visited)) {
            dfs(matrix, x - 1, y, visited);
        }
        if (isSafe(matrix, x - 1, y - 1, visited)) {
            dfs(matrix, x - 1, y - 1, visited);
        }
        if (isSafe(matrix, x - 1, y + 1, visited)) {
            dfs(matrix, x - 1, y + 1, visited);
        }
        if (isSafe(matrix, x, y - 1, visited)) {
            dfs(matrix, x, y - 1, visited);
        }
        if (isSafe(matrix, x, y + 1, visited)) {
            dfs(matrix, x, y + 1, visited);
        }
        if (isSafe(matrix, x + 1, y - 1, visited)) {
            dfs(matrix, x + 1, y - 1, visited);
        }
        if (isSafe(matrix, x + 1, y, visited)) {
            dfs(matrix, x + 1, y, visited);
        }
        if (isSafe(matrix, x + 1, y + 1, visited)) {
            dfs(matrix, x + 1, y + 1, visited);
        }*/
    }

    private static boolean isSafe(int[][] matrix, int x, int y, boolean[][] visited) {
        return x >= 0 && x < ROW &&
                y >= 0 && y < COL &&
                matrix[x][y] != 0 &&
                !visited[x][y];
    }
    public static int getNoOfIslands(int[][] matrix, int x, int y ){
        int count = 0;
        int result = 0;
        boolean[][] visited = new boolean[x][y];
        for(int row = 0; row < x; row++){
            for(int col =0 ; col < y; col++){
                if(matrix[row][col] == 1 && !visited[row][col]){
                    length = 1;
                    dfs(matrix, row, col, visited);
                    count++;
                    result = Math.max(result, length);
                }
            }
        }
        System.out.println("Maximum Region: "+ result);
        return count;
    }
    public static void main(String[] args) {
        int [][] matrix = {
                {0,1,0,0,1},
                {1,1,0,0,0},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,0,0,1}
        };

        int noOfIslands = getNoOfIslands(matrix, ROW, COL);
        System.out.println("Total regions: "+noOfIslands);
    }
 }
