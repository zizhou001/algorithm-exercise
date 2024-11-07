import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author zizhou
 * @create 2023-11-25 10:25
 */
public class TestInvokeDynamic {

    class GrandFather{
        void f() {
            System.out.println("Grandfather");
        }
    }

    class Father extends GrandFather {
        void f() {
            System.out.println("Father");
        }
    }

    class Son extends Father {
        void f(){
            MethodType mt = MethodType.methodType(void.class);
            try {
                Field implLookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                implLookup.setAccessible(true);
                MethodHandle mh = ((MethodHandles.Lookup) implLookup.get(null)).findSpecial(GrandFather.class, "f", mt, getClass());
                mh.invoke(this);
            }  catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //无法访问祖父类
        (new TestInvokeDynamic().new Son()).f();  //Father
    }
}
