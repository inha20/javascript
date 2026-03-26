import school.Student;
import school.Person;

    public class start {
        public static void main(String[] args) {
            int a = 1;//자료형 변수명 = 값;
            Student stu1 = new Student();//자료형 변수명 = 값;
            //stu1.id = "202444011"; default는 다른 패키지 접근 X
            //setId() 미생성으로 값 지정 X
            //stu1.name="최종훈"; private는 다른 클래스에서 X
            stu1.setName("최종훈")//setter호출
            stu1.address = "인천시 남동구"
            stu1.grade = 2;
            System.out.println(stu1);
            //System.out.println(stu1.id); default는 다른 패키지 접근 X
            //getId() 없어서 X
            //System.out.println(stu1.name);
            System.out.println(stu1.getName());//getter호출

            //Person p1 = new Person();
            //p1.name="최종훈";
            //p1.married=true;
            Person p1 = new Person("최종훈",true)
            System.out.println(p1.weight);
            Person p2 = new person();
        }
    }
