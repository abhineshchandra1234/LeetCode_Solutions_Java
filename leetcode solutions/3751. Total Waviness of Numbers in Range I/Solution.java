// 3751. Total Waviness of Numbers in Range I

/**
 * Intuition
 * we will solve this problem through brute force
 * we will traverse nos from nums1 to nums2 and find waviness for each no
 * to find waviness, we will first convert no to string
 * then we will traverse string
 * if the curr char is more than its previous and next char it is peak, and we
 * will increase the waviness count
 * similarly if the curr char is less than its previous and next char it is
 * valley, and we will increase the waviness count
 * add this waviness count to total and return the total
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(logn)
 */

class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++)
            total += getWaviness(i);
        return total;
    }

    private int getWaviness(int x) {
        String s = Integer.toString(x);
        int waviness = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            boolean isPeak = s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1);
            boolean isValley = s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1);
            if (isPeak || isValley)
                waviness++;
        }
        return waviness;
    }
}