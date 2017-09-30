package com.lnsdlhfem.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出
 * VM Args: -Xmx20m -XX:MaxDirectMemorySize=10m
 *
 * @ClassName: DirectMemoryOOM
 * @author: lnsdlhfem
 * @date: 2017/9/30 15:04
 */
public class DirectMemoryOOM {

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
