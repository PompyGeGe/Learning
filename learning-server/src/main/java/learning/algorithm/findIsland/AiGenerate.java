package learning.algorithm.findIsland;



import learning.algorithm.sort.Sort;

import java.util.*;

/**
 * ai生成的
 */

public class AiGenerate{
    private static final char TARGET = 'A';
    private static final int ROWS = 3;
    private static final int COLS = 4;
    private static char[][] array = new char[ROWS][COLS];
    private static boolean[][] visited = new boolean[ROWS][COLS];
    private static List<int[]> connectedElements = new ArrayList<>();

    public static void main(String[] args) {
        // 初始化数组
        array[1][0] = 'A';
        array[0][1] = 'A';
        array[1][1] = 'A';
        array[2][1] = 'A';
        array[2][2] = 'A';
        array[0][3] = 'A';
        array[1][3] = 'A';

        // BFS搜索
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (array[i][j] == TARGET && !visited[i][j]) {
                    connectedElements.clear();
                    bfs(i, j);
                    if (connectedElements.size() > 1) {
                        for (int[] element : connectedElements) {
                            System.out.println("Connected element at [" + element[0] + "][" + element[1] + "]");
                        }
                        System.out.println("----------");
                    }
                }
            }
        }
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            connectedElements.add(current);
            int r = current[0];
            int c = current[1];

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS &&
                        array[newRow][newCol] == TARGET && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

}
