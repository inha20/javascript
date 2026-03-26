public class MethodTest {
    static int add(int a, int b) {
        int result=a+b;
        return result;
}
    public static void main(String[] args) {
    //main의 호출은 jvm에서..
        int a=2, b=3;
        int r=add(a,b)
        System.out println(a);
}