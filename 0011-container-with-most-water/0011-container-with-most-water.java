class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<j){
            if(height[i] <= height[j]){
                 ans = Math.max(height[i]*(j-i), ans);
                i++;
            } else {
                ans = Math.max(height[j]*(j-i), ans);
                j--;
            }
        }
        return ans;
    }
}