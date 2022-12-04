package algorithm.dfs;

import org.junit.jupiter.api.Test;

/**
 * @author gutenlee
 * @since 2022/09/25
 */
public class DepthFirstSearchTest01 {

    @Test
    void test() throws Exception {
        Node root = new Node(9);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        dfs(root);
    }

    public void dfs(Node root){
        if (root == null) return;
        else {
            dfs(root.lt);
            System.out.print(root.data + " ");
            dfs(root.rt);

        }
    }


}

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt=rt=null;
    }
}
