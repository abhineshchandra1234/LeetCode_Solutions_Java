/**
 * 2595. Number of Even and Odd Bits
 * 
 * approach-
 * we will first find the binary equivalent of n and store it in an array.
 * we find binary equivalent by storing modulo of n with 2 and decreasing n by dividing by 2.
 * Then we will reverse the array to get the binary equivalent.
 * we will traverse the array and check for 1, and increase even and odd counts based on the index.
 * 
 * Time - O(n)
 * Space - O(n)
 */
class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        
        int[] binary = new int[35];
        int id = 0;
        
        while(n>0) {
            binary[id++] = n%2;
            n /= 2;
        }
        
        int even=0,odd=0;
        for(int i=0; i<id; i++) {
            if(binary[i]==1) {
                if(i%2==0)
                    even++;
                else
                    odd++;
            }
        }
        res[0] = even;
        res[1] = odd;
        
        return res;
    }
}