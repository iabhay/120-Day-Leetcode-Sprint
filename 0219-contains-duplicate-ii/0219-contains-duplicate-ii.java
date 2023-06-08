class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        int j = k + i;
        if(j == 0){
            return false;
        }
        while(i < nums.length){
            if(i == j){
                i++;
                j = k + i;
            }
            if(j >= nums.length){
                j = nums.length - 1;
            }
            else if(nums[i] != nums[j]){
                j--;
            }
            else if(nums[i] == nums[j] && j <= i + k){
                return true;
            }
        }
        return false;
    }
}