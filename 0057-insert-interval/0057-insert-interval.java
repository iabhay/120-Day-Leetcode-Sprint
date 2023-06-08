class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> map = new ArrayList<>();
        for(int [] i: intervals){
            if(i[1] < newInterval[0]){
                map.add(i);
            }
            else if(i[0] > newInterval[1]){
                map.add(newInterval);
                newInterval = i;
            }
            else{
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        map.add(newInterval);
        return map.toArray(new int[map.size()][]);
    }
}