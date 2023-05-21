class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 2){
                map.put(nums[i], 2);
                set.add(nums[i]);
            }
        }
        int res = 0;
        int k = 0;
        Map<Integer, Integer> sortedMap = new TreeMap<>(map);
        for(int i : sortedMap.keySet()){
            int j = sortedMap.get(i);
            res += j;
            while(j-- > 0){
                nums[k] = i;
                k++;
            }
        }
        return res;
    }
}