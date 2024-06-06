package learning.charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Description: 乱码处理
 */
public class DisorderlyCode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //基础：编码以字节的形式存在

        //给定字符串
        String str = "上海";
        //获取平台默认字符集编码的byte数组
        byte[] b = str.getBytes();
        //展示byte数组
        System.out.println(str + "\n默认的编码为：" + Arrays.toString(b));

        //以iso8859-1解码，发现是乱码
        String s = new String(b, "iso8859-1");
        System.out.println("iso8859-1解码为：" + s);

        //获取乱码的底层编码
        byte[] b1 = s.getBytes("iso8859-1");
        System.out.println(s + "与之对应的iso8859-1编码形式：" + Arrays.toString(b1));

        //以平台默认的utf-8解码，发现展示正确了~
        String s1 = new String(b1, StandardCharsets.UTF_8);
        System.out.println(s1);

        //处理分析：虽然解码的形式多样、不统一，但只要回到底层的编码，用一致的解码方式去解码就可以正确展示字符串了
    }
}
