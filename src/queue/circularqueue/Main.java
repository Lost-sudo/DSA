package queue.circularqueue;

public class Main {
    public static void main(String[] args) {
        Queue newQueue = new Queue(3);
        newQueue.enQueue(1);
        newQueue.enQueue(2);
        newQueue.enQueue(3);
        System.out.println(newQueue.deQueue());
        System.out.println(newQueue.deQueue());
        System.out.println(newQueue.peek());
        newQueue.enQueue(4);
        newQueue.enQueue(5);
        newQueue.enQueue(6);
        System.out.println(newQueue.peek());
        System.out.println(newQueue.isEmpty());
        System.out.println(newQueue.isFull());
        newQueue.deleteQueue();
    }
}

class Queue {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public Queue(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The Queue has been created with size: " + size);
    }

    // isEmpty
    public boolean isEmpty() {
        return topOfQueue == -1;
    }

    // isFull
    public boolean isFull() {
        if (topOfQueue + 1 == beginningOfQueue) {
            return true;
        } else return (beginningOfQueue == 0) && (topOfQueue + 1 == size);
    }

    // enQueue
    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The Queue is full.");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("The value has been successfully inserted.");
        } else {
            if (topOfQueue + 1 == size) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arr[topOfQueue] = value;
            System.out.println("The value has been successfully inserted.");
        }
    }

    // deQueue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The Queue is empty.");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            arr[beginningOfQueue] = Integer.MIN_VALUE;
            if (beginningOfQueue == topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue + 1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
            return result;
        }
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("The Queue is empty.");
            return -1;
        } else {
            return arr[beginningOfQueue];
        }
    }

    // Delete Queue
    public void deleteQueue() {
        arr = null;
        System.out.println("The Queue has been successfully deleted.");
    }
}
