/**
 * 605. Can Place Flowers
 * 
 * approach-
 * we will solve this greedily by placing plants at every empty place from left to right
 * we will use two vars prev & next, to place flowers in the empty place.
 * prev value will be 0 for index 0 and the next value will be 0 for the last index.
 * loop will be broken when the count becomes equal to n or when we reached the end of array
 * 
 * Time - O(n)
 * Space - O(1)
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0;i<flowerbed.length && count<n;i++) {
            if(flowerbed[i]==0) {
                int prev = (i==0)?0:flowerbed[i-1];
                int next = (i==flowerbed.length-1)?0:flowerbed[i+1];
                if(prev==0&&next==0) {
                    flowerbed[i]=1;
                    count++;
                }
            }
        }
        return count==n;
    }
}