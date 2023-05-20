class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1[0] == 0 && nums1.length == 1){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
        else if(nums2 ==  null){
        }
        else{
            Stack<Integer> stk1 = new Stack<>();
            Stack<Integer> stk2 = new Stack<>();
        for(int i = 0; i < m; i++){
            stk1.push(nums1[i]);
        }
        for(int i = 0; i < n; i++){
            stk2.push(nums2[i]);
        }
        int  i = m+n - 1 ;
        while(!stk1.empty() && !stk2.empty()){
            if(stk1.peek() >= stk2.peek()){
                nums1[i] = stk1.pop();
            }
            else{
                nums1[i] = stk2.pop();
            }
            i--;
        }
        while(i > -1){
            if(!stk1.empty()){
            nums1[i] = stk1.pop();
            }
            else if(!stk2.empty()){
                nums1[i] = stk2.pop();
            }
            i--;
        }
        }
    }
}