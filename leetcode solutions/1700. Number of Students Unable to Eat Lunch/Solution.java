/**
 * 1700. Number of Students Unable to Eat Lunch
 * 
 * Intuition
 * Approach 1 (Simulation)
 * 
 * we will use queue for simluation
 * we will add students and sandwiches to the queue
 * to stop the loop when all students are parsed we will use discard count.
 * we will run a loop till we have some students in the queue or discard count
 * is less than the student queue size
 * we will check peek of students and sandwiches, if they are equal we will pop
 * them from queue and reset discard count
 * if peeks are not equal we will pop student from queue and add it to the back
 * of queue
 * Finally we will return student queue size, if all sandwiches are taken
 * student size would be 0
 * 
 * Approach 2 (Counting)
 * 
 * there are two scenarios in single traversal
 * 
 * Either we will have no students left. ie every student got their desired
 * sandwich with or without rotation
 * There is a particular type sandwich at the top and there is no student of
 * that type left, so we will return no of students of other type.
 * 
 * sand -> 0001
 * stud -> 0101
 * After taking 2 sandwiches
 * sand -> 01
 * stu -> 11
 * here we have sandwich of type circle at the top & we have 0 students of type
 * circle left, so we will return square student count which is 2.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */

// Code 1
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int n = students.length;
        Queue<Integer> stuQ = new LinkedList();
        Queue<Integer> sandQ = new LinkedList();

        for (int i = 0; i < n; i++) {
            stuQ.add(students[i]);
            sandQ.add(sandwiches[i]);
        }

        int discard = 0;
        while (stuQ.size() > 0 && discard < stuQ.size()) {
            if (sandQ.peek() == stuQ.peek()) {
                sandQ.poll();
                stuQ.poll();
                discard = 0;
            } else {
                stuQ.add(stuQ.poll());
                discard++;
            }
        }

        return stuQ.size();
    }
}

// Code 2
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int cirStu = 0, squStu = 0;

        for (int stu : students) {

            if (stu == 0)
                cirStu++;
            else
                squStu++;
        }

        for (int san : sandwiches) {
            if (san == 0 && cirStu == 0)
                return squStu;
            if (san == 1 && squStu == 0)
                return cirStu;

            if (san == 0)
                cirStu--;
            else
                squStu--;
        }

        return 0;
    }
}