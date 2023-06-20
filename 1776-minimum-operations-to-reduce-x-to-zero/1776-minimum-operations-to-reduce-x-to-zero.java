class Solution {
    // int res;
    public int minOperations(int[] nums, int x) {
        // ----------RECURSION------------------
        // res = Integer.MAX_VALUE;
        // minX(nums, 0, nums.length - 1, 0, x);
        // return res == Integer.MAX_VALUE ? -1: res;

        //---------- PREFIXSUM-------------
        // Target = TotalSum - x;
        // Longest Subarray withh sum as target
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < n; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        int res = 0;
        int target = nums[n-1] - x;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i] - target)){
                int ind = map.get(nums[i] - target);
                res = Math.max(res, i - ind);
            }
            else if(nums[i] == target){
                res = Math.max(res, i+1);
            }
                map.put(nums[i], i);
        }
        if(res == 0 && x == nums[n-1]){
            return n;
        }
        return res == 0 ? -1 : (n - res);
    }
    // public void minX(int[] nums, int left, int right, int op, int x){
    //     if(x == 0){
    //         res = Math.min(res, op);
    //         return;
    //     }
    //     if( left > right || x < 0){
    //         return;
    //     }
    //     minX(nums, left+1, right, op + 1, x - nums[left]);
    //     minX(nums, left, right - 1, op + 1, x - nums[right]);
    // } 
}