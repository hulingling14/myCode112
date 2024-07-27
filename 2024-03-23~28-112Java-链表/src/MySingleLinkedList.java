public class MySingleLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;//���������ͷ�ڵ�

    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        this.head = node1;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //��ָ��λ��newHead��ʼ��ӡ����
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //�õ�������ĳ���
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //ͷ�巨
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    //β�巨
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //����λ�ò���,��һ�����ݽڵ�Ϊ0���±�
    public void addIndex(int index, int val) {
        //1.�ж�index�ĺϷ���
        try {
            checkIndex(index);
        } catch (IndexNotLegalException e) {
            e.printStackTrace();
        }
        //2.index==0||index==size()
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size()) {
            addLast(val);
            return;
        }
        //3.�ҵ�index��ǰһ��λ��
        ListNode cur = findIndexSubOne(index);
        //4.��������
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
    }

    private ListNode findIndexSubOne(int index) {
        int count = 0;
        ListNode cur = head;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) throws IndexNotLegalException {
        if (index < 0 || index > size()) {
            throw new IndexNotLegalException("index���Ϸ�");
        }
    }

    //�����Ƿ�����ؼ���key�Ƿ��ڵ�������
    public boolean contains(int val) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //ɾ����һ�γ��ֹؼ���Ϊkey�Ľڵ�
    public void remove(int val) {
        if (head.val == val) {
            head = head.next;
            return;
        }
        //�ҵ���ǰ��Ҫɾ��ֵ�Ľڵ��ǰһ��
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode del = cur.next;
                cur.next = del.next;
                return;
            }
            cur = cur.next;
        }
    }

    //ɾ������ֵΪkey�Ľڵ�
    public void removeAllKey(int val) {
        //1.�п�
        if (head == null) {
            return;
        }
        //2.����prev��cur
        ListNode prev = head;
        ListNode cur = head.next;
        //3.��ʼ�жϲ���ɾ��
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        //4.����ͷ�ڵ�
        if (head.val == val) {
            head = head.next;
        }
    }

    public void clear() {
        //head=null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curN = cur.next;
            //cur.val=null;
            cur.next = null;
            cur = curN;
        }
        head = null;
    }

    //��תһ��������
    public ListNode reverseList() {
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curN = cur.next;
            //��ʼ��ת
            cur.next = head;
            head = cur;
            cur = curN;
        }
        return head;
    }

    //������м�ڵ㣨����һ������ͷ�ڵ�head�ķǿյ���������������м�ڵ㡣����������м�ڵ㣬�򷵻صڶ����м�ڵ㡣��
    public ListNode middleNode() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //���ص�����K���ڵ�
    public int kthToLast(int k) {
        if (k <= 0) {
            //k���Ϸ�
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        //1.����fast��k-1��
        int count = 0;
        while (count != k - 1) {
            fast = fast.next;
            if (fast == null)
                return -1;
            count++;
        }
        //2.Ȼ��һ���ߣ���fast�ߵ����һ���ڵ��ʱ��slow��λ�þ��ǵ�����k���ڵ�
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    //����ָ��д���룬�Ը���ֵxΪ��׼������ָ�������֣�����С��x�Ľڵ����ڴ��ڻ����x�Ľڵ�֮ǰ����
    public ListNode partition(int x) {
        if (head == null) return null;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                //��һ�β���
                if (bs == null) {
                    bs = be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
                cur = cur.next;
            } else {
                if (as == null) {
                    //��һ�β���
                    as = ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
                cur = cur.next;
            }
        }
        //��һ�����ǲ��ǿյģ�����գ����صڶ����֣������Ϊ�գ�����ƴ��
        if (bs == null)
            return as;
        //����ƴ��
        be.next = as;
        //��벿�ֲ�Ϊ�գ��Ѻ�벿�����һ���ڵ��ÿ�
        if (as != null)
            ae.next = null;
        return bs;
    }

    //����Ļ��Ľṹ
    public boolean chkPalindrome() {
        if (head == null) {
            return true;
        }
        //1.�ҵ�������м�ڵ�
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.��ת�м�ڵ���������
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curN = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curN;
        }
        //3.slow�Ӻ���ǰ��head��ǰ����֪������
        while (head != slow) {
            if (head.val != slow.val) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //������������һ�������ж��������Ƿ��л���
    public boolean hasCycle() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //���������(����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣��������޻����򷵻�NULL)
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public void createLoop() {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //curָ����β�ڵ�
        cur.next = head.next;
    }
}
