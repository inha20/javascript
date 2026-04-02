package reference;

public class Start {
    Student1 s1 = new Student1();
    s1.id="123456";
    s1.name="";
    s1.score1=100;
    s1.score2=99;

    Student2 s2 = new Student2();
    s2.id="123456";
    s2.name="";
    s2.score1=100;
    s2.score2=99;
    s2.subject1="aa";
    s2.subject1="bb";

    Student4 s4 = new Student4();
    s4.id="123456";
    s4.name="";
    //s4.subject1 == null
    s4.subject1 = new Subject();
    s4.subject1.name="C"
    s4.subject1.score=50;
    s4.subject2 = new Subject();
    s4.subject2.name="A"
    s4.subject2.score=70;

    Student5 s5 = new Student("2111", "홍길동");
    //s5.subject1 = new Student2();
    //s5.subject1.setName("name");
    //s5.subject1.setScore(96);
    s5.subject1.setScore("name", 96);
    s5.subject2.setScore("nami", 86);
    s5.showInfo();
}
