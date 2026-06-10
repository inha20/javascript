# LocalDate 템플릿

> 날짜 관련 문제 30초 참조용. import 잊지 말 것.

---

## import

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
```

---

## 1. LocalDate.now() — 오늘 날짜

```java
LocalDate today = LocalDate.now();
System.out.println(today);   // 2026-06-10
```

---

## 2. LocalDate.of() — 특정 날짜 생성

```java
LocalDate examDate = LocalDate.of(2026, 6, 11);
System.out.println(examDate);   // 2026-06-11
```

---

## 3. LocalDate.parse() — 문자열 → 날짜

```java
// 기본 형식: yyyy-MM-dd
LocalDate birthday = LocalDate.parse("2000-01-01");

// 커스텀 형식
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
LocalDate date = LocalDate.parse("2026/06/11", formatter);
```

---

## 4. plusDays() / minusDays() — 날짜 계산

```java
LocalDate today = LocalDate.now();

LocalDate nextWeek  = today.plusDays(7);
LocalDate yesterday = today.minusDays(1);
LocalDate nextMonth = today.plusMonths(1);
LocalDate nextYear  = today.plusYears(1);
```

---

## 5. isBefore() / isAfter() — 날짜 비교

```java
LocalDate today    = LocalDate.now();
LocalDate examDate = LocalDate.of(2026, 6, 11);

if (today.isBefore(examDate)) {
    System.out.println("시험 전입니다.");
} else if (today.isAfter(examDate)) {
    System.out.println("시험이 지났습니다.");
} else {
    System.out.println("오늘이 시험일입니다.");
}
```

---

## 6. DateTimeFormatter — 날짜 → 원하는 형식 문자열

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
String formatted = today.format(formatter);
System.out.println(formatted);   // 2026년 06월 10일

// 자주 쓰는 패턴
// "yyyy-MM-dd"     → 2026-06-10
// "yyyy/MM/dd"     → 2026/06/10
// "yyyyMMdd"       → 20260610
// "yyyy년 MM월 dd일" → 2026년 06월 10일
```

---

## 7. LocalDateTime — 날짜 + 시간

```java
import java.time.LocalDateTime;

LocalDateTime now = LocalDateTime.now();
System.out.println(now);                      // 2026-06-10T14:30:00
System.out.println(now.plusHours(1));         // 1시간 후
System.out.println(now.minusMinutes(30));     // 30분 전
```

---

## 8. 전체 패턴 요약

| 메소드 | 설명 | 예시 |
|--------|------|------|
| `LocalDate.now()` | 오늘 날짜 | `2026-06-10` |
| `LocalDate.of(y,m,d)` | 특정 날짜 | `LocalDate.of(2026,6,11)` |
| `LocalDate.parse(str)` | 문자열 파싱 | `parse("2026-06-11")` |
| `.plusDays(n)` | n일 후 | `today.plusDays(7)` |
| `.minusDays(n)` | n일 전 | `today.minusDays(1)` |
| `.isBefore(date)` | 이전이면 true | `today.isBefore(exam)` |
| `.isAfter(date)` | 이후이면 true | `today.isAfter(exam)` |
| `.format(formatter)` | 형식 변환 | `today.format(fmt)` |
