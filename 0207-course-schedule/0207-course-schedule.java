class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        for(int i = 0; i < prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            inDegree[a]++;
            if(map.containsKey(b)){
                map.get(b).add(a);
            }
            else{
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(a);
                map.put(b, lst);
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) que.add(i);
        }

        while(!que.isEmpty()){
            int curr = que.poll();
            ArrayList<Integer> lst = map.get(curr);
            for(int i = 0; lst != null && i < lst.size(); i++){
                inDegree[lst.get(i)]--;
                if(inDegree[lst.get(i)] == 0){
                    que.add(lst.get(i));
                }
            }
        }
        for(int i : inDegree){
            if(i != 0){
                return false;
            }
        }
        return true;

    }
}