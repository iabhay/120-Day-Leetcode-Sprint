import java.util.Arrays;
class Solution {
    public int removeElement(int[] nums, int val) {
        int start=0;
        int count=0;
        int end=nums.length-1;
        while(start<=end){
            if(nums[start]==val){
                int temp=nums[end];
                nums[end]=nums[start];
                nums[start]=temp;
                end--;
                count++;
            }
            else{
                start++;
            }
        }
        return nums.length-count;
        
    }
}