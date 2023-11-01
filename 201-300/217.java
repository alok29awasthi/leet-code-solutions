/* Contains Duplicate */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}

/*
Let's say you have the array nums:

int[] nums = {1, 2, 3, 4, 2, 5};
You call the containsDuplicate method with this array. It proceeds as follows:

Initialize an empty HashSet set to keep track of unique elements.

Iterate through the elements of the array nums.

For the first element, nums[0] is 1. Since set is empty, it doesn't contain 1, so we add it to the set. The set now contains [1].

Move on to the second element, nums[1] is 2. The set doesn't contain 2, so we add it to the set. The set now contains [1, 2].

Continue this process for the rest of the elements.

For the fifth element, nums[4] is 2. Now, when we check if the set contains 2, it does. So, we return true because we've found a duplicate element.

The method returns true because it has encountered a duplicate element in the array.

In this example, the array contains the value 2 twice, so the function returns true. If there were no duplicates in the array, the function would return false.
*/
