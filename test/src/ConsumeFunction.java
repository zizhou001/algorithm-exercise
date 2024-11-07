import java.util.function.Function;

class One{
    One(){
        System.out.println("One");
    }
}
class Two{
    Two(){
        System.out.println("Two");
    }
}

public class ConsumeFunction {
    static Two consume(Function<One, Two> onetwo){
        return onetwo.apply(new One());
    }

    static void change(String s, Function<String, Integer> toInt, Function<Integer, String> toStr){
        String ss = toInt.andThen(toStr).apply(s);
        System.out.println(ss);
    }

    static void testCompose(String s,
                            Function<String, String> op1,
                            Function<String, String> op2,
                            Function<String, String> op3){
        String ss = op1.compose(op2).andThen(op3).apply(s);
        System.out.println(ss);
    }

    public static void main(String[] args) {
        //Two two = consume(one -> new Two());

        //change("45", s -> Integer.parseInt(s), i -> i + "");

        testCompose("hello",
                s -> s + "_apply",
                s -> s + "_compose",
                s -> s + "_andThen"); //hello_compose_apply_andThen




    }
}
