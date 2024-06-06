package learning.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2023/8/3 0:26
 * @Description:
 * 先了解什么是反射：
 *    反射是Java动态语言的关键特性！
 *    它是一种在运行时检查和操作类/对象/方法/字段的技术，允许运行时获取类的详细信息(如类名、父类、接口、构造方法等)。通过反射，可以动态创建对象、访问和修改对象的属性，以及调用对象的方法。
 *
 * 如果直接让Integer放入List<String>则编译时就会报错，！！因为编译时会校验泛型是否正确！！。而通过反射"绕过编译时校验"：让Integer放入List<String> (不过取不出来，get(i)一调用就报类型转换错误)
 *
 * 扩展：
 *    下例用到了2个知识点，一个是反射; 一个是泛型(ArrayList的add(E e)方法就用到了泛型)。下面顺带讲下泛型擦除：
 *      在编译期间，所有的泛型信息都会被擦掉(在生成的字节码中是不包含泛型中的类型信息的)。且泛型擦除后，类型会变成Object。
 *
 */
public class Test {
    public static void main(String[] args) throws Exception {

        List<String> list = new ArrayList<>();
        list.add("ss");

        Class clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, 18);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getClass());//取出时报错
        }
    }
}
