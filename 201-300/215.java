/* Kth Largest Element */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        k = nums.length - k + 1;
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }

        while(k!=1) {
            pq.poll();
            k--;
        }       

        return pq.peek(); 
    }
}

/*
Suppose we have nums = [3, 2, 1, 5, 6, 4] and k = 2.

Initialize pq and transform k to k = 6 - 2 + 1 = 5.

Start iterating through nums:

When we add 3, pq contains [3].
When we add 2, pq contains [2, 3].
When we add 1, pq contains [1, 2, 3].
When we add 5, pq contains [1, 2, 3, 5].
When we add 6, pq contains [1, 2, 3, 5, 6].
When we add 4, pq contains [1, 2, 3, 4, 5, 6].
Perform k - 1 (4) poll operations:

After the first poll, pq contains [2, 3, 4, 5, 6].
After the second poll, pq contains [3, 4, 5, 6].
After the third poll, pq contains [4, 5, 6].
After the fourth poll, pq contains [5, 6].
The root of pq now contains the 2nd largest element, which is 5.

So, the code returns 5 as the 2nd largest element in the nums array.
*/
