import java.util.Stack;

class MyQueueUsStack {

    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public MyQueueUsStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        //2��ջ���ǿ���ζ�Ŷ���Ϊ��
        if (empty()) {
            return -1;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    //�ж�ģ��ʵ�ֵĶ����Ƿ�Ϊ��
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */