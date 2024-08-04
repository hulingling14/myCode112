import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);//β�巨
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.poll());//ͷɾ
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }

    public static void main3(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);//β�巨
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.poll());//ͷɾ
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }

    public static void main2(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(10);//ͷ�巨��ջ
        stack.push(20);
        stack.push(30);

        stack.pop();

        //˫�˶���
        Deque<Integer> stack2 = new LinkedList<>();
        stack2.push(10);
    }

    public boolean IsPopOrder(int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while (j < popV.length && !stack.empty() && stack.peek() == popV[i]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //1.��������ջ
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                //2.������������
                if (stack.empty()) {
                    return false;
                } else {
                    //3.ȡջ��Ԫ�ص������ſ��͵�ǰ�������Ƿ�ƥ��
                    char chL = stack.peek();
                    if (chL == '(' && ch == ')' || chL == '[' && ch == ']' || chL == '{' && ch == '}') {
                        //4.֤����ǰ��һ��������ƥ���
                        stack.pop();
                    } else {
                        //5.��ǰ���Ų�ƥ��
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            if (!isOperation(tmp)) {
                Integer val = Integer.valueOf(tmp);
            } else {
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                switch (tmp) {
                    case "+":
                        stack.push(val1 + val2);
                        break;
                    case "-":
                        stack.push(val1 - val2);
                        break;
                    case "*":
                        stack.push(val1 * val2);
                        break;
                    case "/":
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isOperation(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main1(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
    }
}
