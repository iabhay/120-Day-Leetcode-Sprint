class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < words.length; i++){
                String str = words[i];
                map.put(str, map.getOrDefault(str, 0) + 1);
                String s = String.valueOf(str.charAt(1)) + String.valueOf(str.charAt(0));
                if((!str.equals(s)) && (map.containsKey(str) && map.containsKey(s))){
                    res += 4;
                    map.put(str, map.get(str)-1);
                    map.put(s, map.get(s) - 1);
                    if(map.get(s) == 0){
                        map.remove(s);
                    }
                    if(map.get(str) == 0){
                        map.remove(str);
                    }
                }
        }
        int prev = 0;
        for(String sm : map.keySet()){
            if(sm.charAt(0) == sm.charAt(1)){
                prev = map.get(sm);
                if(prev % 2 != 0){
                    prev--;
                }
                map.put(sm, map.get(sm) - prev);
                res += 2 * prev;
            }
        }
        for(String ss : map.keySet()){
            if(map.get(ss) > 0 && (ss.charAt(0) == ss.charAt(1))){
                res += 2;
                break;
            }
        }
        return res;
    }
}