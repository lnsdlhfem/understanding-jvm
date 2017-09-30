package com.lnsdlhfem.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @ClassName: HeapOOM
 * @author: lnsdlhfem
 * @date: 2017/9/30 14:15
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
