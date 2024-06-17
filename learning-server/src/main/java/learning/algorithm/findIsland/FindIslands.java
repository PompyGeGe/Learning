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

    public static final int x = 4;//4个数组
    public static final int y = 3;//每个数组有3个元素
    public static final boolean[][] visited = new boolean[x][y];

    public static void main(String[] args) {

        Set<List<Island>> set = new Solution().connectedIslandsSet();
        for (List<Island> list : set) {

            //打印相连的岛屿
            for (Island island : list) {
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
        public Set<List<Island>> connectedIslandsSet() {
            Set<List<Island>> set = new HashSet<>();

            //遍历数组的每一个元素
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    //List<Island> islands = findIslandsByDFS(i, j);
                    List<Island> islands = findIslandsByBFS(i, j);
                    if (!CollectionUtils.isEmpty(islands)) {
                        set.add(islands);
                    }
                }
            }

            return set;
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
         * 广度优先- 找出(i,j)附近相连的岛屿
         * @param i
         * @param j
         * @return
         */
        private List<Island> findIslandsByBFS(int i, int j) {
            List<Island> islands = new ArrayList<>();
            Queue queue = new ArrayDeque<Island>();

            //自己
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                queue.add(new Island(i, j));
            }

            //bfs结束的条件是队列为空
            while(!queue.isEmpty()){
                Island island = (Island)queue.poll();
                islands.add(island);
                visited[island.getX()][island.getY()]=true;

                //上
                if (i-1 >= 0 && i-1 < grid.length && j >= 0 && j < grid[0].length && grid[i-1][j] == 1 && visited[i][j]==false) {
                    queue.add(new Island(i-1, j));
                }

                //下
                if (i+1 >= 0 && i+1 < grid.length && j >= 0 && j < grid[0].length && grid[i+1][j] == 1 && visited[i][j]==false) {
                    queue.add(new Island(i+1, j));
                }

                //左
                if (i >= 0 && i < grid.length && j-1 >= 0 && j-1 < grid[0].length && grid[i][j-1] == 1 && visited[i][j]==false) {
                    queue.add(new Island(i, j-1));
                }

                //右
                if (i >= 0 && i < grid.length && j+1 >= 0 && j+1 < grid[0].length && grid[i][j+1] == 1 && visited[i][j]==false) {
                    queue.add(new Island(i, j+1));
                }
            }

            return islands;
        }

    }


}
