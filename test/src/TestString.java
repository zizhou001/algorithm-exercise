
/**
 * @author zizhou
 * @create 2023-11-08 20:52
 */
public class TestString {
    public static void main(String args[]){
        String str = "1000";
        char[] chars = str.toCharArray();
        int[] ints = new int[str.length()];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
            System.out.println(ints[i]);
        }
    }
}
