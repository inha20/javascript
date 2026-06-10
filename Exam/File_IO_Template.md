# File I/O 템플릿

> 파일 저장 / 파일 복구 패턴. 복붙 후 클래스명·경로만 바꿔라.

---

## 핵심 클래스 3단 스택 구조

```
FileOutputStream / FileInputStream   ← 바이트 스트림 (파일 실제 연결)
    └── OutputStreamWriter / InputStreamReader  ← 문자 인코딩 처리
            └── BufferedWriter / BufferedReader  ← 버퍼 + 줄단위 처리
```

---

## 1. BufferedWriter — 파일 쓰기 (저장)

```java
import java.io.*;

// try-with-resources: 블록 끝나면 자동 close()
try (var bw = new BufferedWriter(
        new OutputStreamWriter(
                new FileOutputStream(file),   // file: File 객체
                "UTF-8"                        // 인코딩 (한글 CP949도 가능)
        )
)) {
    bw.write("저장할 텍스트");
    bw.newLine();           // 줄바꿈 (\n)
    bw.write("두 번째 줄");
    bw.newLine();
} catch (IOException ex) {
    ex.printStackTrace();
}
```

### 파이프 구분자 포맷으로 저장 (통합 파일)

```java
// "학번|이름|점수" 형식으로 한 줄씩 저장
String record = String.format("%s|%s|%.2f", id, name, score);
bw.write(record);
bw.newLine();
```

### 추가 모드 (기존 내용 유지)

```java
new FileOutputStream(file, true)   // true = 추가(append) 모드
new FileOutputStream(file)         // 기본 = 덮어쓰기 모드
```

---

## 2. BufferedReader — 파일 읽기 (복구)

```java
import java.io.*;
import java.util.ArrayList;

File file = new File("c:\\students", "stu_scores.txt");
ArrayList<Student> list = new ArrayList<>();

try (var br = new BufferedReader(
        new InputStreamReader(
                new FileInputStream(file),
                "UTF-8"
        )
)) {
    String line;
    while ((line = br.readLine()) != null) {   // null = 파일 끝
        if (line.isBlank()) continue;          // 빈 줄 건너뜀

        String[] tokens = line.split("\\|");   // 파이프 분리 (이스케이프 필수!)
        if (tokens.length < 3) continue;       // 데이터 부족 검증

        var id    = tokens[0].strip();
        var name  = tokens[1].strip();
        var score = Double.parseDouble(tokens[2].strip());

        list.add(new Student(id, name, score));
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
```

---

## 3. split() — 구분자 파싱

```java
// 파이프(|) 구분 → 이스케이프 2번 필요
String[] tokens = line.split("\\|");

// 쉼표 구분
String[] tokens = line.split(",");

// 공백 구분
String[] tokens = line.split(" ");

// 파싱 후 항상 검증
if (tokens.length < 필요한개수) continue;
var value = tokens[0].strip();   // 앞뒤 공백 제거
```

---

## 4. File 객체 — 폴더/파일 확인 및 생성

```java
File dir = new File("c:\\students");

// 폴더 존재 확인 및 생성
if (!dir.exists()) {
    dir.mkdirs();   // 중간 경로도 함께 생성
}

// 파일 객체 생성 (경로 + 파일명)
File file = new File("c:\\students", "stu_scores.txt");

// 파일 존재 여부
if (file.exists()) { ... }

// 폴더 내 파일 목록
File[] files = dir.listFiles();
```

---

## 5. 개별 파일 복구 패턴 (줄 단위 read)

```java
// 한 줄씩 읽어서 필드로 복원
try (var br = new BufferedReader(
        new InputStreamReader(new FileInputStream(file1), "CP949"))) {
    var id       = br.readLine();
    var name     = br.readLine();
    var scoreStr = br.readLine();
    if (id == null || name == null || scoreStr == null) continue; // null 체크 필수
    var score = Double.parseDouble(scoreStr.strip());
    students[idx++] = new Student(id, name, score);
} catch (IOException ex) { }
```
