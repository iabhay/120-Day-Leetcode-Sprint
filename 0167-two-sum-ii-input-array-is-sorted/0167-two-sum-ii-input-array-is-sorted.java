class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        for(int i = 0; i < n-1; i++){
            int a = target - numbers[i];
            int b = binarySearch(numbers, i+1, n-1, a);
            if(b!= -1 && b != i){
                res[0] = i+1;
                res[1] = b+1;
                break; 
            }
        }
        return res;
    }

     public int binarySearch(int arr[], int first, int last, int key){
        if (last>=first){  
            int mid = first + (last - first)/2;  
            if (arr[mid] == key){  
            return mid;  
            }  
            if (arr[mid] > key){  
            return binarySearch(arr, first, mid-1, key);  
            }else{  
            return binarySearch(arr, mid+1, last, key);  
            }  
        }  
        return -1;  
    }  
}