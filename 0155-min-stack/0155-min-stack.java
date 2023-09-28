class MinStack {
    Stack<Integer> st;
    List<Integer> list;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        st=new Stack<>();
        list=new ArrayList<>();
    }
    public void push(int val) {
        st.push(val);
        min=Math.min(min,val);
        list.add(min);
    }
    public void pop() {
        st.pop();
        list.remove(list.size()-1);
        if(list.size()>0)
        min=list.get(list.size()-1); //yeh condition check karna bhul gaya tha ki meri list empty toh nahi ho gayi at this point
        else
        min=Integer.MAX_VALUE;
    }
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return list.get(list.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */