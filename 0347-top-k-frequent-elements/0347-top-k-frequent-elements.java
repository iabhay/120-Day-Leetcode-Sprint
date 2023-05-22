class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[k];
        for(int i = 0; i <= nums.length - 1; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        for(int j = 0; j < k; j++){
            int flag  = 0;
            int index = 0;
            for(int i: map.keySet()) {
                if(flag < map.get(i)){
                    flag = map.get(i);
                    index = i;
                }
            }
            arr[j] = index;
            map.remove(index);
        }
        return arr;
    }
}