package classical150;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-13 11:25
 */
public class CalcEquation {

    Map<String, Set<String>> map = new HashMap<>();
    Map<List<String>, Double> vMap = new HashMap<>();

    Set<String> visited = new HashSet<>();
    boolean find = false;
    double[] ans;

    public static void main(String[] args) {
        ArrayList<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "c"));
        equations.add(Arrays.asList("b", "e"));
        equations.add(Arrays.asList("c", "d"));
        equations.add(Arrays.asList("e", "d"));

        ArrayList<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));

        double[] values = {2.0,3.0,0.5,5.0};


        CalcEquation s = new CalcEquation();
        double[] ans = s.calcEquation(equations, values, queries);
        for (double e : ans) {
            System.out.print(e + " ");
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        // 存储（元素，序号）对，用于后续构建图
        Map<String, Integer> map = new HashMap<>();

        int num = 0;
        for(List<String> equation : equations){
            for(String var : equation){
                if(!map.containsKey(var)){
                    map.put(var, num++);
                }
            }
        }
        // graph[i][j]表示 element[i] / element[j]
        double[][] graph = new double[num][num];
        // 构建初始图
        for (int i = 0; i < num; i++) {
            graph[i][i] = 1.0;
        }
        int n = values.length;
        for (int i = 0; i < n; i++) {
            double value = values[i];
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            int idx1 = map.get(a), idx2 = map.get(b);
            graph[idx1][idx2] = value;
            graph[idx2][idx1] = 1.0 / value;
        }


        // 合并
        for (int k = 0; k < num; k++) { // 遍历所有可能的中间节点
            for (int i = 0; i < num; i++) { // 可能的起始节点
                for (int j = 0; j < num; j++) { // 可能的终点节点
                    if (graph[i][j] != 0 || k == j){
                        continue;
                    }
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }

        // 查询
        double[] ans = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            String a = query.get(0), b = query.get(1);
            if(map.containsKey(a) && map.containsKey(b)){
                int idx1 = map.get(a), idx2 = map.get(b);
                ans[i++] = graph[idx1][idx2] == 0 ? -1.0 : graph[idx1][idx2];
            }else{
                ans[i++] = -1.0;
            }
        }
        return ans;
    }
}
