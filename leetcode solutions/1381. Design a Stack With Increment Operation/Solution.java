/**
 * 1381. Design a Stack With Increment Operation
 * 
 * Intuition
 * we can solve this problem through array, as size is fixed
 * 
 * Approach
 * using topIndex + 1 we are making it 1-indexed from 0-indexed
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(maxSize)
 */
class CustomStack {

    private int[] stackArray;
    private int topIndex;

    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        topIndex = -1;
    }

    void push(int x) {
        if (topIndex < stackArray.length - 1)
            stackArray[++topIndex] = x;
    }

    int pop() {
        if (topIndex >= 0)
            return stackArray[topIndex--];
        return -1;
    }

    void increment(int k, int val) {
        int limit = Math.min(k, topIndex + 1);
        for (int i = 0; i < limit; i++)
            stackArray[i] += val;
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */