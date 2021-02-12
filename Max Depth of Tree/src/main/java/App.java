import java.util.List;

public class App {
    public static void main(String[] args) {
        
    }
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};



        public static int maxDepth(Node root) {
            if(root==null) return 0;
            int Max=0;
            for(Node child : root.children){
                if(child!=null) Max=Math.max(Max,maxDepth(child));
            }
            return Max + 1;

        }
    }

