/* Combination Sum III */

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    void combination(List<Integer> subList, int k, int n, int idx) {
        if(subList.size() > k || n < 0) {
            return;
        }

        if(n == 0 && subList.size() == k) {
            list.add(new ArrayList<>(subList));
            return;
        }

        if (idx >= num.length) {
            return;
        }

        subList.add(num[idx]);
        combination(subList, k, n - num[idx], idx + 1);
        subList.remove(subList.size()-1);
        combination(subList, k, n, idx + 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        combination(new ArrayList<>(), k, n, 0);
        return list;
    }
}

/*
Let's say you want to find all combinations of 3 numbers that sum up to 15. You call the combinationSum3(3, 15) method with k = 3 and n = 15.

The combination method uses a recursive approach to explore different combinations. It maintains three key conditions:

If the size of the current subList exceeds k (the required number of elements) or if the remaining sum n becomes negative, the method returns, as this path is invalid.

If the remaining sum n becomes 0, and the size of the subList is equal to k, a valid combination is found. It is added to the result list.

If the current index idx goes beyond the range of available numbers (1 through 9), the method returns to backtrack.

The method starts with an empty subList, 0 as the remaining number of elements k, the target sum n, and the initial index 0. It explores different combinations, incrementally adding and removing numbers from the subList.

The combinationSum3 method initializes an empty list to store the valid combinations. It then calls the combination method to populate this list with all valid combinations.

The result is a list of lists, where each inner list represents a valid combination of k numbers that sum up to n, adhering to the specified conditions. These combinations are not repeated, and they may be in any order as required.

For example, calling combinationSum3(3, 15) would result in a list of valid combinations like:

[1, 2, 12]
[1, 3, 11]
[1, 4, 10]
...
[3, 4, 8]
...
[7, 8, 9]
These combinations satisfy the conditions mentioned and have a sum of 15.
*/
