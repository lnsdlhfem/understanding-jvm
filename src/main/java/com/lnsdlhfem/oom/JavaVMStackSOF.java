package com.lnsdlhfem.oom;

/**
 * 虚拟机栈和本地方法栈SOF（StackOverflowError）测试
 * VM Args: -Xss128k
 *
 * @ClassName: JavaVMStackSOF
 * @author: lnsdlhfem
 * @date: 2017/9/30 14:26
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
