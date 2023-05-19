class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, 0);
        for(int i = 0; i< n; i++){
            if(colors[i] == -1 || colors[i] == 1){
                continue;
            }
            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            colors[i] = 1;
            while(!que.isEmpty()){
                int curr = que.poll();
                for(int nxt : graph[curr]){
                    if(colors[nxt] == 0){
                        colors[nxt] = -colors[curr];
                        que.add(nxt);
                    }
                    if(colors[nxt] == colors[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}