package learning.GC;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * MinorGc的触发条件和过程
 * MinorGc的触发条件：先把Eden区没有连续的空间了/装满了
 * MinorGc的过程：第一次GC时，先把Eden区的对象往SurvivorFrom扔;
 *               后续GC时，把Eden区和SurvivorFrom区的对象往SurvivorTo区扔(年龄+1)...如此反复，把SurvivorFrom区的对象往SurvivorTo区交换...
 */
@Slf4j
@Data
public class MinorGC {

    private static final int _1MB = 1024*1024;

    /**
     * 【分析】
     *  对象优先在Eden区分配，在分配allocation4时发现内存不足，就要开始MinorGc了,准备把6MB的对象全扔到SurvivorTo区的，
     *  但是SurvivorTo区装不下，只好走担保机制，将6MB的对象全移到老年代，新的4M对象放到被清理了的Eden区上。
     *
     * 【VM参数】
     *   -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        MinorGC minorGC = new MinorGC();

        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        log.info("allocation1已分配内存");
        allocation2 = new byte[2 * _1MB];
        log.info("allocation2已分配内存");
        allocation3 = new byte[2 * _1MB];
        log.info("allocation3已分配内存");
        allocation4 = new byte[4 * _1MB];
        log.info("allocation4已分配内存");
    }

}
