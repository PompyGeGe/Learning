package learning.algorithm.tree;

/**
 * @Author: 自己写的, 只有插入和查找，没有删除
 * @Date: 2021/12/5 17:47
 * @Description: 二叉查找树(没有要求保持平衡)
 */
public class BinarySearchTreeTest {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    Node root;

    public void insert(int num) {

        if (root == null) {
            root = new Node(num, null, null);
        } else {
            findNextAndInsert(root, num);
        }


    }

    /**
     * 发现下一个节点，找到了合适的位置就插入
     * @param current
     * @param num
     */
    public void findNextAndInsert(Node current, int num) {
        if (current != null) {
            System.out.println("当前current的值为"+current.value);

            if (num<current.value) {
                System.out.println("比较：比current"+current.value+"的左边小");
                if (current.left == null) {
                    //开插
                    System.out.println("current"+current.value+"的左边为空，开始插入"+num);
                    current.left=new Node(num, null, null);
                } else {
                    //继续往下找
                    System.out.println("current"+current.value+"的左边不为空，继续往下找");
                    findNextAndInsert(current.left, num);
                }
            } else if (num>current.value) {
                System.out.println("比较：比current"+current.value+"的右边大");
                if (current.right == null) {
                    //开插
                    System.out.println("current"+current.value+"的右边为空，开始插入"+num);
                    current.right=new Node(num, null, null);
                } else {
                    //继续往下找
                    System.out.println("current"+current.value+"的右边不为空，继续往下找");
                    findNextAndInsert(current.right, num);
                }
            }

        } else {
            System.out.println("错误，入参current为空！");
        }
    }

    /**
     * 中序遍历：左中右
     * @param current
     */
    public void printOrder(Node current){
        if (current != null) {
            //输出左子树
            if (current.left != null) {
                printOrder(current.left);
            }
            //输出当前
            System.out.print(current.value+" ");
            //输出右子树
            if (current.right != null) {
                printOrder(current.right);
            }
        }
    }

/*
    private void printLeft(Node current) {
        if (current!=null) {

        }
    }

    private void printRight(Node current) {

    }
*/




    public static void main(String[] args) {
        BinarySearchTreeTest test = new BinarySearchTreeTest();
        test.insert(10);
        test.insert(8);
        test.insert(9);
        test.insert(6);
        test.insert(4);
        test.insert(3);

        System.out.println("\n中序遍历为:");
        test.printOrder(test.root);
    }


}
