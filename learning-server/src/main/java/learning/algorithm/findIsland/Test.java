package learning.algorithm.findIsland;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 皮皮
 * @Date: 2024/6/16 11:01
 * @Description: 求有多少个相连的岛屿
 */
public class Test {
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
    static class Island{
        private int x;
        private int y;
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
                    List<Island> islands = findIslandsByDFS(i, j);
                    if (!CollectionUtils.isEmpty(islands)) {
                        set.add(islands);
                    }
                }
            }

            return set;
        }

        /**
         * 深度遍历法(递归)
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
            islands.add(new Island().setX(i).setY(j));
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

    }


}
