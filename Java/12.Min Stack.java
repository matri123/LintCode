public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minstack.empty()){
            minstack.push(number);
        }
        else {
            minstack.push(Math.min(number, minstack.peek()));
        }
    }
    
    public int pop() {
        // write your code here
        int temp = stack.peek();
        stack.pop();
        minstack.pop();
        return temp;
    }
    
    public int min() {
        // write your code here
        return minstack.peek();
    }
}

