//2582. Pass the Pillow
/*
 * approach -
 * We will solve this problem using boolean flag. If the flag is false it will increase i else will decrease it
 * reverse the flag when i value is n or 1.
 * 
 * Time - O(n)
 * Space - O(1)
 */
class Solution {
    public int passThePillow(int n, int time) {
        
        boolean reverse = false;
        int i=1;
        for(int j=0; j<time; j++) {
            
            if(!reverse)
                i++;
            if(reverse)
                i--;
            if(i==n || i==1)
                reverse = !reverse;
        }
        return i;
    }
}