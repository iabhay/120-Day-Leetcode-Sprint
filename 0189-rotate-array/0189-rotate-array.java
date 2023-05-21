class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k >= n) k = k % n;
        int [] ans = new int[n];
        for(int i = 0;  i < k;i++){
            ans[i] = nums[n-k+i];
        }
        for (int j = 0 ; j < n-k;j ++){
            ans[j+k] = nums[j];
            }
        for(int i = 0; i < n ; i++){
            nums[i] = ans[i];
        }
    }
}