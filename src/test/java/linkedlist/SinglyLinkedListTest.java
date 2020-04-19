package linkedlist;

import com.alibaba.fastjson.JSON;
import com.sun.prism.es2.ES2Graphics;
import common.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class SinglyLinkedListTest {

    @Test
    public void insert2HeadByNode() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Head(node1);
        list.insert2Head(node2);
        list.insert2Head(node3);
        list.insert2Head(node4);

        log.info(list.toString());
    }

    @Test
    public void testInsert2HeadByValue() throws Exception {

        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Head(1);
        list.insert2Head(2);
        list.insert2Head(3);
        list.insert2Head(4);
        list.insert2Head(5);

        log.info(list.toString());
    }

    @Test
    public void insert2TailByNode() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        log.info(list.toString());
    }

    @Test
    public void testInsert2TailByValue() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(1);
        list.insert2Tail(2);
        list.insert2Tail(3);
        list.insert2Tail(4);

        log.info(list.toString());
    }

    @Test
    public void insertValueAfterNode() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        list.insertAfter(node1, 10);
        log.info(list.toString());
    }

    @Test
    public void testInsertNodeAfterNode() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        list.insertAfter(node1, new Node(10, null));
        log.info(list.toString());
    }

    @Test
    public void insertNodeBeforeNode() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        list.insertBefore(node2, new Node(9, null));
        log.info(list.toString());
    }

    @Test
    public void testInsertNodeBeforeValue() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        list.insertBefore(node2, 9);
        log.info(list.toString());
    }

    @Test
    public void findByValue() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        Node n = list.findByValue(2);
        log.info(JSON.toJSONString(n));
    }

    @Test
    public void findByIndex() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        Node n = list.findByIndex(1);
        log.info(JSON.toJSONString(n));
    }

    @Test
    public void deleteByNode() throws Exception {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(node1);
        list.insert2Tail(node2);
        list.insert2Tail(node3);
        list.insert2Tail(node4);

        list.deleteByNode(node2);

        log.info(list.toString());
    }

    @Test
    public void deleteFirstByValue() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert2Tail(1);
        list.insert2Tail(2);
        list.insert2Tail(3);
        list.insert2Tail(4);
        list.insert2Tail(5);
        log.info(list.toString());

        list.deleteFirstByValue(2);
        log.info(list.toString());
    }
}