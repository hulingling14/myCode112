public class Test {
    //�ཻ�����������������ҵ����ǵĵ�һ�������ڵ㣩
    public static MySingleLinkedList.ListNode getIntersectionNode(MySingleLinkedList.ListNode headA, MySingleLinkedList.ListNode headB) {
        //1.����A����
        MySingleLinkedList.ListNode pl = headA;
        MySingleLinkedList.ListNode ps = headB;
        int lenA = 0;
        int lenB = 0;
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        //2���ж�len���������Ǹ���
        if (len < 0) {
            pl = headA;
            ps = headB;
            len = lenB - lenA;
        }
        //������������֮��plһ��ֻ���������,psһ��ָ�������̵�����
        //lenһ��������
        //3.�ó�����pl�߲�ֵlen��
        while (len != 0) {
            pl = pl.next;
            len--;
        }
        //4.һ����ֱ������
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        if (pl == null) {
            //����������ö�Ϊ�� ֤�����ཻ
            return null;
        }
        return pl;
    }

    public static void createCut(MySingleLinkedList.ListNode headA, MySingleLinkedList.ListNode headB) {
        headA.next.next = headB.next.next;
    }

    public static void main(String[] args) {
        MySingleLinkedList msl2 = new MySingleLinkedList();
        msl2.addLast(3);
        msl2.addLast(13);
        msl2.addLast(25);
        msl2.addLast(10);
        msl2.addLast(100);

        msl2.createLoop();
        MySingleLinkedList.ListNode ret = msl2.detectCycle(msl2.head);
        System.out.println(ret.val);
    }

    public static void main4(String[] args) {
        MySingleLinkedList msl1 = new MySingleLinkedList();
        msl1.addLast(1);
        msl1.addLast(3);
        msl1.addLast(5);

        MySingleLinkedList msl2 = new MySingleLinkedList();
        msl2.addLast(3);
        msl2.addLast(13);
        msl2.addLast(25);
        msl2.addLast(10);
        msl2.addLast(100);

        createCut(msl1.head, msl2.head);

        MySingleLinkedList.ListNode ret = getIntersectionNode(msl1.head, msl2.head);
        System.out.println(ret.val);
    }

    //�ϲ���������������������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ���
    public static MySingleLinkedList.ListNode mergeTwoLists(MySingleLinkedList.ListNode headA, MySingleLinkedList.ListNode headB) {
        MySingleLinkedList.ListNode newH = new MySingleLinkedList.ListNode(-1);
        MySingleLinkedList.ListNode tmp = newH;
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA == null) {
            tmp.next = headB;
        }
        if (headB == null) {
            tmp.next = headA;
        }
        return newH.next;
    }

    public static void main3(String[] args) {
        MySingleLinkedList msl1 = new MySingleLinkedList();
        msl1.addLast(11);
        msl1.addLast(13);
        msl1.addLast(5);
        msl1.addLast(10);
        msl1.addLast(100);

        MySingleLinkedList.ListNode retHead = msl1.partition(12);
        msl1.display(retHead);
    }

    public static void main2(String[] args) {
        MySingleLinkedList msl1 = new MySingleLinkedList();
        msl1.addLast(1);
        msl1.addLast(3);
        msl1.addLast(5);
        msl1.addLast(10);
        msl1.addLast(100);

        MySingleLinkedList msl2 = new MySingleLinkedList();
        msl2.addLast(3);
        msl2.addLast(13);
        msl2.addLast(25);

        MySingleLinkedList.ListNode newHead = mergeTwoLists(msl1.head, msl2.head);
        msl1.display(newHead);
    }

    public static void main1(String[] args) {
        MySingleLinkedList msl = new MySingleLinkedList();
        //msl.createList();
        msl.addLast(1);
        msl.addLast(2);
        msl.addLast(3);
        msl.addLast(4);
        msl.addLast(5);
        msl.display();
        int ret = msl.kthToLast(6);
        System.out.println(ret);
    }
}
