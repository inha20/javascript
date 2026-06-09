```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExample {
    public static void main(String[] args) {

        // 현재 날짜
        LocalDate today = LocalDate.now();
        System.out.println("오늘 날짜: " + today);

        // 특정 날짜 생성
        LocalDate examDate = LocalDate.of(2026, 6, 11);
        System.out.println("시험 날짜: " + examDate);

        // 날짜 계산
        LocalDate nextWeek = today.plusDays(7);
        LocalDate yesterday = today.minusDays(1);

        System.out.println("7일 후: " + nextWeek);
        System.out.println("어제: " + yesterday);

        // 날짜 비교
        if (today.isBefore(examDate)) {
            System.out.println("시험 전입니다.");
        } else if (today.isAfter(examDate)) {
            System.out.println("시험이 지났습니다.");
        } else {
            System.out.println("오늘이 시험일입니다.");
        }

        // 문자열 -> 날짜
        LocalDate birthday = LocalDate.parse("2000-01-01");
        System.out.println("생일: " + birthday);

        // 날짜 -> 원하는 형식 문자열
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        String formatted = today.format(formatter);
        System.out.println("형식 변경: " + formatted);
    }
}
```
```java
import java.time.LocalDateTime;

public class TimeExample {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        System.out.println("현재 날짜와 시간: " + now);

        System.out.println("1시간 후: " + now.plusHours(1));

        System.out.println("30분 전: " + now.minusMinutes(30));
    }
}
```
