// class Solution {
//     public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//         HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//         List<Integer> res = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             ArrayList<Integer> temp = new ArrayList<>();
//             temp.add(i);
//             map.put(i, temp);
//         }    
//         for(List<Integer> lst : edges){
//             map.get(lst.get(0)).add(lst.get(1));
//         }
//         HashSet<Integer> set = new HashSet<>();
//         while(set.size() < n){
//             int mx = 0;
//             int sz = 0;
//             for(int i : map.keySet()){
//                 if(map.get(i).size() > sz){
//                     sz = map.get(i).size();
//                     mx = i;
//                 }
//             }
//             for(int i : map.get(mx)){
//                 set.add(i);
//             }
//             res.add(mx);
//             map.remove(mx);
//         }
//         return res;
//     }
// }
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}