package arraylist;

public interface IList {
    // ����Ԫ��,Ĭ���������������
    void add(int data);

    // �� pos λ������Ԫ��
    void add(int pos, int data);

    // �ж��Ƿ����ĳ��Ԫ��
    boolean contains(int toFind);

    // ����ĳ��Ԫ�ض�Ӧ��λ��
    int indexOf(int toFind);

    // ��ȡ pos λ�õ�Ԫ��
    int get(int pos);

    // �� pos λ�õ�Ԫ����Ϊ value
    void set(int pos, int value);

    //ɾ����һ�γ��ֵĹؼ���key
    void remove(int toRemove);

    // ��ȡ˳�����
    int size();

    // ���˳���
    void clear();

    // ��ӡ˳���ע�⣺�÷���������˳����еķ�����Ϊ�˷��㿴���Խ��������
    void display();

    boolean isFull();
}
