package school;

public class start {
    public static void main(String[] args) {
    int a=1;//자료형 변수명 = 값;
    Student stu1 = new Student();//자료형 변수명 = 값;
    stu1.id="202444011";
    //stu1.name="최종훈"; private는 다른 클래스에서 X
    stu1.setName("최종훈")//setter호출
    stu1.address="인천시 남동구"
    stu1.grade = 2;
    System.out.println(stu1);
    System.out.println(stu1.id);
    //System.out.println(stu1.name);
    System.out.println(stu1.getName());//getter호출

}
}