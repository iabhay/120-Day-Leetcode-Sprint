import static java.lang.Math.toIntExact;
class Solution {
    public int rangeBitwiseAnd(long left, long right) {
        long res = 0;
        while(left > 0 && right > 0){
            int msb_p1 = msbPos(left);
            int msb_p2 = msbPos(right);
            if (msb_p1 != msb_p2)
                break;
        
            long msb_val = (1 << msb_p1);
            res = res + msb_val;
            left = left - msb_val;
            right = right - msb_val;
        }
        // if(left == 0  || right == 0){
        //     return 0;
        // }
        return toIntExact(res);
    }
    static int msbPos(long n)
    {    
        int msb_p = -1;
        while (n > 0) {
            n = n >> 1;
            msb_p++;
        }
         
        return msb_p;
    }
}