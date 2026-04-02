package reference;

public class Student5 {
    public String id;
    public String name;
    public Subject2 subject1;
    public Subject2 subject2;

    public Student5(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public setSubject1(String name, int score) {
        this.subject1 = new Subject1();
        this.subject1.setName(name);
        this.subject1.setScore(score);
    public setSubject2(String name, int score) {
        this.subject2 = new Subject2();
        this.subject2.setName(name);
        this.subject2.setScore(score);
    }
    void showInfo() {
        System.out.println(name);
        System.out.println(id);
        subject1.showInfo();
        subject2.showInfo();
    }
}
