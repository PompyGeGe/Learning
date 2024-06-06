package learning.algorithm;

import java.util.HashSet;

/**
 * @Author: 皮皮
 * @Date: 2023/4/05 18:35
 * @Description:
 *  相对于爆破枚举的n的平方，滑动窗口的优化之处在于当前循环会利用上次循环的数据。
 *
 *                  a     b     c     b     a     c     d     c     a
 *                  ↑           ↑   (上一次)
 *                 start       end
 *                 ---------------------------------------------------
 *                        ↑     ↑   (当前)
 *                      start  end
 *
 *  [思路]：
 *  左指针固定时，右指针不断往右扩，扩到不能再扩位置(遇到重复字符串)；
 *  然后，左指针再往右移(窗口左边界缩)。原因是以前面一个字符为基准，已经穷尽所有找子串的场景了，再以前面的字符为基准，也不会有新的突破了。
 *  因此，只能让左指针右移，这可以发现新的机遇(判断重复字符时会少用左边的这个字符去判断)。
 *  为了寻找新的机遇，则要不断以新的字符为基准，所以左指针要不断往右移，对应了外面的for循环，也可以理解为滑动窗口不断地右移(实际上，窗口的大小是动态的，左边界和右边界都在移动)。
 *
 *  [时间复杂度分析]：
 *  左边界指针和右边界指针都没有往左移动，都只能往右移动，是线性的处理(从整体上来看，窗口不停地往右滑)。
 *  数组里每个元素被左边界指针操作一次，被右边界指针操作一次，总共n个元素，共被操作了2n次，所以是O(n)复杂度。
 *
 *
 *  另外一道题，也可用滑动窗口去解：
 *    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *    示例：  输入s = 7, nums = [2,3,1,2,4,3] 输出：2  ，子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class SlidingWindow {

    public static void main(String[] args) {
        //用例一
        String s1 = "abcbacdca";
        System.out.println("["+s1+"不重复的子字符串]：");
        System.out.println(find(s1));

        //用例二
        String s2 = "abcdeefghhhi";
        System.out.println("["+s2+"不重复的子字符串]：" );
        System.out.println(find(s2));
    }


    public static String find(String s) {
        char[] chars = s.toCharArray();

        String maxStr = "";

        HashSet<String> set = new HashSet<String>();

        int start = 0;
        int end = 0;
        set.add(toStr(chars[0]));

        //寻找新的字符为基准，左边界右移(窗口内缩)。
        for (int i = 0; i < chars.length - 1; i++) {
            //以chars[i]作为左边界为基准，右边界不断右扩
            while (end <= chars.length - 2 && !set.contains(toStr(chars[end + 1]))) {
                end++;
                set.add(toStr(chars[end]));//每移动一个字符，就把字符记录在set里
            }

            String temMaxStr = getMaxStr(start, end, chars);
            if (temMaxStr.length() >= maxStr.length()) {
                maxStr = temMaxStr;
            }

            set.remove(toStr(chars[start]));//为下次新的基准做准备，则要把上个基准字符从记录set里删掉
            start++;

            if (chars[start] == 'e' && chars[end] == 'e' && start > end) {
                System.out.println("存在");
            }
        }

        return "最大子串为"+maxStr;
    }

    private static String getMaxStr(int start, int end, char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (int n = start; n <= end; n++) {
            builder.append(chars[n]);
        }
        String res = builder.toString();
        System.out.println("maxStr:" + res);
        return res;
    }

    public static String toStr(char c) {
        return Character.toString(c);
    }


}
