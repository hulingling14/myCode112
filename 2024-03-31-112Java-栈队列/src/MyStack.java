import java.util.Arrays;

public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[10];
    }

    public void push(int val) {
        if (isFull()) {
            //À©ÈÝ
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int oldVal = elem[usedSize - 1];
        usedSize--;
        return oldVal;
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        return elem[usedSize - 1];
    }

    public boolean empty() {
        return usedSize == 0;
    }
}
