/**
 * 1187. Make Array Strictly Increasing
 * 
 * Intuition
 * 
 * This question is created by a girl based on partner choices :P.
 * credits MohakHarjani
 * There is choice involved so there will be recursion and to avoid same
 * computation will use memoization for which we will have a dp array.
 * There are two scenarios
 * case 1 -> arr[i] <= arr[i-1]
 * In this prev no is greater than curr no so we need to search no in arr2 that
 * is greater than prev no and replace curr no in arr1 to make it strictly
 * increasing.
 * To find greater no in arr2 we use binary serach.
 * case 2 -> arr[i] > arr[i-1]
 * accept
 * In this curr no is greater than prev no and no action is required.
 * decline
 * In this we can still go ahead to find greater no than prev no in arr2. It is
 * possible curr no can lead to large operations in future, so trying to
 * optimize.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*m*logn)
 * 
 * for each(currIdx, prev) call there are arr.length choices for currIdx and for
 * prev there are arr.length nos choices so O(n^2)
 * 
 * for each choice binary search is there so O(n^2*logn)
 * 
 * Space complexity:
 * 
 * O(n*m)
 * to store n^2 choices
 * 
 */
class Solution {
    int int_max = Integer.MAX_VALUE;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {

        Arrays.sort(arr2);
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap();
        int ans = solve(arr1, arr2, map, 0, -1);
        return (ans == int_max ? -1 : ans);
    }

    int solve(int[] arr1, int[] arr2, HashMap<Pair<Integer, Integer>, Integer> map,
            int currIdx, int prev) {
        if (currIdx == arr1.length)
            return 0;
        if (map.containsKey(new Pair<>(currIdx, prev)))
            return map.get(new Pair<>(currIdx, prev));
        int x, y, z;
        x = y = z = int_max;
        int newCurr, curr;
        newCurr = curr = arr1[currIdx];

        // case 1
        if (arr1[currIdx] <= prev) {
            newCurr = getBigger(arr2, prev);
            if (newCurr > prev)
                x = solve(arr1, arr2, map, currIdx + 1, newCurr);
            if (x != int_max)
                x++;
        } else {
            // case 2(accept)
            y = solve(arr1, arr2, map, currIdx + 1, curr);

            newCurr = getBigger(arr2, prev);
            // case 3(decline)
            if (newCurr > prev)
                z = solve(arr1, arr2, map, currIdx + 1, newCurr);
            if (z != int_max)
                z++;
        }
        int res = Math.min(x, Math.min(y, z));
        map.put(new Pair<>(currIdx, prev), res);
        return res;
    }

    int getBigger(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                ans = arr[mid];
                h = mid - 1;
            }
        }
        return ans;
    }
}