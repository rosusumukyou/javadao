package 类加载器;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
    public static void main(String[] args) {
        Imessage mImessage = (Imessage) new MesageProx().bind(new MessageImpl());
        mImessage.send();
    }
}

interface Imessage {
    public void send();
}

class MessageImpl implements Imessage {

    public void send() {
        System.out.println("消息发送成功！！");
    }
}
/**
 * 动态代理
 * 
 * @author Administrator
 *
 */

class MesageProx implements InvocationHandler {

    private Object targer;

    /**
     * 
     * @param targer
     *            真实对象
     * @return 代理对象
     */
    public Object bind(Object targer) {
        this.targer = targer;
        return java.lang.reflect.Proxy.newProxyInstance(targer.getClass().getClassLoader(),
                targer.getClass().getInterfaces(), this);
    }

    public boolean connextion() {
        System.out.println("通道连接成功！");
        return true;
    }

    public void close() {
        System.out.println("通道关闭成功！");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*********【执行方法】" + method);
        Object returndate = null;
        if (this.connextion()) {
            returndate = method.invoke(this.targer, args);// 执行代理方法
            this.close();
        }
        return returndate;
    }

}