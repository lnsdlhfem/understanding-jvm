package com.lnsdlhfem.oom;

/**
 * ！！！可能导致操作系统卡死
 * 多线程验证 虚拟机栈和本地方法栈
 * VM Args: -Xss2m
 *
 * @ClassName: JavaVMStackOOM
 * @author: lnsdlhfem
 * @date: 2017/9/30 14:35
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
