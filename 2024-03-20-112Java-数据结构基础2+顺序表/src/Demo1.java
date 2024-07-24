public class Demo1 {
    public static void main(String[] args) {
        Integer a=100;
        Integer b=100;
        System.out.println(a==b);//true

        Integer c=100;
        Integer d=100;
        System.out.println(c==d);//false
    }
}
//【-128，127】
//如果i是在某个范围之内，那么就是去数组取值；相反，不在这个范围内，就会实例化一个新的对象
