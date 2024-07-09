/*
1701. Average Waiting Time

Intuition

    we are given an array customers, where customersi = [arrivali, timei]
    we need to return average waiting time for the customers till they receive order
    arrivali - arrival time of the ith customer sorted in ascending order
    timei - time taken to prepare ith customer order

Approach

    As evident in the question, we will find idle time and wait time at each step
    idle time will be max of idle and arrival time plus preparation time
    wait time will be idle time - arrival time which will be added to net wait time

Complexity

    Time complexity: O(n)

    Space complexity: O(1)

*/
class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {

        var idle: Int = 0
        var netWait: Double = 0.0

        for (customer in customers) {
            idle = max(idle, customer[0]) + customer[1]
            netWait += idle - customer[0]
        }

        return (netWait / customers.size)
    }
}
