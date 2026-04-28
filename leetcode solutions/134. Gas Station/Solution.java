// 134. Gas Station

/*
Intuition
we need gas sum greater or equal to cost sum to complete a loop
we will check total at each indices, if it is less than 0, means we do not have enough gas to travel to next station
we will reset total, and move to next index
later we will return this index as answer
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

//kotlin
class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        
        if(gas.sum()<cost.sum())
            return -1

        var total = 0
        var res = 0

        for(i in gas.indices) {
            total += gas[i] - cost[i]

            if(total<0) {
                total = 0
                res = i+1
            }
        }

        return res
    }
}

    // Java

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalG = 0, totalC = 0;
        for (int i = 0; i < n; i++) {
            totalG += gas[i];
            totalC += cost[i];
        }

        if (totalG < totalC)
            return -1;

        int currG = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            currG += gas[i] - cost[i];
            if (currG < 0) {
                currG = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
