class Solution {
    public int singleNumber(int[] nums) {
         byte sizeof_int = 4;
        int INT_SIZE = 8 * sizeof_int;
        int count[] = new int[INT_SIZE];
        for (int i = 0; i < INT_SIZE; i++)
            for (int j = 0; j < nums.length; j++)
                if ((nums[j] & (1 << i)) != 0)
                    count[i] += 1;
        int res = 0;
        for (int i = 0; i < INT_SIZE; i++)
            res += (count[i] % 3) * (1 << i);
        res = res / (nums.length % 3);
        return res;
        }
    }
