/**
 * 46. Permutations
 * 
 * Intuition
 * 
 * to understand this problem it is very important to understand the difference
 * between permutation and combinations, as it is very similar to combinations.
 * If the order is important, then the problem is related to permutation, and
 * the possible number of samples will be, XY, YX, YZ, ZY, XZ, ZX. In this case,
 * XY is distinct from the sample YX, YZ is distinct from the sample ZY and XZ
 * is distinct from the sample ZX.
 * If the order is unnecessary, then the question is relevant to the
 * combination, and the possible samples will be XY, YZ and ZX.
 * As you can see from the example above X can come at any place(0,1) in the
 * list using permutation as order is important and it will be treated as a
 * distinct sample. XY & YX are distinct
 * But using combinations once X is the part of the list regardless of its
 * position in the list(0,1), It will be treated as same sample.
 * XY & YX are same sample.
 * that is why in permuation we always pick no from 0 to n for each positions
 * but in combinations we pick no from start=0 to n, where start is increasing
 * by 1
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*n!)
 * 
 * Space complexity: O(n*n)
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {

        if (temp.size() == nums.length)
            res.add(new ArrayList(temp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backtrack(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}