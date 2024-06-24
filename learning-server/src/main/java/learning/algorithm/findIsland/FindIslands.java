package learning.algorithm.findIsland;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: 皮皮
 * @Date: 2024/6/16 11:01
 * @Description: 求有多少个相连的岛屿
 */
public class FindIslands {
    /**
     * 有这么一座岛屿 数值为1的元素为一座岛屿，岛屿在垂直和水平方向互连
     */
    public static final int[][] grid = new int[][]{
            {0, 1, 0},
            {1, 1, 1},
            {0, 0, 1},
            {1, 1, 0}
    };

    public static final int X = 4;//4个数组
    public static final int Y = 3;//每个数组有3个元素
    public static final boolean[][] visited = new boolean[X][Y];

    public static void main(String[] args) {

        List<List<Island>> list = new Solution().connectedIslandsList();
        for (List<Island> islands : list) {

            //打印相连的岛屿
            for (Island island : islands) {
                System.out.print(island.getX()+","+island.getY()+"  ");
            }
            System.out.println();
        }
    }

    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    static class Island{
        private int x;
        private int y;

        /*
        等同于@AllArgsConstructor --定义有参构造函数
        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }

        等同于@NoArgsConstructor --定义全部参数的构造函数
        public Island() {
        }
        */
    }

    static class Solution {

        /**
         * 找出相连的岛屿的集合
         *
         * @return
         */
        public List<List<Island>> connectedIslandsList() {
            List<List<Island>> list = new ArrayList<>();

            //遍历数组的每一个元素
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    //List<Island> islands = findIslandsByDFS(i, j);
                    List<Island> islands = findIslandsByBFS(i, j);
                    if (!CollectionUtils.isEmpty(islands)) {
                        list.add(islands);
                    }
                }
            }

            return list;
        }

        /**
         * 深度遍历法(递归)- 找出(i,j)附近相连的岛屿
         * @param i
         * @param j
         * @return
         */
        private List<Island> findIslandsByDFS(int i, int j) {
            List<Island> islands = new ArrayList<>();

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || visited[i][j]) {
                return islands;
            }

            //当前
            visited[i][j] = true;
            islands.add(new Island().setX(i).setY(j));//用无参的构造函数
            //上
            islands.addAll(findIslandsByDFS(i - 1, j));
            //下
            islands.addAll(findIslandsByDFS(i + 1, j));
            //左
            islands.addAll(findIslandsByDFS(i, j - 1));
            //右
            islands.addAll(findIslandsByDFS(i, j + 1));

            return islands;
        }

        /**
         * 是岛屿且还没访问过，且没有超出数组边界
         */
        private boolean isIslandAndNotVisited(int x, int y){
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && visited[x][y]==false) {
                return true;
            }
            return false;
        }

        /**
         * 广度优先- 找出(i,j)附近相连的岛屿
         * @param i
         * @param j
         * @return
         */
        private List<Island> findIslandsByBFS(int i, int j) {
            List<Island> islands = new ArrayList<>();
            Queue queue = new ArrayDeque<Island>();

            //自己
            if (isIslandAndNotVisited(i,j)) {
                queue.add(new Island(i, j));
            }

            //bfs结束的条件是队列为空
            while(!queue.isEmpty()){
                Island island = (Island)queue.poll();
                islands.add(island);
                int x = island.getX();
                int y = island.getY();
                visited[x][y]=true;

                //上
                if (isIslandAndNotVisited(x-1, y)) {
                    queue.add(new Island(x-1, y));
                }

                //下
                if (isIslandAndNotVisited(x + 1, y)) {
                    queue.add(new Island(x + 1, y));
                }

                //左
                if (isIslandAndNotVisited(x, y-1)) {
                    queue.add(new Island(x, y-1));
                }

                //右
                if (isIslandAndNotVisited(x, y+1)) {
                    queue.add(new Island(x, y+1));
                }
            }

            return islands;
        }

        /**
         * 广度优先- 找出(i,j)附近相连的岛屿 -- 简化版
         * @param i
         * @param j
         * @return
         */
        private List<Island> findIslandsByBFS_1(int i, int j) {
            List<Island> islands = new ArrayList<>();
            Queue queue = new ArrayDeque<Island>();

            //自己
            queue.add(new Island(i, j));

            //bfs结束的条件是队列为空
            while(!queue.isEmpty()){
                Island island = (Island)queue.poll();

                int x = island.getX();
                int y = island.getY();
                if (!isIslandAndNotVisited(x, y)) {
                    continue;
                }

                islands.add(island);
                visited[x][y]=true;

                //上
                queue.add(new Island(x-1, y));

                //下
                queue.add(new Island(x + 1, y));

                //左
                queue.add(new Island(x, y-1));

                //右
                queue.add(new Island(x, y+1));
            }

            return islands;
        }

    }


}
