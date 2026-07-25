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
        ListNode tempHead = head;
        List<Integer> a = new ArrayList<>();
        while(tempHead !=null) {
            a.add(tempHead.val);
            tempHead = tempHead.next;
        }
        tempHead = head;
       for(int i = a.size()-1;i>=0;i--){
           tempHead.val = a.get(i);
           tempHead = tempHead.next;
       }
        return head;
    }
}