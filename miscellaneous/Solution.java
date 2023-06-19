class Solution {
    public int largestAltitude(int[] gain) {

        int max_alt = 0, curr_alt = 0;
        for (int i : gain) {
            curr_alt += i;
            max_alt = Math.max(max_alt, curr_alt);
        }
        return max_alt;
    }
}