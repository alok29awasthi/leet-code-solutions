/* House Robber II */

class Solution {
    private int sum(int[] nums, int i, int end, int[] memo) {
        if(i >= end) {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }
        
        int sum1 = nums[i] + sum(nums, i+2, end, memo);
        int sum2 = sum(nums, i+1, end, memo);
        memo[i] = Math.max(sum1, sum2);

        return memo[i];
    }

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] memo = new int[nums.length];
        
        Arrays.fill(memo, -1);
        int sum1 = sum(nums, 0, nums.length - 1, memo);
        Arrays.fill(memo, -1);
        int sum2 = sum(nums, 1, nums.length, memo);

        return Math.max(sum1, sum2);
    }
}

/*
Suppose you have an array nums representing the amount of money in each house:
nums = [2, 3, 2]
In this example, there are three houses arranged in a circle.

The rob method in the provided solution is responsible for solving the problem. It uses dynamic programming and memoization to find the maximum amount of money you can rob without alerting the police.

Here's how the code works:

The sum method is a recursive helper function. It starts at a given index i and considers robbing the houses from index i to end. The base case is when i is greater than or equal to end, in which case it returns 0 because there are no more houses to consider.

To avoid recomputing the same subproblems, the function uses a memoization array (memo) to store the maximum amount that can be robbed starting from a specific index i. If memo[i] is not equal to -1, it means that this subproblem has already been solved, so the function returns memo[i].

The function calculates two possible scenarios:

sum1: Rob the house at index i (nums[i]) and skip the next house (considering the house at index i+2).
sum2: Skip the current house (considering the house at index i+1).
The function stores the maximum amount from the two scenarios in the memo array (memo[i]) and returns this value.

In the rob method, two calls to the sum function are made with different starting indices. One call considers robbing the first house and skipping the last one (sum1), and the other call considers robbing the second house and including the last one (sum2).

Finally, the rob method returns the maximum value between sum1 and sum2 because it's possible that the solution lies in either of these scenarios.

In the example (nums = [2, 3, 2]), the code would calculate the following:

sum1 = 2 + 2 = 4: Rob the first house and the last house.
sum2 = 3: Skip the first house and rob the second house.
The result is Math.max(4, 3), which is 4. So, the maximum amount you can rob without alerting the police in this case is 4.
*/
