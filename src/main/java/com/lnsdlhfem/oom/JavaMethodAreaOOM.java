package com.lnsdlhfem.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib验证 方法区 内存溢出异常
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @ClassName: JavaMethodAreaOOM
 * @author: lnsdlhfem
 * @date: 2017/9/30 14:53
 */
public class JavaMethodAreaOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }
}
