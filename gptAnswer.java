import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

class Student {

    private String id;
    private String name;
    private LocalDate regDate;

    public Student(String id, String name, LocalDate regDate) {
        this.id = id;
        this.name = name;
        this.regDate = regDate;
    }

    public String getRecord() {
        return id + "|" + name + "|" + regDate;
    }

    public static Student parse(String line) {

        String[] token = line.split("\\|");

        return new Student(
                token[0],
                token[1],
                LocalDate.parse(token[2])
        );
    }

    @Override
    public String toString() {
        return id + " " + name + " " + regDate;
    }
}

public class Main {

    static ArrayList<Student> students =
            new ArrayList<>();

    static void save() throws Exception {

        BufferedWriter bw =
                new BufferedWriter(
                        new FileWriter("students.dat"));

        for(Student s : students) {

            bw.write(s.getRecord());
            bw.newLine();
        }

        bw.close();
    }

    static void load() throws Exception {

        students.clear();

        File file = new File("students.dat");

        if(!file.exists())
            return;

        BufferedReader br =
                new BufferedReader(
                        new FileReader(file));

        String line;

        while((line = br.readLine()) != null) {

            students.add(
                    Student.parse(line));
        }

        br.close();
    }

    public static void main(String[] args)
            throws Exception {

        students.add(
                new Student(
                        "2026001",
                        "홍길동",
                        LocalDate.now()));

        students.add(
                new Student(
                        "2026002",
                        "김철수",
                        LocalDate.now().plusDays(1)));

        save();

        students.clear();

        load();

        for(Student s : students) {
            System.out.println(s);
        }
    }
}
