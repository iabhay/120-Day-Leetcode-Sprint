class MyHashSet {
    ArrayList<Integer> lst;
    public MyHashSet() {
        lst = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!contains(Integer.valueOf(key))){
            lst.add(key);
        }
    }
    
    public void remove(int key) {
        if(contains(Integer.valueOf(key))){
            lst.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        if(lst.contains(Integer.valueOf(key))){
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */