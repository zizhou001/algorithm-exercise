import java.util.HashSet;
import java.util.Set;

/**
 * @author zizhou
 * @create 2023-11-29 19:57
 */
public class TestSet {

    class A {
        int value;
        A next = null;
        A(int _value, A _next){
            value = _value;
            next = _next;
        }
    };


    public void test2(){
        A a4 = new A(1, null);
        A a3 = new A(2, a4);
        A a2 = new A(3, a3);
        A head = new A(4, a2);
        a4.next = a3;


        Set<A> s = new HashSet<>();

        A cur = head;
        while (cur != null){
            if (s.contains(cur)){
                System.out.println("circle!");
                return;
            }else{
                s.add(cur);
                cur = cur.next;
            }
        }
        System.out.println("Success!");

    }

    public static void main(String[] args) {
        TestSet testSet = new TestSet();
        testSet.test2();
    }


}
