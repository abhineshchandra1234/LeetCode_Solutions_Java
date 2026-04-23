// 45. Jump Game II
/*
Intuition
we will calculate maxReach at each index
if maxReach is equal to n-1, we will increase jump count as 1 and return it as answer
Otherwise we will try to make next jump from maxReach, by checking if index is equal to prev maxReach ie end
In this we will increase jump count by 1, and update end with curr maxReach
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

// kotlin
class Solution {
    fun jump(nums: IntArray): Int {
        
        var jumps = 0
        var end = 0
        var maxReach = 0
        var n = nums.size

        for(i in 0 until n-1) {
            maxReach = Math.max(maxReach, i+nums[i])

            if(maxReach>=n-1) {
                jumps++
                break
            }

            if(i==end) {
                jumps++
                end = maxReach
            }
        }
        return jumps
    }
}

    // java
class Solution {
    public int jump(int[] nums) {
        int jump = 0, prevMr = 0, mr = 0, n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            mr = Math.max(mr, i + nums[i]);

            if (mr >= n - 1) {
                jump++;
                break;
            }

            if (i == prevMr) {
                jump++;
                prevMr = mr;
            }
        }

        return jump;
    }
}