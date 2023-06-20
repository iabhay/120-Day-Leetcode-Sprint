class Solution {
    public int countKDifference(int[] nums, int k) {
        // nms[i] = nums[j] + k;
        // nms[i] = nums[j] - k;
        HashMap<Integer, Integer> currMap = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < nums.length; i++){
            if(currMap.containsKey(nums[i] + k)) pairs += currMap.get(nums[i] + k);
            if(currMap.containsKey(nums[i] - k)) pairs += currMap.get(nums[i] - k);
            currMap.put(nums[i], currMap.getOrDefault(nums[i], 0) + 1);
        }
        return pairs;
    }

}