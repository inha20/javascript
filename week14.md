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

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
            if ("".equals(id)) {
                break;
            }
            //이름
            System.out.print("이름 : ");
            var name = scanner.nextLine().strip();
            if (name.isEmpty()) {
                break;
            }
            //성적
            System.out.print("성적 : ");
            var scoreTemp = scanner.nextLine().strip();
            if (scoreTemp.isEmpty()) {
                break;
            }
            double score = 0.0;
            try {
                score = Double.parseDouble(scoreTemp);
            } catch (NumberFormatException ex) {
                System.out.println("형식에 어긋나서 0.0으로 인식");
            }
            var stu = new Student(id, name, score);
            originStudents[i] = stu;
            System.out.println("등록 : " + stu);
        }
        //폴더 확인 및 생성
        try {
            //File은 경로와 파일을 모두 다룸
            File dir = new File(path);
            if (dir.exists()) {
                System.out.println("폴더존재" + path);
            } else {
                if (dir.mkdirs()) {
                    System.out.println("폴더생성성공 : " + path);
                } else {
                    System.out.println("폴더생성실패 : " + path);
                }
            }

        } catch (Exception ex) {
            //파일에 쓰면 더 좋음
            System.out.println(ex.getMessage());
            for (var trace : ex.getStackTrace()) {
                System.out.println(trace);
            }
        }
        //파일 생성1 - 개별, 학번별 파일생성
        for (Student stu : originStudents) {
            //배열이 비어있을 수 있음.
            if (stu == null) {
                continue;
            }
            //파일이 이미 있을 수 있음.
            //1.진행하지않는다 2.진행한다
            //filename = stu_학번.txt
            var stufilename = "stu_" + stu.getId() + ".txt";
            File file = new File(path, stufilename);
            boolean yOrn = true; //false==no 가정
            if (file.exists()) {
                do {
                    System.out.print(stu.getId() + "덮어쓸래?(y or n)");
                    var answer = scanner.nextLine().strip();
                    if ("y".equals(answer) || "Y".equals(answer)) {
                        yOrn = true;
                        break;
                    } else if ("n".equalsIgnoreCase(answer)) {
                        yOrn = false;
                    }
                }
                while (true);
                if (!yOrn) {
                    continue;
                }
            }
            //파일쓰기
            //1.덮어쓴다 2.추가한다

            //        //파일에 쓰기 위한 Stream 생성
            //        //생성자 매개변수에 넣을 값은
            //        //전체 경오가 있는 문자열 이나 File 객체 중 하나를 넣는다.
            //        //바이트 스티림 전용
            //        //var f = new FileOutputStream(file, true);
            //        //위에는 추가, 아래는 새로쓰기.
            //        var f = new FileOutputStream(file);
            //        //보조 클래스, 바이트 스트림에 붙어서.
            //        //문자 데이터를 처리하기 위해 도와주느느 클래스
            //        //생성자 매개변수에 넣을 값은 기본 클래스 객체와 문자세트.
            //        //CP949 : 한글윈도우 기본 문자세트.
            //        //UTF-8 : 가장 범용적인 문자세트
            //        var w = new OutputStreamWriter(f, "CP949");
            //        //보조 클래스, 버퍼 환경을 제공
            //        //속도를 보완 + 줄단위 출력이 됨
            //        var b = new BufferedWriter(w);

            //파일 생성
            try (var bw = new BufferedWriter(
                    new OutputStreamWriter(
                    //new FileOutputStream(file, true)//추가모드
                    new FileOutputStream(file)//신규모드
                    , "CP949"
                    )
                )
            ) {
                bw.write(stu.getId());
                bw.newLine();
                bw.write(stu.getName());
                bw.newLine();
                //bw.write(String.valueOf(stu.getScore()));
                bw.write(String.format("%.2f", stu.getScore()));
                bw.newLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //파일 생성2 - 통합
        //파일 존재 여부를 통해 덮어쓸지는 여러분이 확인할 것
        //여기서는 무조건 덮어쓰기 진행할 예정
        var file = new File(path, filename);
        try(var bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), "UTF-8"
                )
        )){
        for(Student stu : originStudents) {
            if (stu == null) {
                continue;
            }
            var record = String.format("%s|%s|%.2f", stu.getId(), stu.getName(), stu.getScore());
            bw.write(record);
            bw.newLine();
            }
        }catch(IOException ex) {

        }
        //파일 복구1 - 개별
        Student[] copyStudent1;
        {
            File dir = new File(path);
            //폴더 안 파일목록 읽어오기
            File[] files = dir.listFiles();
            if(files!=null && files.length!=0) {
                copyStudent1 = new Student[files.length];
                int idx = 0;
                for (File file1 : files) {
                    var stuFileName = file1.getName();
                    if (stuFileName.startsWith("stu_") && stuFileName.endsWith(".txt")) {
                        try (var br =
                                     new BufferedReader(
                                             new InputStreamReader(
                                                     new FileInputStream(file1), "CP949"))) {
                            var id = br.readLine();
                            var name = br.readLine();
                            var scoreTemp = br.readLine();
                            if (id == null || name == null || scoreTemp == null) {
                                continue;
                            }
                            var score = Double.parseDouble(scoreTemp.strip());
                            copyStudent1[idx++] = new Student(id, name, score);
                        } catch (IOException ex) {

                        } catch (Exception ex) {

                        }
                    }
                }
            }
            }
        }
        //파일 복구2 - 통합
        Student[] copyStudent2;
        {
            File file1 = new File(path, filename);
            ArrayList<Student> list = new ArrayList<>();
            try(var br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file1), "UTF-8"))){
                String line;
                while((line=br.readLine())!=null){
                    if(line.isBlank()){
                        continue;
                    }
                    String[] tokens = line.split("\\|");
                    if(tokens.length<3){
                        continue;
                    }
                    var id = tokens[0].strip();
                    var name = tokens[1].strip();
                    var score = Double.parseDouble(tokens[2].strip());
                    list.add(new Student(id, name, score));
                }
            }catch(IOException ex){

            }
            copyStudent2 = list.toArray(new Student[0]);
            for (var stu : copyStudent2) {
                System.out.println(stu);
            }
        }
    }

```
