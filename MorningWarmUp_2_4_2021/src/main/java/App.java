import java.util.LinkedList;

public class App {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {

      

    }




    public static ListNode swapPairs(ListNode head) {
        if (head == null && head.next == null) return head;

        ListNode current = head.next;
        ListNode nextCurrent = current.next;

        current.next = head;
        head.next = swapPairs(nextCurrent);

        return current;


    }
}

