class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<List<Integer>> map = new ArrayList<>();
        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
});
int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= start && intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else if(intervals[i][0] <= start){
                if(intervals[i][1] < start){
                    ArrayList<Integer> temps = new ArrayList<>();
                    temps.add(intervals[i][0]);
                    temps.add(intervals[i][1]);
                    map.add(temps);
                }
                else{
                    start = intervals[i][0];
                    end = Math.max(end, intervals[i][1]);
                }
                
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                map.add(temp);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        map.add(temp);
        int[][] arr = new int[map.size()][2];
        for(int i = 0; i < map.size(); i++){
            arr[i][0] = map.get(i).get(0);
            arr[i][1] = map.get(i).get(1);
        }
        return arr;
    }
}