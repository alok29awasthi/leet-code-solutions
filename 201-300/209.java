/* Minimum Size Subarray Sum */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, minLength = Integer.MAX_VALUE;

        while(left <= right && right < nums.length) {
            sum += nums[right];
            if(sum >= target) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                }
                while(sum >= target && left <= right) {
                    sum -= nums[left++];
                    if(sum >= target && right - left + 1 < minLength) {
                        minLength = right - left + 1;
                    }
                }
            }
            right++;
        }

        if(minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }
}

/*
Suppose you have the nums array: [2, 3, 1, 2, 4, 3], and the target is 7.

Initially, left and right are both at index 0. The sum is 0, and minLength is set to Integer.MAX_VALUE.

The code iterates through the array while increasing the right pointer. It adds the values to the sum.

When right reaches index 2, the current subarray sum is 6, and it's not greater than the target (7).

When right reaches index 4, the current subarray sum is 9, which is greater than the target (7). The code then enters the inner while loop, trying to minimize the subarray length while keeping the sum above or equal to the target.

The inner while loop moves the left pointer, and when left reaches index 1, the current subarray sum is 7, which is equal to the target. The length of this subarray (from index 1 to 4) is 4, which is less than the current minLength. So, minLength is updated to 4.

The outer loop continues, and right eventually reaches the end of the array.

The result is that the minimal length of a subarray with a sum greater than or equal to the target is 4.

In this example, the subarray [3, 1, 2, 4] has a sum of 10, which is greater than or equal to the target of 7.
*/
