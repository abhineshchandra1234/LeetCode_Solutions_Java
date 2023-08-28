/**
 * 225. Implement Stack using Queues
 * 
 * Intuition
 * 
 * credits sjtuldk
 * we will solve this problem using single queue
 * When we add a new no to queue, we will bring back all the existing nos of the
 * queue to the back
 * This way it will behave as a stack as last added no is at the top.
 * Rest all the functions will remain same.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++)
            q.add(q.poll());
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */