# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will convert date into no of days from start of the month like - 240 days or 130 days etc
- then we can easily calculate overlap by the formula `int overlap = Math.min(leaAlice, leaBob)
                - Math.max(arrAlice, arrBob) + 1;`
- to calculate days we will have a cumalative array, which will store no of days till the curr month and day

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(1)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int[] cumalative = new int[13];
        cumalative[1] = 31;
        for (int i = 1; i <= 12; i++) {
            cumalative[i] = cumalative[i - 1] + days[i - 1];
        }

        int arrAlice = calDays(arriveAlice, cumalative);
        int leaAlice = calDays(leaveAlice, cumalative);
        int arrBob = calDays(arriveBob, cumalative);
        int leaBob = calDays(leaveBob, cumalative);

        int overlap = Math.min(leaAlice, leaBob)
                - Math.max(arrAlice, arrBob) + 1;

        return Math.max(overlap, 0);
    }

    private int calDays(String day, int[] cumalative) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return cumalative[month - 1] + date;
    }
}
```