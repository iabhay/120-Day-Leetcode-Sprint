class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        while(!map.isEmpty()){
            List<Integer> lst = new ArrayList<>();
            for(int i : map.keySet()){
                lst.add(i);
                map.put(i, map.get(i) - 1);
            }
            for(int i : lst){
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
            res.add(lst);
        }
        return res;

    }
}