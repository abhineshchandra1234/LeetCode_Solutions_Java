// 151. Reverse Words in a String

/*
Intuition
we will first split the words in a list
then we will just reverse the words in the list using two-pointers
then we will traverse through the words and add them to stringbuilder or res alongwith spaces
Approach

Complexity
Time complexity: O(n)
Space complexity: O(n)
*/

//kotlin
class Solution {
    fun reverseWords(s: String): String {
        val words = s.split(" ").toMutableList()
        var left = 0
        var right = words.size - 1

        while(left<right) {
            var temp = words[left]
            words[left] = words[right]
            words[right] = temp
            left++
            right--
        }

        var res = StringBuilder()
        for(word in words) {
            if(word.isNotEmpty()) {
                if(res.isNotEmpty()) {
                    res.append(" ")
                }
                res.append(word)
            }
        }
        return res.toString()
    }
}

    // java
    // back to front
    class Solution {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            int i = s.length() - 1;

            while (i >= 0) {
                while (i >= 0 && s.charAt(i) == ' ')
                    i--;

                if (i < 0)
                    break;

                int j = i;

                while (j >= 0 && s.charAt(j) != ' ')
                    j--;

                if (result.length() > 0)
                    result.append(" ");

                result.append(s.substring(j + 1, i + 1));

                i = j;
            }

            return result.toString();
        }
    }

    // java
    // front to back
class Solution {
    public String reverseWords(String s) {
        // Convert string to char array for in-place operations
        char[] arr = s.toCharArray();

        // Step 1: reverse whole string
        reverse(arr, 0, arr.length - 1);

        int n = arr.length;
        int left = 0, right = 0, i = 0;

        while (i < n) {
            // skip spaces
            while (i < n && arr[i] == ' ')
                i++;
            if (i == n)
                break;

            // copy word
            while (i < n && arr[i] != ' ') {
                arr[right++] = arr[i++];
            }

            // reverse the copied word
            reverse(arr, left, right - 1);

            // add space
            if (i < n) {
                arr[right++] = ' ';
            }

            left = right;

            i++;
        }

        // Final trim: if we added a trailing space, remove it
        return new String(arr, 0, (right > 0 && arr[right - 1] == ' ') ? right - 1 : right);
    }

    // helper function to reverse char array
    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}