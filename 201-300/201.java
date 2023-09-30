class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
          right = right & (right - 1);
        }

        return right;
    }
}

/*
  left (binary): 0101
  right (binary): 1100
  In the binary representations of left and right, we can see that the common prefix is 0100. This means the bitwise AND of all numbers in the range [5, 6, 7, 8, 9, 10, 11, 12] would have 0100 as their common prefix.
  
  Now, let's see how the loop progresses:
  
  In the first iteration, right becomes 1011 after performing right & (right - 1).
  
  In the second iteration, right becomes 1000.
  
  In the third iteration, right becomes 0000.
  
  Now, left < right is no longer true, so the loop exits. The final value of right is 0000 in binary, which is 0 in decimal.
  
  So, the result of the bitwise AND of all numbers in the range [5, 6, 7, 8, 9, 10, 11, 12] is indeed 0.
*/
