package linkedlist;

import com.alibaba.fastjson.JSON;
import common.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class LinkedListAlgoTest {

    @Test
    public void reverse() throws Exception {
        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node list = linkedListAlgo.reverse(node1);
        log.info(JSON.toJSONString(list));
    }

    @Test
    public void hasCircle() throws Exception {
        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        boolean has = linkedListAlgo.hasCircle(node1);
        Assert.assertTrue(has);
    }

    @Test
    public void deleteLastKthNode() throws Exception {
        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node list = linkedListAlgo.deleteLastKthNode(node1, 2);
        log.info(JSON.toJSONString(list));

    }

}