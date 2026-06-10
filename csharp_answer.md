```java
public class Student {

    public static String[] Subjects;
    public static int[] Limits;

    private String id;
    private String name;
    private String dept;
    private int[] score;

    public Student(String id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;

        score = new int[Subjects.length];
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getSum() {
        int sum = 0;

        for (int s : score) {
            sum += s;
        }

        return sum;
    }

    public String getRecord() {

        StringBuilder sb = new StringBuilder();

        sb.append(id)
                .append("|")
                .append(name)
                .append("|")
                .append(dept);

        for (int s : score) {
            sb.append("|").append(s);
        }

        return sb.toString();
    }

    public boolean setScore(int subjectNo, int value) {

        if (subjectNo < 0 || subjectNo >= score.length)
            return false;

        if (value < 0)
            return false;

        if (value > Limits[subjectNo])
            return false;

        score[subjectNo] = value;

        return true;
    }

    public boolean getScore(int subjectNo, int[] outValue) {

        if (subjectNo < 0 || subjectNo >= score.length)
            return false;

        outValue[0] = score[subjectNo];

        return true;
    }
}
```
```java
public static void writeInfo() throws Exception {

    BufferedWriter bw =
            new BufferedWriter(
                    new FileWriter(path + name));

    for(Student s : students) {
        bw.write(s.getRecord());
        bw.newLine();
    }

    bw.close();
}
```
```java
public static void readInfo() throws Exception {

    File file = new File(path + name);

    if(!file.exists())
        return;

    BufferedReader br =
            new BufferedReader(
                    new FileReader(file));

    String line;

    while((line = br.readLine()) != null) {

        String[] token =
                line.split("\\|");

        Student s =
                new Student(
                        token[0],
                        token[1],
                        token[2]);

        for(int i=0;i<Student.Subjects.length;i++) {
            s.setScore(
                    i,
                    Integer.parseInt(token[i+3]));
        }

        students.add(s);
    }

    br.close();
}
```