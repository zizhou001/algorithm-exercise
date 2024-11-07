import javafx.beans.binding.ObjectExpression;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author zizhou
 * @create 2023-11-25 9:41
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String msg){
            System.out.println(msg + "_ClassA");
        }
    }

    static class ClassB extends ClassA {
        @Override
        public void println(String msg){
            System.out.println(msg + "_ClassB");
        }
    }

    private static MethodHandle getPrintlnMethod(Object receiver) throws Throwable {
        /**
         * 设置方法类型，用于后续查找
         */
        MethodType mt = MethodType.methodType(void.class, String.class);

        /**
         * lookup():在指定类中查找符合给定方法签名和调用权限的方法句柄
         * findVirtual()：调用虚方法
         * bindTo()：由于调用虚方法，需要将其绑定给实例对象，由实例对象调用
         */
        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

    public static void main(String[] args) throws Throwable {
        Object[] objs  = {new ClassA(), new ClassB(), System.out};
        for(Object obj : objs) {
            //调用指定对象的方法句柄
            getPrintlnMethod(obj).invokeExact("invoke");
        }
    }
}
