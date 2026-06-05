// 3753. Total Waviness of Numbers in Range II

/**
 * Intuition
 * we will solve this using digit dp state
 * we will find diff between res of num2 and num1-1, to get our final answer
 * we would have limitDigit for each place, if isLimited is true we can generate
 * digits till limitDigit otherwise till 9
 * we will avoid leading zeros
 * to check peak or valley we will compare prev with prevPrev and curr digit
 * In totalWaveScore, remNumbers will be added bcs it will contain prev waviness
 * too 132xxx, next xxx nos will contain 3 as peak
 * At last we will return totalNumbers and totalWaveScore
 * Finally return totalWaveScore as our ans
 * Approach
 * 
 * Complexity
 * Time complexity: O(n * 10 * 10 * 10)
 * Space complexity: O(n * 10 * 10)
 */

class Solution {
    String s;
    int n;
    long[][] dpTotalNumbers = new long[16][10 * 10];
    long[][] dpTotalWaviness = new long[16][10 * 10];
    boolean[][] visited = new boolean[16][10 * 10];

    private long[] solve(int curr, int prevPrev, int prev, boolean isLimited, boolean isLeadingZero) {
        if (curr == n) {
            return new long[] { 1, 0 };
        }

        int key = (prevPrev < 0 ? 0 : prevPrev) * 10 + (prev < 0 ? 0 : prev);

        if (!isLimited && !isLeadingZero && prevPrev >= 0 && prev >= 0) {
            if (visited[curr][key]) {
                return new long[] { dpTotalNumbers[curr][key], dpTotalWaviness[curr][key] };
            }
        }

        long totalNumbers = 0;
        long totalWaveScore = 0;
        int limitDigit = isLimited ? (s.charAt(curr) - '0') : 9;

        for (int digit = 0; digit <= limitDigit; digit++) {
            boolean newIsLeadingZero = isLeadingZero && (digit == 0);
            int newPrevPrev = prev;
            int newPrev = newIsLeadingZero ? -1 : digit;

            long[] result = solve(
                    curr + 1, newPrevPrev, newPrev,
                    isLimited && (digit == limitDigit),
                    newIsLeadingZero);

            long remNumbers = result[0];
            long remWaveScore = result[1];

            if (!newIsLeadingZero && prevPrev >= 0 && prev >= 0) {
                boolean isPeak = (prevPrev < prev && prev > digit);
                boolean isValley = (prevPrev > prev && prev < digit);

                if (isPeak || isValley) {
                    totalWaveScore += remNumbers;
                }
            }

            totalNumbers += remNumbers;
            totalWaveScore += remWaveScore;
        }

        if (!isLimited && !isLeadingZero && prevPrev >= 0 && prev >= 0) {
            dpTotalNumbers[curr][key] = totalNumbers;
            dpTotalWaviness[curr][key] = totalWaveScore;
            visited[curr][key] = true;
        }

        return new long[] { totalNumbers, totalWaveScore };
    }

    private long func(long num) {
        if (num < 100)
            return 0;

        dpTotalNumbers = new long[16][100];
        dpTotalWaviness = new long[16][100];
        visited = new boolean[16][100];

        s = Long.toString(num);
        n = s.length();

        long[] result = solve(0, -1, -1, true, true);
        return result[1];
    }

    public long totalWaviness(long num1, long num2) {
        return func(num2) - func(num1 - 1);
    }
}