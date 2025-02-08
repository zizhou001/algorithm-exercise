import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-07 17:07
 */
public class DistinctList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,3,3,4,5,6,7,7,8));
        // ArrayList<Integer> list = new ArrayList<>(initList);

        // for(Integer e : list){
        //     if(list.indexOf(e) != list.lastIndexOf(e)){
        //         list.remove(e);
        //     }
        // }

        for(int i = 0; i < list.size(); i++){
            int e = list.get(i);
            if(list.indexOf(e) != list.lastIndexOf(e)){
                list.remove(e);
            }
        }

        System.out.println(list);
    }
}
