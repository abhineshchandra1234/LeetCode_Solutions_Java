/**
 * 71. Simplify Path
 * 
 * Intuition
 * We will use stack to solve this
 * We will first split the path on "/"
 * Then we traverse the splitted path, if the stack is not empty and curr path
 * is "..". Then pop top path.
 * If the path is not "", ".", ".." , then add the path to the stack
 * Finally pop path sequentially from stack and add it to the res.
 * 
 * Approach
 * Initialize stack, StringBuilder and string array
 * Then traverse string array, if the stack is not empty and curr path is "..",
 * pop top path
 * if curr path is not equal to "", ".", ".." add the curr path to stack
 * If the stack is empty return "/"
 * If the stack is not empty pop each element and add it to StringBuilder.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public String simplifyPath(String path) {

        Stack<String> dir = new Stack();
        StringBuilder res = new StringBuilder();
        String[] pathArray = path.split("/");

        for (String subPath : pathArray) {
            if (!dir.isEmpty() && subPath.equals(".."))
                dir.pop();
            else if (!subPath.equals("") && !subPath.equals(".") && !subPath.equals(".."))
                dir.push(subPath);
        }

        if (dir.isEmpty())
            return "/";
        while (!dir.isEmpty())
            res.insert(0, dir.pop()).insert(0, "/");

        return res.toString();
    }
}