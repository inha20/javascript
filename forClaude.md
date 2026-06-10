클로드에게는 "시험용 저장소 최적화"를 목표로 아주 구체적으로 지시하는 게 좋아.

아래 내용을 그대로 주면 된다.

작업 목표

내일 Java 객체지향프로그래밍 오픈북 시험을 본다.

이 저장소를 학습용 저장소가 아니라 시험장에서 즉시 참조 가능한 오픈북 저장소로 재구성하라.

코드를 추가하는 것보다 검색 속도와 참조 속도 최적화가 우선이다.

시험 정보

출제 경향 분석 결과:

UML → Java 코드 변환
interface
abstract class
extends
implements
생성자
super()
static
ArrayList
파일 저장
파일 복구
LocalDate

중심으로 출제됨.

알고리즘 문제는 거의 없음.

기출문제 유형
유형1

UML 제시

↓

Java 코드 작성

평가 요소:

interface
abstract class
extends
implements
생성자
getter/setter
유형2

Student 클래스 작성

평가 요소:

static 배열
생성자
ArrayList<Student>
getSum()
getRecord()
파일 저장
파일 복구
split()
유형3

회원 관리

평가 요소:

LocalDate
plusDays()
parse()
format()
파일 저장
저장소 분석 결과

최중요 파일

week03.md
week10.java
week11.md
week14.md
week15.md

이 다섯 파일이 시험 범위 핵심이다.

수행 작업
1

README 최상단에

"시험 직전 10분 체크리스트"

추가

예:

1. UML
2. interface
3. abstract
4. extends
5. implements
6. super()
7. static
8. ArrayList
9. BufferedWriter
10. BufferedReader
11. split()
12. LocalDate
2

Exam 폴더 생성

예:

Exam/
3

Exam 폴더 안에

UML_To_Java.md
File_IO_Template.md
LocalDate_Template.md
Student_Template.md

생성

4

Student_Template.md

에 아래 내용을 포함

ArrayList<Student>

BufferedWriter

BufferedReader

split("\\|")

getRecord()

getSum()
5

LocalDate_Template.md

에 아래 내용을 포함

LocalDate.now()

LocalDate.of()

LocalDate.parse()

plusDays()

isBefore()

isAfter()

DateTimeFormatter
6

UML_To_Java.md

에

interface

abstract class

extends

implements

super()

예제 정리

최종 목표

시험장에서

"아 이거 어디 있었지?"

가 아니라

30초 이내에

UML
파일처리
LocalDate

예제를 찾을 수 있는 구조로 저장소를 재배치하라.

불필요한 설명은 줄이고 시험 참조 효율을 최우선으로 하라.

이 정도면 클로드가 단순 정리가 아니라 시험 전용 레퍼런스 저장소 방향으로 작업할 거야. 지금까지 분석한 기출과 네 저장소 내용을 거의 다 반영한 지시문이기도 하고.
