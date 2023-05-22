class Solution {
    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        int sum = 0;
        int j = height.length -1;
        for(int i = 0; i < height.length; i++){
            maxL = Math.max(height[i], maxL);
            maxR = Math.max(height[j], maxR);
            left[i] = maxL;
            right[j] = maxR;
            j--;
        }
        for(int i = 0; i < height.length ; i++){
            int temp = Math.min(left[i], right[i]);
            sum += temp - height[i];
        }
        return sum;
    }
}