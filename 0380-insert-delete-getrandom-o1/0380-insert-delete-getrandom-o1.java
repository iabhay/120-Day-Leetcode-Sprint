class RandomizedSet {
    HashSet<Integer> set;
    HashSet<Integer> vis;
    public RandomizedSet() {
        set = new HashSet<>();
        vis = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        // for(int c : set){
        //     if(!vis.contains(c)){
        //         vis.add(c);
        //         return c;
        //     }
        // }
        // vis.clear();
        // for(int c : set){
        //     if(!vis.contains(c)){
        //         vis.add(c);
        //         return c;
        //     }
        // }
        // return 0;
        return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */