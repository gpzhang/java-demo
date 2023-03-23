package heap;

import java.util.PriorityQueue;

/**
 * 优先级队列的实现是基于堆这种数据结构
 * <p>
 * 堆这种数据结构，简单认为就是完全二叉树
 * BTW：满二叉树一定是完全二叉树
 */
public class HeapDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(0);
        priorityQueue.add(4);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
