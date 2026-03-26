package school;

public class Student {
    String id;
    private String name;
    public grade int;
    public String address;

    public void showinfo() {
        System.out.println("name:" + name);
    }
    //getter 변수값을 반환.
    public String getName() {
        return name;
    }
    //setter 변수값을 변경. 필터링.
    public void setName(String name) {
        this.name=name;
    }

    public static void main(String[] args) {
        int a=1;//자료형 변수명 = 값;
        Student stu1 = new Student();//자료형 변수명 = 값;
        stu1.id="202444011";
        stu1.name="최종훈";
        stu1.address="인천시 남동구"
        stu1.grade = 2;
        System.out.println(stu1);
        System.out.println(stu1.id);
}
}