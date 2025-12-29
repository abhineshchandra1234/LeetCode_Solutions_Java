/**
 * 135. Candy
 * 
 * Intuition
 * 
 * credits Cheng_Zhang
 * by default assign one candy to each child as per the requirement
 * scan from left->right, assign one more candy to higher rated right child
 * scan right->left, assign one more candy to higher rated left child
 * this covers second requiremt of high rated child having more candies than its
 * neighs.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int candy(int[] ratings) {

        int candies[] = new int[ratings.length];
        // each child receive 1 candy
        Arrays.fill(candies, 1);

        // scan left-> right, assign one more candy to higher rated right child
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        // scan right->left, assign one more candy to higher rated left child
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
        }

        int sum = 0;
        for (int candy : candies)
            sum += candy;
        return sum;
    }
}

// kotlin

class Solution {
    fun candy(ratings: IntArray): Int {
        
        val n = ratings.size
        val candies = IntArray(n) {1}

        for(i in 1 until n) {
            if(ratings[i]>ratings[i-1])
                candies[i] = candies[i-1] + 1
        }

        for(i in n-2 downTo 0) {
            if(ratings[i]>ratings[i+1])
                candies[i] = Math.max(candies[i], (candies[i+1]+1))
        }

        return candies.sum()
    }
}