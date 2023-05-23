class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int wd = words[0].length();
        int cnct = wd * n;
        // HashMap<String, Integer> map = new HashMap<>();
        // for(String str : map){
        //     map.put(str, map.getOrDefault(str, 0) + 1);
        // }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i <= (s.length() - cnct)){
            String tmp = s.substring(i, i + cnct);
            HashMap<String, Integer> map = new HashMap<>();
            for(String str : words){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            int j = 0;
            while(j <= (cnct - wd)){
                String tp = tmp.substring(j, j + wd);
                if(!map.containsKey(tp)){
                    break;
                }
                if(map.containsKey(tp)){
                    if(map.get(tp) == 1){
                        map.remove(tp);
                    }
                    else{
                        map.put(tp, map.get(tp) - 1);
                    }
                }
                j += wd;
            }
            if(map.isEmpty()){
                res.add(i);
            }
            i++;
        }
        return res;
    }
}