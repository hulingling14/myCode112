public class MySingleLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;//代表链表的头节点

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

    //从指定位置newHead开始打印链表
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //头插法
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    //尾插法
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

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int val) {
        //1.判断index的合法性
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
        //3.找到index的前一个位置
        ListNode cur = findIndexSubOne(index);
        //4.进行连接
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
            throw new IndexNotLegalException("index不合法");
        }
    }

    //查找是否包含关键字key是否在单链表当中
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

    //删除第一次出现关键字为key的节点
    public void remove(int val) {
        if (head.val == val) {
            head = head.next;
            return;
        }
        //找到当前需要删除值的节点的前一个
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

    //删除所有值为key的节点
    public void removeAllKey(int val) {
        //1.判空
        if (head == null) {
            return;
        }
        //2.定义prev和cur
        ListNode prev = head;
        ListNode cur = head.next;
        //3.开始判断并且删除
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        //4.处理头节点
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

    //反转一个单链表
    public ListNode reverseList() {
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curN = cur.next;
            //开始反转
            cur.next = head;
            head = cur;
            cur = curN;
        }
        return head;
    }

    //链表的中间节点（给定一个带有头节点head的非空单链表，返回链表的中间节点。如果有两个中间节点，则返回第二个中间节点。）
    public ListNode middleNode() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //返回倒数第K个节点
    public int kthToLast(int k) {
        if (k <= 0) {
            //k不合法
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        //1.先让fast走k-1步
        int count = 0;
        while (count != k - 1) {
            fast = fast.next;
            if (fast == null)
                return -1;
            count++;
        }
        //2.然后一起走，当fast走到最后一个节点的时候，slow的位置就是倒数第k个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    //链表分割（编写代码，以给定值x为基准将链表分割成两部分，所有小于x的节点排在大于或等于x的节点之前。）
    public ListNode partition(int x) {
        if (head == null) return null;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                //第一次插入
                if (bs == null) {
                    bs = be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
                cur = cur.next;
            } else {
                if (as == null) {
                    //第一次插入
                    as = ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
                cur = cur.next;
            }
        }
        //第一部分是不是空的，如果空，返回第二部分，如果不为空，进行拼接
        if (bs == null)
            return as;
        //进行拼接
        be.next = as;
        //后半部分不为空，把后半部分最后一个节点置空
        if (as != null)
            ae.next = null;
        return bs;
    }

    //链表的回文结构
    public boolean chkPalindrome() {
        if (head == null) {
            return true;
        }
        //1.找到链表的中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.翻转中间节点后面的链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curN = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curN;
        }
        //3.slow从后往前，head从前往后，知道相遇
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

    //环形链表（给定一个链表，判断链表中是否有环）
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

    //环形链表Ⅱ(给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回NULL)
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
        //cur指向了尾节点
        cur.next = head.next;
    }
}
