/**
 * 2147. Number of Ways to Divide a Long Corridor
 * 
 * Intuition
 * 
 * credits Invulnerable
 * we can divide the array into small subarrays which contains at least 2 seats.
 * plants before 1or last subarrays are irrelevent and can be added to 1 & last
 * subarray
 * we need to divide plants between subarrys from 1 to n, bcs then can be either
 * of the subarray i & i-1
 * we can divide plants of size k into k+1 parts
 * since all the divisons are independent, we need to multiply divisons to find
 * ans
 * ans = (ans * length) % mod; where length = k+1, where k is the no of plants
 * between two subarrays
 * corner conditions
 * if the seats are not even or there are no seats return 0, otherwise there
 * would be min 1 way ie no divider for 2 seats
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), traversing corridor once
 * 
 * Space complexity:
 * 
 * O(n), storing index of seats
 * 
 */
class Solution {
    public int numberOfWays(String corridor) {

        int mod = (int) 1e9 + 7;
        List<Integer> pos = new ArrayList();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S')
                pos.add(i);
        }

        if (pos.size() % 2 != 0 || pos.isEmpty())
            return 0;

        long ans = 1;
        // size should be 2, extreme right end of first block
        int prev = pos.get(1);

        // do computation then make curr as prev and move to next block
        for (int i = 2; i < pos.size(); i += 2) {
            int length = pos.get(i) - prev;
            ans = (ans * length) % mod;
            prev = pos.get(i + 1);
        }

        return (int) ans;
    }
}