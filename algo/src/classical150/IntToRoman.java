package classical150;

import java.util.TreeMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-29 18:46
 */
public class IntToRoman {



    public static void main(String[] args) {
        IntToRoman s = new IntToRoman();
        System.out.println(s.intToRoman(1994));
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    /**
     * 1. 将所有可能出现的数字都放置在数组中（降序）
     * 2. 遍历values数组（同时遍历symbols）
     *  1)若num > val :  num -= val, 将val对应的符号添加到结果中
     *  2）否则，++i，遍历下一个
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public String intToRoman1(int num) {
        TreeMap<Integer, Character> map = new TreeMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        StringBuilder stringBuilder = new StringBuilder();

        int n = num;
        int j = 10;
        while (n != 0) {
            int val = n % j;
            System.out.println("val = " + val);
            String valStr = String.valueOf(val);
            if (valStr.startsWith("4") || valStr.startsWith("9")) {
                int minValidNumber = (int) (val + Math.pow(10, valStr.length() - 1));
                Character c1 = map.get(minValidNumber);
                Character c2 = map.get(minValidNumber - val);
                stringBuilder.insert(0, c1);
                stringBuilder.insert(0, c2);
            } else {
                int tmp = val;
                StringBuilder builder = new StringBuilder();
                while (tmp != 0) {
                    builder.append(map.floorEntry(tmp).getValue());
                    tmp -= map.floorKey(tmp);
                }
                stringBuilder.insert(0, builder);
            }
            n -= val;
            j *= 10;
        }
        return stringBuilder.toString();
    }
}
