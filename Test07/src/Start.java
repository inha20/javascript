import school.Person;

public class Start {
    public static void main(String args[]){
            Person p1 = new Person();
            p1.name="최종훈";
            p1.height=160;
            p1.weight=60.2;
            Person p2 = new Person("최종훈");
            Person p3 = new Person("최종훈", 160, 60.2);
    }
}
