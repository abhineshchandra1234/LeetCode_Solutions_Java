/*
1598. Crawler Log Folder

Intuition

    we are given array of strings logs, where logs[i] is the operation performed by the user at the ith step
    we need to return the min no of operations to return to main folder after folder change operations
    "../" - move to parent
    "./" - remain in same folder
    "x/" - move to child folder x
    if you are already in main folder, you cannot move further back

Approach

    one point is missing in the question, whether folder has multiple sub-folders or not
    here every folder has single sub-folder
    we can solve it using stack with O(n) space
    we can use similar logic to solve it using simulation using counter in O(1) space
    if we get parent operation we will reduce level, with min level as 0
    if we get apart from parent and same folder operation, we will increase the level
    Finally return the level as res

Complexity

    Time complexity: O(n)

    Space complexity: O(1)

*/
class Solution {

    fun minOperations(logs: Array<String>): Int {

        var level = 0

        for (log in logs) {
            if (log.equals("../")) level = max(0, level - 1) else if (!log.equals("./")) level++
        }

        return level
    }
}
