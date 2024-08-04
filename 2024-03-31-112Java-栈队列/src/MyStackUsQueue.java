import java.util.LinkedList;
import java.util.Queue;

class MyStackUsQueue {
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;

    public MyStackUsQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    //入栈
    public void push(int x) {
        if (empty()) {
            queue1.offer(x);
            return;
        }
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    //出栈
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    //获取栈顶元素
    public int top() {
        if (empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            int ret = -1;
            for (int i = 0; i < size; i++) {
                ret = queue1.poll();
                queue2.offer(ret);
            }
            return ret;
        } else {
            int size = queue2.size();
            int ret = -1;
            for (int i = 0; i < size; i++) {
                ret = queue2.poll();
                queue1.offer(ret);
            }
            return ret;
        }
    }

    //栈是否为空
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */