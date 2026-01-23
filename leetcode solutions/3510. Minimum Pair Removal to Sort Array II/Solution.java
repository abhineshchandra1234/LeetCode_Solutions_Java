// 3510. Minimum Pair Removal to Sort Array II

/**
 * Intuition
 * this problem is similar to 3507. Minimum Pair Removal to Sort Array I with
 * constraints increase
 * we first created a temp array, so that it can handle large values of nums
 * we are not going to delete nos from temp to save time
 * then we have minPairSet which will have sum,index as pair
 * It will first compare sum and then index for lesser value
 * Then we have created nextIndex and prevIndex to store next and prev index of
 * nums or temp nos
 * Then we are calculating badPairs and adding pair of sum,index to minPairSet
 * Then we will run a loop till badPairs are greater than 0, for non-decreasing
 * array we need badPairs count as 0
 * then we have if first_left was a bad pair earlier with first and now it is a
 * good pair with first and second then badPairs count will reduce
 * Then we have if first_left was a good pair and now it is bad pair with first
 * and second, badPairs count will increase
 * These two conditions will be same for second_right
 * Then we are removing first_left and first pair and adding first_left with
 * first and second pair
 * Same we are doing for second_right
 * Finally increasing the operations count
 * At last returning the operations count
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*logn), we can have max n-1 bad pairs, we are taking logn
 * time to remove all
 * Space complexity: O(n), using TreeSet and storing next and prev index
 */

class Solution {

    static class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            return sum == p.sum && idx == p.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, idx);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        // {a, b, c, d} -> {a, b+c, d}
        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }

        TreeSet<Pair> minPairSet = new TreeSet<>(
                (a, b) -> {
                    if (a.sum != b.sum)
                        return Long.compare(a.sum, b.sum);
                    return Integer.compare(a.idx, b.idx);
                });

        int[] nextIndex = new int[n];
        int[] prevIndex = new int[n];

        for (int i = 0; i < n; i++) {
            nextIndex[i] = i + 1;
            prevIndex[i] = i - 1;
        }

        int badPairs = 0;
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] > temp[i + 1]) {
                badPairs++;
            }
            minPairSet.add(new Pair(temp[i] + temp[i + 1], i));
        }

        int operations = 0;

        while (badPairs > 0) {

            Pair cur = minPairSet.first();
            minPairSet.remove(cur);

            int first = cur.idx;
            int second = nextIndex[first];

            int first_left = prevIndex[first];
            int second_right = nextIndex[second];

            if (temp[first] > temp[second]) {
                badPairs--;
            }

            // {d, (a, b)}
            if (first_left >= 0) {
                if (temp[first_left] > temp[first] &&
                        temp[first_left] <= temp[first] + temp[second]) {
                    badPairs--;
                } else if (temp[first_left] <= temp[first] &&
                        temp[first_left] > temp[first] + temp[second]) {
                    badPairs++;
                }
            }

            // {(a, b), d}
            if (second_right < n) {
                if (temp[second_right] >= temp[second] &&
                        temp[second_right] < temp[first] + temp[second]) {
                    badPairs++;
                } else if (temp[second_right] < temp[second] &&
                        temp[second_right] >= temp[first] + temp[second]) {
                    badPairs--;
                }
            }

            if (first_left >= 0) {
                minPairSet.remove(
                        new Pair(temp[first_left] + temp[first], first_left));
                minPairSet.add(
                        new Pair(temp[first_left] + temp[first] + temp[second], first_left));
            }

            if (second_right < n) {
                minPairSet.remove(
                        new Pair(temp[second] + temp[second_right], second));
                minPairSet.add(
                        new Pair(temp[first] + temp[second] + temp[second_right], first));
                prevIndex[second_right] = first;
            }

            nextIndex[first] = second_right;
            temp[first] += temp[second];

            operations++;
        }

        return operations;
    }
}