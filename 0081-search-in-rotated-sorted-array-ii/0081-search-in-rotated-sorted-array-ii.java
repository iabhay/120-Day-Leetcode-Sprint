class Solution {
    public boolean search(int[] nums, int target) {
        return solver(nums, 0, nums.length-1, target);
        
        
        
    }

    public boolean solver(int[] nums, int left, int right, int target){
        int mid  = left+ (right-left)/2;
        if(nums[mid] == target){
            return true;
        }
        if(left >= right){
            return false;
        }
        return solver(nums, mid+1, right, target) || solver(nums, left, mid-1, target);
    }
}