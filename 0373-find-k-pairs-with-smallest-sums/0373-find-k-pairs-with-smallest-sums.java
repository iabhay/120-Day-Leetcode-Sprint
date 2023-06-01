// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         List<List<Integer>> res = new ArrayList<>();
//         int n = nums1.length;
//         int m = nums2.length;
//         if (k > n * m){
//             k = n* m; 
//         }
//         int[][] arr = new int[n * m][2];
//         int l = 0;
//         for(int i = 0; i < n; i ++){
//             for(int j = 0; j < m; j++){
//                 arr[l][0] = nums1[i];
//                 arr[l][1] = nums2[j];
//                 l++; 
//             }
//         }
//         if(k != n * m)Arrays.sort(arr, Comparator.comparingInt(a -> IntStream.of(a).sum()));
//         int s = 0;
//         while(k-- > 0){
//             List<Integer> lst = new ArrayList<>();
//             lst.add(arr[s][0]);
//             lst.add(arr[s][1]);
//             res.add(lst);
//             s++;
//         }
//         return res;
//     }
// }

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // initialize a priority queue that keeps the smallest elements at each index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );
        for (int i = 0; i < nums1.length; i++) {
            minHeap.add(new int[] { i , 0 });
        }

        // iterate up to k and get the min values.
        // as you run into a min value, add back on the next min!!
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (minHeap.isEmpty()) break;

            int[] minPairIndexes = minHeap.remove();
            int indexList1 = minPairIndexes[0], indexList2 = minPairIndexes[1];
            List<Integer> res = Arrays.asList(nums1[indexList1], nums2[indexList2]);
            result.add(res);

            // now update the pq
            if (indexList2 < nums2.length - 1) {
                // this means we still have another pair for the index
                // otherwise, we ran out
                minHeap.add(new int[] { indexList1 , indexList2 + 1 });
            }
        }
        
        return result;
    }
}