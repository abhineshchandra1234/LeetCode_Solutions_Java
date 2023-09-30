/**
 * 456. 132 Pattern
 * 
 * Intuition
 * 
 * credits aayush912
 * we will solve this problem using stack
 * Stack will take care of 32 pattern and will traverse array to find 1
 * bottom of the stack will point to peak encountered so far.
 * we will also have another var to track 2 called second
 * When we encounter new peak, stack peak and second will updated by popping the
 * elements
 * But how index of i,j,k is followed, it is followed by traversing array from
 * back
 * notice stack peak is updated with lower index
 * second is updated with existing higher index
 * When we encounter 1 less than 2 which will be less than 3 too we got our
 * result.
 * 
 * Approach
 * 
 * [3, 6, 4, 1, 2] -> 3, 6, 4
 * 1 -> stack -> 2, peak -> 2, second ->inf
 * 2 -> stack -> 2,1 peak -> 2, second -> inf
 * 3 -> stack -> 4 peak -> 4, second -> 2
 * 4 -> stack -> 6 peak -> 6, second -> 4
 * 5 -> stack -> 6,3 peak -> 6, second -> 4, first -> 3 -> ans
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second)
                return true;
            while (!stack.isEmpty() && nums[i] > stack.peek())
                second = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}