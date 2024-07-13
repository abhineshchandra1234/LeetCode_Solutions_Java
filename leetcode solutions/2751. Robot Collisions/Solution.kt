/*
2751. Robot Collisions

Intuition

    there are n robots numbered from 1 to n
    we are given integer array positions, healths and string directions
    we need return an array of health of remaining robots after collisions in the same order as given in the input
    all robots will start moving simultaneously in the specified directions
    they will collide if in the same direction
    if they have same health both will be removed
    Otherwise lower health will be removed and higher health will be reduced by 1

Approach

    we will solve this problem through simulation
    we will take a index array representing robots
    we will sort the index array based on positions, to simulate robots positions
    this is tricky and most important part, rest is easy ie arranging robots according to positions
    we will use stack to simulate robots collisions or movements
    we will add index of robots whose direction is right into the stack
    we will use index array for sequential traversal of robots
    no need to create a entity using position, health, direction and robot, as index is already handling it
    when we encounter robot whose direction is left, we will continue the collisions till it is possible with left robot
    we will check if stack is not empty and its health is greater than 0 ie valid for line and compare it with top no of stack by popping it
    if right health is more than left, reduce right health by 1 and add its index in stack for further collisions and reduce left health to 0 ie removed from line
    if left health is more than right, reduce left health by 1, will be used for further collisions using a loop, reduce right health to 0
    if both left and right healths are equal, make health of both equal to 0
    then we will finally traverse health which contain health of robots in original order and add those health which is greater than 0 ie part of line to res

Complexity

    Time complexity: O(nlogn), sorting robots

    Space complexity: O(n), using stack to simulate collision

*/
class Solution {

    fun survivedRobotsHealths(
        positions: IntArray,
        healths: IntArray,
        directions: String
    ): List<Int> {

        var index = Array(positions.size) { it }
        var stack = ArrayDeque<Int>()
        var res = mutableListOf<Int>()

        index.sortWith { lhs, rhs -> positions[lhs].compareTo(positions[rhs]) }

        for (i in index) {
            if (directions[i] == 'R') stack.addLast(i)
            else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    var right = stack.removeLast()
                    if (healths[right] > healths[i]) {
                        healths[right] -= 1
                        healths[i] = 0
                        stack.addLast(right)
                    } else if (healths[i] > healths[right]) {
                        healths[i] -= 1
                        healths[right] = 0
                    } else {
                        healths[i] = 0
                        healths[right] = 0
                    }
                }
            }
        }

        for (i in healths) {
            if (i > 0) res.add(i)
        }

        return res
    }
}
