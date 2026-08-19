// 1386. Cinema Seat Allocation

/**
 * Intuition
 * we will take a map which will contain rows as key and its reserved seats as
 * values in a set
 * if map size is less than n, we will have 2 groups for each of the rows
 * we will check a particular group in the set
 * if groupA and groupC are avilable add 2 groups to res
 * otherwise all groups will conflict for one or more seats, add 1 group to res
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity:O(n)
 * Space complexity:O(n)
 */

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> mp = new HashMap();

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            mp.computeIfAbsent(row, k -> new HashSet()).add(seat);
        }

        int res = (n - mp.size()) * 2;

        for (Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
            Set<Integer> bookedSeats = entry.getValue();

            boolean groupA = !bookedSeats.contains(2) && !bookedSeats.contains(3)
                    && !bookedSeats.contains(4) && !bookedSeats.contains(5);
            boolean groupB = !bookedSeats.contains(4) && !bookedSeats.contains(5)
                    && !bookedSeats.contains(6) && !bookedSeats.contains(7);
            boolean groupC = !bookedSeats.contains(6) && !bookedSeats.contains(7)
                    && !bookedSeats.contains(8) && !bookedSeats.contains(9);

            if (groupA && groupC)
                res += 2;
            else if (groupA || groupB || groupC)
                res += 1;
        }
        return res;
    }
}