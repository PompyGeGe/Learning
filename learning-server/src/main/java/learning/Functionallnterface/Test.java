package learning.Functionallnterface;

/**
 * @Author: 皮皮
 * @Date: 2023/5/21 17:00
 * @Description:
 */
public class Test {

    //调用Compute类的add方法，需要设置三个参数
    public static int add(int a, int b, Compute<Integer> compute) {
        return compute.add(a, b);
    }

    /**
     * 调用Compute类的add方法，设置三个参数的2种方式：
     */
    //传统匿名类方式
    public static int way1() {
        int i = 1;
        int j = 2;
        return add(i, j, new Compute<Integer>() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        });
    }

    //使用过lambda表达式进行参数调用处理
    public static int way2() {
        int i = 1;
        int j = 2;
        return add(i, j, (a, b ) -> a+b);
    }


    public static void main(String[] args) {
        System.out.println(way2());
    }
}
