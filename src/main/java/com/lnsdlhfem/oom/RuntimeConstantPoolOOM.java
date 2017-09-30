package com.lnsdlhfem.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证 运行时常量池（jdk1.6及更早版本）
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @ClassName: RuntimeConstantPoolOOM
 * @author: lnsdlhfem
 * @date: 2017/9/30 14:47
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10mb的PermSize在integer范围内足够产生OOM
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
