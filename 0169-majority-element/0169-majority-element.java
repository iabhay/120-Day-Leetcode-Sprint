// class Solution {
//     public int majorityElement(int[] nums) {
//         // int temp = nums[0];
//         // for(int i = 0; i < nums.length; i++){

//         // }
//         // Arrays.sort(nums);

//         int n = nums.length;
//         return nums[n/2];
//     }
// // }
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                count = 0;
            } else {
                count++;
            }
            if (count >= (nums.length / 2)) {
                return nums[i];
            }
            // System.out.print(nums[i] + " ");
        }
        return 0;
    }
}