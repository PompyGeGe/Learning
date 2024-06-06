package learning.designMode.agentMode.staticAgent;

/**
 * 代理类
 */
public class Agent implements IStar {

    private Star star;  //注意，这里写成IStar也可以, 不过此时相当于IStar star = new Star(); 这个start 指向的仍然是Star对象!!!!!!!!!!!!! Thread类使用代理模式时，里面的target是Runnable接口类型，而不是用户类。

    public Agent(Star star) {
        this.star = star;
    }

    public Agent() {

    }

    @Override
    public void personSignature() {
        star.personSignature();
    }

    @Override
    public void show() {
        star.show();
    }

    @Override
    public void bookTickets() {
        System.out.println("经纪人预定车票");

    }

    @Override
    public void signContract() {
        System.out.println("经纪人谈合同");

    }

    @Override
    public void schedule() {
        System.out.println("经纪人安排演唱会");

    }

    @Override
    public void interview() {
        System.out.println("经纪人面谈");

    }


}
