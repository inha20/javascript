```java
package fileprocess;

public class Student {
    private String id;
    private String name;
    private double score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString(){
        return String.format("[%s]%s : %.2f", id, name, score);
    }

    public Student(String id, String name, double score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
}

```
```java
package fileprocess;

import java.util.Scanner;

public class StudentTest {
    static Student[] originStudents;
    static String path = "c:\\students";
    static String filename = "stu_scores.txt";

    static void main(String[] args) {
        originStudents = new Student[3];

        //학생정보 입력
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < originStudents.length; i++) {
            //학번
            System.out.print("학번 : ");
            var id = scanner.nextLine().strip();
            if("".equals(id)){
                break;
            }
            //이름
            System.out.print("이름 : ");
            var name = scanner.nextLine().strip();
            if(name.isEmpty()){
                break;
            }
            //성적
            System.out.print("성적 : ");
            var scoreTemp = scanner.nextLine().strip();
            if(scoreTemp.isEmpty()){
                break;
            }
            double score = 0.0;
            try{
                score = Double.parseDouble(scoreTemp);
            }catch(NumberFormatException ex){
                System.out.println("형식에 어긋나서 0.0으로 인식");
            }
            var stu = new Student(id,name,score);
            originStudents[i] = stu;
            System.out.println("등록 : " +stu);
        }

        //폴더 확인 및 생성
        //파일 생성1 - 개별
        //파일 생성2 - 통합
        //파일 복구1 - 개별
        //파일 복구2 - 통합
    }
}
```
