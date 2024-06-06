package learning.mBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @Author: 皮皮
 * @Date: 2022/2/14 21:55
 * @Description:
 */
@Slf4j
@Data
public class Person implements PersonMBean {

    private int n;

    @Override
    public int getN() {
        return 0;
    }

    @Override
    public void setN(int n) {
        this.n=n;
    }

    @Override
    public void print(int n) {
        System.out.println("n的值是："+n);
    }

    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("jmxBean:name=person");
        server.registerMBean(new Person(), name);
    }




}
