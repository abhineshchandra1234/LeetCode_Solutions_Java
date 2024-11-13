/**
 * 2491. Divide Players Into Teams of Equal Skill
 * 
 * Intuition
 * we will solve this problem through sorting
 * we can get the target by dividing total sum of skills by no of teams or sum
 * of first and last team in sorted order
 * then we need to check whether each team skills total is equal to target or
 * not
 * best team match up will one low and other high
 * if all teams fulfills the criteria , return total chemistry at the end
 * for each valid team we will add its chemistry or product of its skills to
 * total chemistry
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(logn), sorting
 */
class Solution {

    public long dividePlayers(int[] skill) {

        Arrays.sort(skill);

        int n = skill.length;
        long res = 0;

        int target = skill[0] + skill[n - 1];

        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - i - 1] != target)
                return -1;
            res += (long) skill[i] * (long) skill[n - i - 1];
        }

        return res;
    }
}