package com.learning.GC;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class InterestingGC {

    static class OOMObject{
        public byte[] m = new byte[64 * 1024];
    }

    public static void fillHeap(int n) throws InterruptedException {
        Thread.sleep(30000);
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //稍作延时
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }


    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
