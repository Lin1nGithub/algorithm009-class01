package NTree;

import java.util.List;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/9/25 11:52
 */
public class Node {

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


}
