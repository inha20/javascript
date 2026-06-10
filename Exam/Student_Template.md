# Student 클래스 + ArrayList 템플릿

> 유형2 핵심 패턴. 복붙 후 필드명만 교체하라.

---

## 1. Student 클래스 기본 구조

```java
public class Student {
    private String id;
    private String name;
    private double score;

    // 생성자
    public Student(String id, String name, double score) {
        this.id    = id;
        this.name  = name;
        this.score = score;
    }

    // getter / setter
    public String getId()            { return id; }
    public void   setId(String id)   { this.id = id; }

    public String getName()              { return name; }
    public void   setName(String name)   { this.name = name; }

    public double getScore()               { return score; }
    public void   setScore(double score)   { this.score = score; }

    // 파일 저장용 레코드 문자열 반환 (파이프 구분)
    public String getRecord() {
        return String.format("%s|%s|%.2f", id, name, score);
    }

    // 출력용
    @Override
    public String toString() {
        return String.format("[%s]%s : %.2f", id, name, score);
    }
}
```

---

## 2. ArrayList\<Student\>

```java
import java.util.ArrayList;

// 선언 및 생성
ArrayList<Student> list = new ArrayList<Student>();
// 또는 (제네릭 추론)
ArrayList<Student> list = new ArrayList<>();

// 추가
list.add(new Student("S001", "홍길동", 95.5));

// 조회
Student s = list.get(0);

// 크기
int size = list.size();

// 순회
for (Student stu : list) {
    System.out.println(stu);
}

// 배열로 변환
Student[] arr = list.toArray(new Student[0]);
```

---

## 3. static 배열 + 입력 패턴

```java
import java.util.Scanner;

static Student[] originStudents;   // static 배열 (클래스 소속)

// main에서 초기화
originStudents = new Student[3];
Scanner scanner = new Scanner(System.in);

for (int i = 0; i < originStudents.length; i++) {
    System.out.print("학번 : ");
    var id = scanner.nextLine().strip();
    if ("".equals(id)) break;

    System.out.print("이름 : ");
    var name = scanner.nextLine().strip();
    if (name.isEmpty()) break;

    System.out.print("성적 : ");
    var scoreStr = scanner.nextLine().strip();

    double score = 0.0;
    try {
        score = Double.parseDouble(scoreStr);
    } catch (NumberFormatException ex) {
        System.out.println("숫자 오류, 0.0으로 처리");
    }

    originStudents[i] = new Student(id, name, score);
}
```

---

## 4. getSum() / getRecord() 패턴

```java
// 점수 합계 계산
public static double getSum(Student[] students) {
    double sum = 0;
    for (Student stu : students) {
        if (stu == null) continue;
        sum += stu.getScore();
    }
    return sum;
}

// ArrayList 버전
public static double getSum(ArrayList<Student> list) {
    double sum = 0;
    for (Student stu : list) {
        sum += stu.getScore();
    }
    return sum;
}

// 레코드 문자열 (Student 내 메소드)
public String getRecord() {
    return String.format("%s|%s|%.2f", id, name, score);
}
```

---

## 5. BufferedWriter — 파일 저장

```java
import java.io.*;

File file = new File("c:\\students", "stu_scores.txt");

try (var bw = new BufferedWriter(
        new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"
        )
)) {
    for (Student stu : originStudents) {
        if (stu == null) continue;
        bw.write(stu.getRecord());   // "학번|이름|점수"
        bw.newLine();
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
```

---

## 6. BufferedReader + split("\\|") — 파일 복구

```java
import java.io.*;
import java.util.ArrayList;

File file = new File("c:\\students", "stu_scores.txt");
ArrayList<Student> list = new ArrayList<>();

try (var br = new BufferedReader(
        new InputStreamReader(
                new FileInputStream(file), "UTF-8"
        )
)) {
    String line;
    while ((line = br.readLine()) != null) {
        if (line.isBlank()) continue;

        String[] tokens = line.split("\\|");   // 파이프 분리 — 이스케이프 필수!
        if (tokens.length < 3) continue;

        var id    = tokens[0].strip();
        var name  = tokens[1].strip();
        var score = Double.parseDouble(tokens[2].strip());

        list.add(new Student(id, name, score));
    }
} catch (IOException ex) {
    ex.printStackTrace();
}

// 결과 출력
for (Student stu : list) {
    System.out.println(stu);
}
```

---

## 핵심 포인트 요약

| 항목 | 주의사항 |
|------|---------|
| `split("\\|")` | 파이프는 정규식 특수문자 → `\\|` 이스케이프 필수 |
| `tokens.length < 3` | 파싱 전 개수 검증 필수 |
| `strip()` | 앞뒤 공백 제거 |
| `if (stu == null) continue` | static 배열 순회 시 null 체크 필수 |
| `new FileOutputStream(file)` | 덮어쓰기 (기본) |
| `new FileOutputStream(file, true)` | 추가(append) 모드 |
| `bw.newLine()` | 줄바꿈 — `bw.write("\n")` 대신 이걸 써라 |
