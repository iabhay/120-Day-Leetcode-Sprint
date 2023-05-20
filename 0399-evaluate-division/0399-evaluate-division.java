// class Solution {
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         HashMap<String, Double> map = new HashMap<>();
//         HashMap<String, Integer> freq = new HashMap<>();

//         for(int i = 0; i < equations.size(); i++){
//             String str1 = equations.get(i).get(0);
//             String str2 = equations.get(i).get(1);
//             // HashSet<Character> set1 = new HashSet<>();
//             // HashSet<Character> set2 = new HashSet<>();
//             // String str1 = "";
//             // String str2 = "";
//             // for(char charact : ch1.toCharArray()){
//             //     set1.add(charact);
//             // }
//             // for(char charact : ch2.toCharArray()){
//             //     if(set1.contains(charact)){
//             //         set1.remove(charact);
//             //     }
//             //     else{
//             //         set2.add(charact);
//             //     }
//             // }
//             // for(char charact : set1){
//             //     str1 += Character.toString(charact);
//             // }
//             // for(char charact : set2){
//             //     str2 += Character.toString(charact);
//             // }
//             if(!map.containsKey(str1) && map.containsKey(str2)){
//                 double temp = map.get(str2) * values[i];
//                 map.put(str1, temp);

//             }
//             if(map.containsKey(str1) && !map.containsKey(str2)){
//                 double temp = map.get(str1) / values[i];
//                 map.put(str2, temp);
//             }
//             else{
//                 double tmp = 1.0;
//                 map.put(str1, values[i]);
//                 map.put(str2, tmp);
//             }
//         }
//         double [] res = new double[queries.size()];
//         int i = 0;
//         for(List<String> lst : queries){
//             String str1 = lst.get(0);
//             String str2 = lst.get(1);
//             // HashSet<Character> set1 = new HashSet<>();
//             // HashSet<Character> set2 = new HashSet<>();
//             // String str1 = "";
//             // String str2 = "";
//             // for(char charact : ch1.toCharArray()){
//             //     set1.add(charact);
//             // }
//             // for(char charact : ch2.toCharArray()){
//             //     if(set1.contains(charact)){
//             //         set1.remove(charact);
//             //     }
//             //     else{
//             //         set2.add(charact);
//             //     }
//             // }
//             // for(char charact : set1){
//             //     str1 += Character.toString(charact);
//             // }
//             // for(char charact : set2){
//             //     str2 += Character.toString(charact);
//             // }
//             if(!map.containsKey(str1) || !map.containsKey(str2)){
//                 double tmp = -1.0;
//                 res[i] = tmp;
//             }
//             else if(str1.equals(str2)){
//                 double tmp2 = 1.0;
//                 res[i] = tmp2;
//             }
//             else{
//                 double tmp3 = (map.get(str1) / map.get(str2));
//                 res[i] = tmp3;
//             }
//             i++;
//         }
//         return res;
//     }
// }
class Solution {
    public class Node {
        String dest;
        double val;
        public Node(String d, double v){
            dest = d;
            val = v;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Creating graph, Format of graph is Key is String and values is destination and value or weight
        Map<String, List<Node>> graph = buildGraph(equations, values);
        // To Store answer
        double[] ans = new double[queries.size()];
        //To compute all the queries 
        for(int i = 0; i < queries.size(); i++){
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return ans;
    }

    private double dfs(String src, String dest, HashSet<String> visited, Map<String, List<Node>> graph){
        if(!graph.containsKey(src) || !graph.containsKey(dest)) return -1.0;
        if(src.equals(dest)) return 1.0;
        visited.add(src);
        for(Node node : graph.get(src)){
            if(!visited.contains(node.dest)){
                double ans = dfs(node.dest, dest, visited, graph);
                if(ans != -1.0) return ans * node.val;
            }
        }
        return -1.0;
    }

    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, List<Node>> graph = new HashMap<>();
        System.out.println(values.length);
        for(int i = 0; i < values.length; i++){
            // List<String> eq = equations.get(i);
            // graph.computeIfAbsent(eq.get(0), value -> new ArrayList<>()).add(new Node(eq.get(i), values[i]));
            // graph.computeIfAbsent(eq.get(1), value -> new ArrayList<>()).add(new Node(eq.get(0), 1 / values[i]));
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList());
            graph.putIfAbsent(dest, new ArrayList());
            graph.get(src).add(new Node(dest, values[i]));
            graph.get(dest).add(new Node(src, 1 / values[i]));
        }
        return graph;
    }
}