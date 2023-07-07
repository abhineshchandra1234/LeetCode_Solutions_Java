/**
 * 2024. Maximize the Confusion of an Exam
 * 
 * Intuition
 * 
 * credits aman282571
 * we will use sliding window to solve this
 * We will try to find logest substrings of 'F' with max k 'T'.
 * Inside the window we will track the count of 'T'
 * We will shrink the window till count of 'T' > k
 * We will update res with window length at every index.
 * Same we will do with longest substring of 'T'
 * Max of these two substrings length will be our result.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        return Math.max(solve(answerKey, 'F', k), solve(answerKey, 'T', k));
    }

    public int solve(String answerKey, char b, int k) {

        int left = 0, res = 0, size = answerKey.length(), cnt = 0;
        for (int i = 0; i < size; i++) {

            if (answerKey.charAt(i) == b)
                cnt++;
            while (cnt > k) {
                if (answerKey.charAt(left) == b)
                    cnt--;
                left++;
            }
            res = Math.max(i - left + 1, res);
        }
        return res;
    }
}