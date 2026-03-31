// 3474. Lexicographically Smallest Generated String

/**
 * Intuition
 * we will follow the question as it is given
 * we will create a placeholder array which will store the new resultant string
 * Then we will process T, if T is given and placeholder is not empty or there
 * is already a substring equal to str2, then we will return empty string
 * Otherwise we will add str2 at the curr index in the placeholder
 * Then we will fill all the empty spaces in the placeholder with a and mark
 * them true in the change array, ie we can change them later
 * then we will process F, ie we need to have different string than str2 at the
 * curr index in placeholder
 * Inside it we have isSame function, which checks if we have str2 at the curr
 * index in placeholder
 * According to question we shouldnt have str2, so we will change its char from
 * last, to have lexicographically smaller string
 * If we are not able to change it we will return empty string
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*m)
 * Space complexity: O(n+m-1)
 */

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int N = n + m - 1;

        char[] word = new char[N];
        boolean[] canChange = new boolean[N];

        // Fill with placeholder
        for (int i = 0; i < N; i++) {
            word[i] = '
```;
        }

        // Step 1: Process 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                int idx = i;
                for (int j = 0; j < m; j++) {
                    if (word[idx] != '
``` && word[idx] != str2.charAt(j)) {
                        return "";
                    }
                    word[idx] = str2.charAt(j);
                    idx++;
                }
            }
        }

        // Step 2: Fill remaining with 'a'
        for (int i = 0; i < N; i++) {
            if (word[i] == '
```) {
                word[i] = 'a';
                canChange[i] = true;
            }
        }

        // Step 3: Process 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                if (isSame(word, str2, i, m)) {
                    boolean changed = false;

                    for (int k = i + m - 1; k >= i; k--) {
                        if (canChange[k]) {
                            word[k] = 'b'; // minimal change
                            canChange[k] = false;
                            changed = true;
                            break;
                        }
                    }

                    if (!changed)
                        return "";
                }
            }
        }

        return new String(word);
    }

    private boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j))
                return false;
            i++;
        }
        return true;
    }
}