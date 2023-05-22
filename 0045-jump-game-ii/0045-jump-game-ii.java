class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            int j = i+1;
            while(j <= Math.min(n-1, i + nums[i])){
                min = Math.min(min, dp[j]);
                j++;
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
}