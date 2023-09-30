/* Remove Linked List Elements */

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
    public ListNode removeElements(ListNode head, int val) {
      while (head!=null && head.val == val) {
        head = head.next;
      }

      if(head==null) {
        return head;
      }

      ListNode tempPrev = head, tempNext = head.next;

      while(tempNext!=null) {
        if (tempNext.val == val) {
          tempPrev.next = tempNext.next;
          tempNext = tempPrev.next;
        } else {
          tempPrev = tempPrev.next;
          tempNext = tempNext.next; 
        }
      }

      return head;
    }
}

/*
  Let's illustrate this with an example. Consider the following linked list:
  
  Input: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
  In the first while loop, we start removing nodes with the value 6 from the beginning of the list. So, after this loop, we have:
  
  Result after first while loop: 1 -> 2 -> 3 -> 4 -> 5
  Next, we initialize two pointers, tempPrev and tempNext, both initially pointing to the head of the list (1).
  
  We then enter the second loop and iterate through the list. Whenever we encounter a node with the value 6, we remove it by adjusting the next pointers of the previous node (tempPrev) to bypass the current node (tempNext). If the node's value is not 6, we simply move both pointers to the next nodes.
  
  After the second loop completes, we have removed all nodes with the value 6 from the list.
  
  Finally, we return the updated head of the list, which is 1 -> 2 -> 3 -> 4 -> 5.
  
  The code effectively removes all occurrences of the specified value val from the linked list and returns the modified list.
*/
