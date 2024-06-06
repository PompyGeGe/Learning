package learning.GC;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * finalize的2个作用：
 *  1.对象被GC回收前的遗言
 *  2.对象可以在此方法里自救，不被回收
 */
@Slf4j
@Data
public class Finalize {

    private static final int _1MB = 1024*1024;

    /**
     * 【VM参数】
     *   -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */

    static class InnerClass{

        byte[] bytes;

        public InnerClass(int size){
            this.bytes = new byte[size];
        }

        //留遗言
        protected void finalize() throws Throwable{
            System.out.println("我马上要挂了，你们好好看书，早日跳槽");
        }
    }


    public static void main(String[] args) {

        InnerClass class1 = new InnerClass(2 * _1MB);
        log.info("class1已分配内存");
        InnerClass class2 = new InnerClass(2 * _1MB);
        log.info("class2已分配内存");
        InnerClass class3 = new InnerClass(2 * _1MB);
        log.info("class3已分配内存");

        //分配个对象，再断开引用
        InnerClass tempClass = new InnerClass(0);
        tempClass = null;

        //此处会触发MinorGC
        InnerClass class4 = new InnerClass(4 * _1MB);
        log.info("class4已分配内存");


    }




}
