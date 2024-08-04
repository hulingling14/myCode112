public class MyQueue {
    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = last.next;
        }
    }

    public int poll() {
        if (head == null) {
            return -1;
        }
        int ret = head.val;
        if (head.next == null) {
            head = null;
            last = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return ret;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
