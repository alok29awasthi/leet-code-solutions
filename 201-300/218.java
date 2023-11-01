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

int[] nums = {1, 2, 3, 1, 4, 2};
You call the containsDuplicate method with this array. The algorithm proceeds as follows:

Initialize an empty HashSet set. This set will be used to store unique values from the array.

Iterate through the elements of the array nums using a for loop. During each iteration:

Check if the current element nums[i] is already in the set. If it's present in the set, this means it's a duplicate element, so the function returns true.
If the element is not in the set, add it to the set.
If the loop completes without finding any duplicate elements, the function returns false.

In the example array, the element 1 appears twice at indices 0 and 3, and the element 2 also appears twice at indices 1 and 5. Since there are duplicates in the array, the function returns true. If there were no duplicates, it would return false.
*/
