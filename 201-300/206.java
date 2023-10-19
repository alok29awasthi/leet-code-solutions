/* Reverse Linked List */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}

/*
Let's explain the code with an example:

Suppose we have a singly linked list as follows:

Input: 1 -> 2 -> 3 -> 4 -> 5
We initialize three pointers:

curr points to the current node, initially set to the head of the list (1).
prev points to the previous node, initially set to null as there's no previous node yet.
next will be used to temporarily store the next node in the list.
We start the loop, and in each iteration, we do the following:

Store the next node in next (next = curr.next).
Reverse the current node's pointer to the previous node (curr.next = prev).
Move prev and curr one step forward. prev becomes the current node, and curr becomes the next node (prev = curr, curr = next).
We continue this process until curr becomes null, which means we've reached the end of the original list. At this point, prev will be pointing to the last node of the original list, which is now the new head of the reversed list.

We return prev, which is the head of the reversed list.

After reversing, the linked list becomes:

Reversed List: 5 -> 4 -> 3 -> 2 -> 1
The code efficiently reverses a singly linked list by manipulating the pointers of each node, and it returns the new head of the reversed list.
*/
