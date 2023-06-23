class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        int ind = n-1;
        while(ind>= 0){
            if(nums[left] >= nums[right]){
                res[ind] = nums[left];
                left++;
            }
            else{
                res[ind] = nums[right];
                right--;
            }
            ind--;
        }
        return res;
    }
}