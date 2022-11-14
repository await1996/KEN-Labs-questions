package LeetCode_Algo;

import java.util.HashMap;

class LeetCode146 {
    class Node {
        int k;
        int v;
        Node pre;
        Node next;
        Node() {}
        Node(int key, int value) {
            k = key;
            v = value;
        }
    }

    HashMap<Integer, Node> map;
    int cap;
    int size;
    Node head;
    Node tail;
    public LeetCode146(int capacity) {
        map = new HashMap<>();
        size = 0;
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node tmp = map.get(key);
        removeToHead(tmp);
        return tmp.v;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.v = value;
            removeToHead(tmp);
        } else {
            Node node = new Node(key, value);
            if (size == cap) {
                Node del = tail.pre;
                remove(del);
                map.remove(del.k);
                size--;
            }
            addHead(node);
            map.put(key, node);
            size++;
        }
    }

    public void removeToHead(Node node) {
        remove(node);
        addHead(node);
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //node.pre = null;
        //node.next = null;
    }

    public void addHead(Node node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }
}
