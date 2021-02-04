import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {

    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        //recursion
        Set<ListNode> nodeValues=new HashSet<>();
        boolean isCylce =false;
        if(head==null & head.next==null) return false;
        else{
            ListNode current=head;
            if(nodeValues.contains(current)){
                return true;


            }
            nodeValues.add(current);
            //current=current.next;
            return hasCycle(current.next);
        }
//        //looping
//        boolean isCycle=false;
//        Set<ListNode> nodeValues=new HashSet<>();
//
//        ListNode current=head;
//
//
//        while (current!=null){
//            if(nodeValues.contains(current)) isCycle=true;
//
//        }
//        nodeValues.add(current);
//        current=current.next;
//
//        return isCycle;


    }
}

