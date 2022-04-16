package utils;

import java.util.List;

/**
 * @moduleName: Node
 * @description: N 叉树
 * @author: 杨睿
 * @date: 2022-04-10 15:59
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
