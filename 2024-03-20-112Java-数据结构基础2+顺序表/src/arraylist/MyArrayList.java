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
        //如果满了 能放吗？
        if (isFull()) {
            //扩容
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
        //移动元素
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        //插入元素
        elem[pos] = data;
        usedSize++;
    }

    //该方法来判断添加元素时pos是否合法
    private void checkPosOfAdd(int pos) throws PosNotLegalException {
        if (pos < 0 || pos > usedSize) {
            throw new PosNotLegalException("pos位置不合法！");
        }
    }

    @Override
    public boolean contains(int toFind) {
        //只需要寻找usedSize次
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
            throw new PosNotLegalException("get或者set获取元素的时候pos位置不合法！");
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
        //1.要查找是否存在要删除的关键字toRemove
        int pos = indexOf(toRemove);
        if (pos == -1) {
            System.out.println("没有要删除的数字！");
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
