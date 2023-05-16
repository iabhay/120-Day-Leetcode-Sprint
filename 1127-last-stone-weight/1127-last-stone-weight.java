class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }
        List<Integer> lst = new ArrayList<Integer>();
        // Collections.addAll(lst, stones);

        Arrays.sort(stones);
        for(int i = 0; i < stones.length; i++){
            lst.add(stones[i]);
        }
        while(lst.size() > 1 && !lst.isEmpty()){
            int first = lst.get(lst.size()-1);
            int sec = lst.get(lst.size()-2);
            lst.remove(lst.size()-1);
            lst.remove(lst.size()-1);
            if(first != sec){
                lst.add(first - sec);
                Collections.sort(lst);
            }
        }
        if(lst.isEmpty()){
            return 0;
        }
        return lst.get(0);
    }
}