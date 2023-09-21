class MyHashSet {
    LinkedList<Integer> hashSet;
    public MyHashSet() {
        hashSet=new LinkedList<>();
    }
    public void add(int key) {
        if(!hashSet.contains(key))
        hashSet.add(key);
    }
    
    public void remove(int key) {
        if(hashSet.contains(key))
         hashSet.remove((Integer)key); 
        // hashSet.remove(Integer.valueOf(key)); // both lines are correct for deleting an object from the linked list
    }
    
    public boolean contains(int key) {
        if(hashSet.contains(key))
        return true;
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