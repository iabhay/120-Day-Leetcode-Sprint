class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sol[] = new int[2];
        HashMap<Integer,Integer> gypsy = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            gypsy.put(nums[i] , i );
        }
        for ( int i = 0 ; i < nums.length ; i++){
            int k = target - nums[i];
            if ( gypsy.containsKey(k) && gypsy.get(k) != i){
                sol[0] = i;
                sol[1] = gypsy.get(k);
            }
        }
        return sol;
    }
    }