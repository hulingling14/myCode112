import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            Integer peekVal = minStack.peek();
            if (val <= peekVal) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        Integer popVal = stack.pop();
        if (popVal == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    //要求：常数时间范围内 获取到栈当中的最小值
    public int getMin() {
        if (minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}
