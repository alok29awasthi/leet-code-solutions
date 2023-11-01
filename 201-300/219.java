/* Comtains Duplicate II */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}

/*
Let's say you have the array nums and k:

int[] nums = {1, 2, 3, 1, 4, 2};
int k = 3;
You call the containsNearbyDuplicate method with this array and k. The algorithm proceeds as follows:

Initialize an empty HashMap map. This map will store each element of the array as a key and its index as the value.

Iterate through the elements of the array nums using a for loop. During each iteration:

Check if the current element nums[i] is already in the map (i.e., it's a key).

If it is, calculate the absolute difference between the current index i and the stored index map.get(nums[i]). If this difference is less than or equal to k, return true because you've found two equal elements within the maximum distance k.

If the condition is not met, update the map with the current element as the key and its index i as the value.

If the loop completes without finding a valid pair of indices, return false.

In this example, the array contains a duplicate element 1 at indices 0 and 3, and their absolute difference is 3, which is equal to k. So, the function returns true. If no such pair of indices exists in the array that meets the conditions, the function returns false.
*/
