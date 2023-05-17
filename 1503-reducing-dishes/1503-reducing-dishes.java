class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        ArrayList<Integer> lst = new ArrayList<>();
        Arrays.sort(satisfaction);
        for(int i = 0; i < satisfaction.length;i++){
            lst.add(satisfaction[i]);
        }
        int res = Integer.MIN_VALUE;
        while(!lst.isEmpty()){
            int curr = 0;
            for(int i = 0; i < lst.size(); i++){
                curr += lst.get(i)*(i+1);
            }
            if(curr < res){
                break;
            }
            res = Math.max(res, curr);
            lst.remove(lst.get(0));
            Collections.sort(lst);
        }
        if(res <= 0){
            return 0;
        }
        return res;
    }
}