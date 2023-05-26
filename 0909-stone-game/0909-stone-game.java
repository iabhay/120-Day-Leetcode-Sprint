class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean stoneGame(int[] piles) {
        return solver(piles, 0, piles.length-1, true, 0,0);
    }

    public boolean solver(int[] piles, int start, int end, boolean alice, int aliceScore, int bobScore){
        if(start > end){
            if(aliceScore > bobScore){
                return true;
            }
            return false;
        }
        String curr = start + "_" + end;
        if(map.containsKey(curr)){
            return map.get(curr);
        }
        if(alice){
            if(solver(piles, start+1, end, !alice, aliceScore + piles[start], bobScore) || solver(piles, start, end-1, !alice, aliceScore+piles[end], bobScore)){
                map.put(curr, true);
                return true;
            }
            else{
                map.put(curr, false);
                return false;
            }
        }
        if(!alice){
            if(solver(piles, start+1, end, !alice, aliceScore , bobScore + piles[start]) || solver(piles, start, end-1, !alice, aliceScore, bobScore + piles[start])){
                map.put(curr, true);
                return true;
            }
            else{
                map.put(curr, false);
                return false;
            }
        }
        return false;
    }
}