package learning.innerClass;

/**
 * @Description:
 * 测试内部类能否访问方法里的局部变量？结论：
 *    只能读，不能修改; 要想修改，则内部类自己用另一个变量去拷贝该值; 有另外一种方案是将那个变量修饰为final，但这样的话就不能修改它的值了！
 * 内部类不能修改局部变量的原因：
 *    内部类对象在方法里创建，正常情况下在方法执行完后会被销毁，方法里的局部变量也会被销毁;
 *    但如果方法返回了内部类对象的引用，这个引用被别人持有着，导致方法调用完后内部类对象无法被销毁，而内部类对象又持有方法局部变量的引用, 导致这个局部变量不能被销毁，这是不允许的！
 */
public class LocalVarTest {

    interface Account {
        void print();
    }

    public Account getAccount() {
        int money = 100;

        Account account = new Account(){
            public void print() {
                //这里会修改money的值，会报错！
                //money=money+200;

                //能访问money的值，不过只能读！
                System.out.println("账户存款为：" + money);
            }
        };
        account.print();

        return account;
    }

    public static void main(String[] args) {
        //getAccount方法访问完后，里面的局部变量会消失，但却返回了内部类Account的对象的引用到这里被持有着，导致Account对象不能被销毁，其引用了局部变量money; 这是不允许的！
        Account account = new LocalVarTest().getAccount();
        System.out.println(account);
    }
}





