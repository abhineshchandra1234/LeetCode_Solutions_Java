/**
 * 232. Implement Queue using Stacks
 * 
 * Intuition
 * 
 * credits StefanPochmann
 * we will push all elements to input stack
 * when pop operation is called we will call peek operation which will pop all
 * elements from input stack and add it to output stack and return top element,
 * this way element which came first will be at top
 * we do this as there is no other way to track top elements
 * Then pop top element from the output
 * peek already contain elements which came first, if it is empty it will again
 * fetch it from input
 * In empty we will simply check if both stacks are empty
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * push - O(1)
 * 
 * pop - O(n)
 * 
 * peek - O(n)
 * 
 * empty - O(1)
 * 
 * Space complexity: O(n)
 * 
 */
class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack();
        output = new Stack();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */