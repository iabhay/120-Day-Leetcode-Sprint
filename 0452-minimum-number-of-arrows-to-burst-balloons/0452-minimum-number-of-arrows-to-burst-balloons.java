class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0],b[0]));
        int count  = 1;
        int cmp = points[0][0];
        int cmp1 = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > cmp1){
                count++;
                cmp = points[i][0];
                cmp1 = points[i][1];
            }
            else{
                cmp = Math.max(cmp, points[i][0]);
                cmp1 = Math.min(cmp1, points[i][1]);
            }
        }
        return count;
    }
}