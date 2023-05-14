class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int res = 0;
        for(int i = 0; i < n; i++){
            Arrays.sort(nums[i]);
        }
        for(int j = m-1; j >= 0; j--){
            int curr = 0;
            for(int i = 0; i < n; i++){
                curr = Math.max(nums[i][j], curr);
            }
            res += curr;
        }
        return res;
    }
}