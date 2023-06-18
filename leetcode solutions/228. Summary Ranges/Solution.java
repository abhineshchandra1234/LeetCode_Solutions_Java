/**
 * 228. Summary Ranges
 * 
 * Intuition
 * credits aryanttripathi
 * We will solve this problem using two ptrs.
 * First ptr will be used to traverse the array and second ptr will be used to
 * make the comparison and add strings to res.
 * We will keep on incresing second ptr j till nums[j+1]==nums[j]+1
 * then if second ptr j is greater than i then we take string nums[i]->nums[j]
 * else only nums[i].
 * Then we will add this string to res.
 * Then intialize i to j. To avoid already computed values.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {

        int n = nums.length;
        List<String> ans = new ArrayList();

        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1)
                j++;

            if (j > i) {
                temp.append(nums[i] + "");
                temp.append("->");
                temp.append(nums[j] + "");
            } else
                temp.append(nums[i] + "");

            ans.add(temp.toString());
            i = j;
        }
        return ans;
    }
}