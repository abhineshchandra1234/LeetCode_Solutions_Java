/**
 * 920. Number of Music Playlists
 * 
 * Intuition
 * 
 * credits optimisea
 * dp[goal][n] will represent no of playlist of length goal created with n
 * unique songs
 * when a new song is added it can be old or new song
 * The question is asking us max no of playlist we can create, so we will take
 * into account both types of songs
 * when new song is added
 * dp[i - 1][j - 1] * (n - (j - 1)), we have already listened to j-1 songs, so
 * new song will be out of n - (j - 1), and above will be the no of new
 * playlists
 * when old is added
 * dp[i - 1][j] * (j - k), we cannot play old song if j<=k means k songs are not
 * played
 * like k=3, j=1, here old song cannot be played, hence 0 is added
 * like k=3, j=4, we have listened to 4 unique songs till now, here 1st song
 * will be played again at 5th position, no of old songs we can play j-k=4-3=1
 * here the new song played is the old one so previous state is dp[i - 1][j]
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(goal*n), dp states
 * 
 * Space complexity:
 * 
 * O(goal*n), dp memory
 * 
 */
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {

        int mod = (int) 1e9 + 7;
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
                }
            }
        }
        return (int) dp[goal][n];
    }
}