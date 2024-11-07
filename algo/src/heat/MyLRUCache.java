package heat;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表<Integer, Node> + 双向链表
 * 1. get(key)
 *  1）不存在，返回-1
 *  2）存在，将node移动到头部，返回value
 * 2. put(key,value)
 *  1）key不存在，创建newNode并加入map，检查capacity，若超出删除尾部node
 *  2）key存在，更新值，将node移动到头部
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 8:53
 */
public class MyLRUCache {

    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> cache = new HashMap<>();


    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node = cache.get(key);
        if (node == null){
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            if (cache.size() > capacity){
                Node tail = removeTail();
                cache.remove(tail.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail(){
        Node tail = this.tail.prev;
        removeNode(tail);
        return tail;
    }
}
