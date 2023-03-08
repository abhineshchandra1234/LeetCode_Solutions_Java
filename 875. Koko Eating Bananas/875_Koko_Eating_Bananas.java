/*
 * 875. Koko Eating Bananas
 * 
 * approach -
 * we will use binary search to solve this
 * koko can eat min 1 and max 10^9 bananas
 * we will take mid of this and calculate total hours at mid rate
 * If total hours is less than or equal to given hrs we got our k but we will try to 
 * optimise it by reducing right. ie trying to find even less k value.
 * else total hours is more than given hours we will try to reduce it by increasing left.
 * 
 * Time - O(nlogn)
 * Space - O(1)
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 1000000000;

        while(left<right) {
            int mid = left + (right-left)/2;
            if(canEatInTime(piles,mid,h))
                right = mid;
            else
                left = mid+1;
        }

        return left;
    }

    private boolean canEatInTime(int[] piles,int k,int h) {
        int hours = 0;
        for(int p: piles) {
            hours += p/k;
            if(p%k!=0)
                hours++;
        }
        return hours<=h;
    }
}