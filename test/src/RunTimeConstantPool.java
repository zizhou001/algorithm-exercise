/**
 * @author zizhou
 * @create 2023-11-11 18:37
 */

class Person{
    public String name;
    public Person(String _name){
        this.name = _name;
    }
}

public class RunTimeConstantPool {
    public static void main(String[] args) {
//        String str1 = new StringBuilder("hello").append("world").toString();
//        String str2 = "hello" + "world";
//        String str3 = "helloworld";
//        String str4 = new String("helloworld");
//
//        System.out.println(str1.intern() == str1);
//        System.out.println(str2.intern() == str3);
//        System.out.println(str3.intern() == str4);

//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);

        Person p1 = new Person("lihang");
        Person p2 = new Person("lihang");
        String myFullName = "lihang";
        String myFirstName = "li";
        String myLastName = "hang";
        System.out.println("p1.name == p2.name | "+(p1.name == p2.name));
        System.out.println("myFullName.intern() == p2.name | "+(myFullName.intern() == p2.name));
        System.out.println("myFullName.intern() == (myFirstName + myLastName) | "
                +(myFullName.intern() == (myFirstName + myLastName)));

        String myFullName2 = new StringBuilder("li").append("hang").toString();
        String myNickName = new StringBuilder("zi").append("zhou").toString();
        System.out.println("myFullName2.intern() == myFullName2 | " + (myFullName2.intern() == myFullName2));
        System.out.println("myNickName.intern() == myNickName | " + (myNickName.intern() == myNickName));
        System.out.println("myFullName.intern() == myFullName2.intern() | " + (myFullName.intern() == myFullName2.intern()));



    }
}
