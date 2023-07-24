//Min Stack

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || minSt.peek()>=val){
            minSt.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        int popnum = st.pop();
        if(minSt.peek()==popnum){
            minSt.pop();
        }  
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(minSt.isEmpty()){
            return -1;
        }else{
            return minSt.peek();
        }
    }
}
