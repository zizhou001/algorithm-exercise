package classical150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-02 10:12
 */
public class ZConvert {

    public static void main(String[] args) {
        ZConvert s = new ZConvert();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i <= numRows; i++) {
            list.add(new StringBuilder());
        }
        int curRow = 1;
        boolean down = true;
        StringBuilder ansBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && (curRow == 1 || curRow == numRows)){
                down = !down;
            }
            list.get(curRow).append(s.charAt(i));
            curRow = down ? curRow + 1 : curRow - 1;
        }

        for (int i = 1; i <= numRows; i++) {
            ansBuilder.append(list.get(i));
        }
        return ansBuilder.toString();
    }
}
