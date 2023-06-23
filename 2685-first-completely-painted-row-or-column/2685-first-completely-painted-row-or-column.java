class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length;
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(arr[i], i);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            int curr = -1;
            for(int j = 0; j < n; j++){
                curr = Math.max(curr, map.get(mat[i][j]));
            }
            res = Math.min(res, curr);
        }
        for(int i = 0; i < n; i++){
            int curr = -1;
            for(int j = 0; j < m; j++){
                curr = Math.max(curr, map.get(mat[j][i]));
            }
            res = Math.min(res, curr);
        }
        return res;
    }
}