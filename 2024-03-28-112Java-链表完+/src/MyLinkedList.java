public class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode prev;//ǰ��
        public ListNode next;//���

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;//��־ͷ�ڵ�
    public ListNode last;//��־Ϊ�ڵ�

    //ͷ�巨
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            //�ǲ��ǵ�һ�β���ڵ�
            head = last = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    //β�巨
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            //�ǲ��ǵ�һ�β���
            head = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = last.next;
        }
    }

    //����λ�ò���,��һ�����ݽڵ�Ϊ0���±�
    public void addIndex(int index, int data) {
        try {
            checkIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        //1.�ҵ�indexλ��
        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        //2.��ʼ�󶨽ڵ�
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    private ListNode findIndex(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexNotLegalException("˫���������indexλ�ò��Ϸ���" + index);
        }
    }

    //�����Ƿ�����ؼ���key�Ƿ��ڵ�������
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //ɾ����һ�γ��ֹؼ���Ϊkey�Ľڵ�
    public void remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                //��ʼɾ�� ����ͷ�ڵ�
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        //head == null ֤��ֻ��һ���ڵ�
                        last = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next == null) {
                        //����β�ͽڵ�
                        last = last.prev;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
                return;//ɾ��һ������
            } else {
                cur = cur.next;
            }
        }
    }

    //ɾ������ֵΪkey�Ľڵ�
    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                //��ʼɾ�� ����ͷ�ڵ�
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        //head == null ֤��ֻ��һ���ڵ�
                        last = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next == null) {
                        //����β�ͽڵ�
                        last = last.prev;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //�õ�˫������ĳ���
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            ListNode curN = cur.next;
            //cur.val=null;
            cur.prev = null;
            cur.next = null;
            cur = curN;
        }
        head = last = null;
    }
}
