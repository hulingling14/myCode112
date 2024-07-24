package arraylist;

import java.util.Arrays;

public class MyArrayList implements IList {

    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];
    }

    @Override
    public void add(int data) {
        //������� �ܷ���
        if (isFull()) {
            //����
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        this.elem[usedSize] = data;
        this.usedSize++;
    }

    @Override
    public boolean isFull() {
        return usedSize == elem.length;
    }

    @Override
    public void add(int pos, int data) {
        try {
            checkPosOfAdd(pos);
        } catch (PosNotLegalException e) {
            e.printStackTrace();
        }
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        //�ƶ�Ԫ��
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        //����Ԫ��
        elem[pos] = data;
        usedSize++;
    }

    //�÷������ж����Ԫ��ʱpos�Ƿ�Ϸ�
    private void checkPosOfAdd(int pos) throws PosNotLegalException {
        if (pos < 0 || pos > usedSize) {
            throw new PosNotLegalException("posλ�ò��Ϸ���");
        }
    }

    @Override
    public boolean contains(int toFind) {
        //ֻ��ҪѰ��usedSize��
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        try {
            checkPosOfGetAndSet(pos);
        } catch (PosNotLegalException e) {
            e.printStackTrace();
        }
        return elem[pos];
    }

    private void checkPosOfGetAndSet(int pos) throws PosNotLegalException {
        if (pos < 0 || pos >= usedSize) {
            throw new PosNotLegalException("get����set��ȡԪ�ص�ʱ��posλ�ò��Ϸ���");
        }
    }

    @Override
    public void set(int pos, int value) {
        try {
            checkPosOfGetAndSet(pos);
        } catch (PosNotLegalException e) {
            e.printStackTrace();
        }
        elem[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        //1.Ҫ�����Ƿ����Ҫɾ���Ĺؼ���toRemove
        int pos = indexOf(toRemove);
        if (pos == -1) {
            System.out.println("û��Ҫɾ�������֣�");
            return;
        }
        for (int i = pos; i < usedSize - 1; i++) {
            elem[i] = elem[i + 1];
        }
        usedSize--;
    }


    @Override
    public int size() {
        return usedSize;
    }

    @Override
    public void clear() {
//        for (int i = 0; i < usedSize; i++) {
//            elem[i]=null;
//        }
        usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.println(elem[i] + " ");
        }
        System.out.println();
    }
}
