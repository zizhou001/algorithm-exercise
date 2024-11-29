package classical150;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-29 18:46
 */
public class IntToRoman {

    public static void main(String[] args) {
        IntToRoman s = new IntToRoman();
        System.out.println(s.intToRoman(3749));
    }

    public String intToRoman(int num) {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        String numStr = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("3749 % 10 = " + 3749 % 10);
        System.out.println("3740 % 100 = " + 3740 % 100);
        System.out.println("3700 % 1000 = " + 3700 % 1000);
        System.out.println("3000 % 10000 = " + 3000 % 10000);

        int n = num;
        int j = 10;
        while (n != 0){
            int val = n % j;
            String valStr = String.valueOf(val);
            if (valStr.startsWith("4") || valStr.startsWith("9")){
                int minValidNumber = (int) (val + Math.pow(10, valStr.length() - 1));
                Character c1 = map.get(minValidNumber);
                Character c2 = map.get(minValidNumber - val);
                stringBuilder.insert(0, c1);
                stringBuilder.insert(0, c2);
            }else {

                stringBuilder.insert(0, map.get(val));
            }
            n -= val;
            j *= 10;
        }
        return stringBuilder.toString();
    }
}
