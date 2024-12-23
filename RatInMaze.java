public class RatInMaze {

   // 迷宮地圖：0 = 可行路徑，1 = 障礙物
   private static int[][] maze = {
       {0, 1, 0, 0, 0},
       {0, 1, 0, 1, 0},
       {0, 0, 0, 1, 0},
       {1, 1, 0, 0, 0},
       {0, 0, 0, 1, 0}
   };

   // 解決方案地圖
   private static int[][] solution = new int[maze.length][maze[0].length];

   // 主程式
   public static void main(String[] args) {
       if (solveMaze(0, 0)) {
           printSolution();
       } else {
           System.out.println("迷宮無解！");
       }
   }

   // 試圖解迷宮
   private static boolean solveMaze(int x, int y) {
       // 檢查是否到達出口
       if (x == maze.length - 1 && y == maze[0].length - 1 && maze[x][y] == 0) {
           solution[x][y] = 1;
           return true;
       }

       // 檢查是否為有效位置
       if (isValidMove(x, y)) {
           solution[x][y] = 1; // 標記為解決方案的一部分

           // 嘗試向下移動
           if (solveMaze(x + 1, y)) {
               return true;
           }

           // 嘗試向右移動
           if (solveMaze(x, y + 1)) {
               return true;
           }

           // 回溯
           solution[x][y] = 0;
           return false;
       }

       return false;
   }

   // 驗證是否為有效移動
   private static boolean isValidMove(int x, int y) {
       return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && solution[x][y] == 0;
   }

   // 印出解決方案
   private static void printSolution() {
       for (int i = 0; i < solution.length; i++) {
           for (int j = 0; j < solution[0].length; j++) {
               System.out.print(solution[i][j] + " ");
           }
           System.out.println();
       }
   }
}