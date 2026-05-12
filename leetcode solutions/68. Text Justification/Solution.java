/**
 * 68. Text Justification
 * 
 * Intuition
 * 
 * credits KidOptimo
 * We will solve this problem by naive approach
 * every word will have min 1 space between them
 * last line will have 1 space between the words
 * every line will divide the available space equally between the words, the
 * reminder space will get added to the words from the left side.
 * 
 * Approach
 * 
 * We will solve this using two ptrs left & right
 * left is initialized to 0, we first find right
 * left and right are the starting & ending index of the words for the curr line
 * we now use justify func to create line using left & right values.
 * if it is one word, then we will return the same by adding extra space at the
 * end.
 * if it is the lastLine we add 1 space else we add totalSpace / numSpaces
 * if it is the lastline we have remainder space as 0 else we have totalSpace %
 * numSpaces
 * Now we will add word + space + remainder to temp string, later add this temp
 * string to res.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*k), n is words.length and k is avg length of word
 * 
 * We are running just one loop, Inside that loop we are finding each word
 * length and doing operations
 * 
 * findRight - O(n*k)
 * 
 * justify - very less time, as it already has left and right value and creating
 * lines by appending words
 * 
 * Space complexity:
 * 
 * O(m), where m is maxWidth, space to store each line temporarily
 * 
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        int left = 0;
        List<String> res = new ArrayList();

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            res.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return res;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {

        if (right - left == 0)
            return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder res = new StringBuilder();
        for (int i = left; i <= right; i++) {
            res.append(words[i]).append(space)
                    .append(remainder-- > 0 ? " " : "");
        }
        return padResult(res.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++)
            wordsLength += words[i].length();
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}

// Second Code
class Solution {
    int MAX_WIDTH;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        int n = words.length;
        MAX_WIDTH = maxWidth;
        int i = 0;

        while (i < n) {
            int letters = words[i].length();
            int j = i + 1;
            int slots = 0;

            while (j < n && slots + letters + words[j].length() + 1 <= MAX_WIDTH) {
                letters += words[j].length();
                slots += 1;
                j++;
            }

            int spaces = MAX_WIDTH - letters;
            int wordSpace = slots == 0 ? 0 : spaces / slots;
            int extraSpace = slots == 0 ? 0 : spaces % slots;
            // last line
            if (j == n) {
                wordSpace = 1;
                extraSpace = 0;
            }
            res.add(getLine(i, j, wordSpace, extraSpace, words));
            i = j;
        }
        return res;
    }

    private String getLine(int i, int j, int wordSpace, int extraSpace, String[] words) {
        StringBuilder s = new StringBuilder();
        for (int k = i; k < j; k++) {
            s.append(words[k]);
            // last word of line will have no space after
            if (k == j - 1)
                continue;
            for (int l = 0; l < wordSpace; l++)
                s.append(" ");

            if (extraSpace > 0) {
                s.append(" ");
                extraSpace--;
            }
        }
        // last line extra space
        while (s.length() < MAX_WIDTH)
            s.append(" ");

        return s.toString();
    }
}