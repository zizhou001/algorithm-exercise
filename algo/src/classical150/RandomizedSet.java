package classical150;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-28 10:51
 */
public class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
