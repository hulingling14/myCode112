class MyCircularQueue {

    public int[] elem;
    public int first;
    public int last;

    public MyCircularQueue(int k) {
        elem = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elem[last] = value;
        last = (last + 1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        first = (first + 1) % elem.length;
        return true;
    }

    //得到对头元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[first];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (last == 0) ? elem.length - 1 : last - 1;
        return elem[index];
    }

    public boolean isEmpty() {
        return first == last;
    }

    public boolean isFull() {
        return (last + 1) % elem.length == first;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */