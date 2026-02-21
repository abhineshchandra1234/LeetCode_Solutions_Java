// 762. Prime Number of Set Bits in Binary Representation

/**
 * Intuition
 * 10^6 is the limit which is equal to 2^20, so we need 20 bits
 * so we store prime nos till 20 in a set
 * Then just count no of bits of each no, if the set contains it, it is prime
 * Increase res for each prime and return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), traversing through nos and counting their set bits
 * Space complexity: O(1)
 */

class Solution {
    public int countPrimeSetBits(int left, int right) {

        int res = 0;
        HashSet<Integer> primes = new HashSet(Arrays.asList(2, 3, 5, 7, 11,
                13, 17, 19));

        for (int no = left; no <= right; no++) {
            int setBits = Integer.bitCount(no);
            if (primes.contains(setBits))
                res++;
        }

        return res;
    }
}