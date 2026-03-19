<img width="930" height="370" alt="스크린샷 2026-03-12 132021" src="https://github.com/user-attachments/assets/2b7c3b0a-2410-428a-9e69-6ca1f5a9eb14" />

# Hello, java!

> 설치개론

<details><summary>
프로그램과 컴파일
</summary>
➜ 프로그램 ; // 컴퓨터에 지시하는 명령 집합.<br>
➜ 컴파일 ; // 문법 검사, OS가 읽는 언어로 번역.<br>
➜ 컴파일러 ; // 컴파일하는 프로그램.<br>
</details>
<details><summary>
자바 설치 용어
</summary>
➜ jdk ; // Java Development Kit<br>
➜ jvm ; // Java Vertual Machine<br>
➜ JIT 컴파일러 ; // 코드 전체를 한 번에 컴파일하는 프로그램.<br>
➜ IDE ; Integrated Development Environment<br>
</details>
<details><summary>
한 번 작성하면 어디서든 돌아간다
</summary>
➜ 자바 슬로건<br>
➜ 하나의 코드는 하나의 컴파일을 만들고, 이후 컴파일러와 OS만 서로 맞춰주면 OS 플랫폼에 비종속적임.<br>
</details>
<details><summary>
객체지향 프로그래밍 개론
</summary>
➜ C언어처럼 절차지향이 아니라 여러 클래스가 협력하는 프로그램 구현방법.<br>
➜ 포인터 사용을 못하고, 대신 Garvage Collector가 작동하는 언어.<br>
</details>
<details><summary>
사담
</summary>
➜ 자바 - spring boot 보다는 데이터, ai 쪽으로 정부 지원이 집중되고 있음.<br>
➜ 또한 일거리 역시 줄어든 편.<br>
➜ 안드로이드 앱, 게임은 코틀린으로 많이 코딩하는 편.<br>
➜ shift + f10으로 실행. 단축키는 IDE 등에 따라 다를 수 있음.<br>
➜ 주석은 //, /*.<br>
</details>

> 변수와 자료형

<details><summary>
컴퓨터과학
</summary>
➜ 정수는 2의 보수로, 실수는 IEEE754로. <br>
➜ 변수란 숫자가 변하는 가변공간. 변수명을 통해 접근함.<br>
</details>
<details><summary>
크기와 해석방법을 결정하는 자료형
</summary>
➜ primary 원시형과 reference 참조형으로 나뉨.
        
```java

        char grade_1=49;
        short grade_2=49;
        System.out.println(grade_1); //'1'  //2byte
        System.out.println(grade_2); //49   //2byte

```

&nbsp;&nbsp;&nbsp;&nbsp;⤷ 둘다 2바이트지만 char은 문자형. 아스키코드.<br>
</details>
<details><summary>
숫자표기형식
</summary>

        
```java

        int binVal = 0b1111; //15
        int octVal = 017; //15
        int decVal = 15; //15
        int hexVal = 0xF; //15

```
</details>
<details><summary>
자료형
</summary>
➜ byte - short - int - long은 2배씩 커지는 정수형 <br>
➜ 문자형 char은 2바이트 <br>
➜ 실수형 float, double은 4, 8 바이트 <br>
➜ 논리형 boolean은 1바이트 <br>
</details>

<details><summary>
지역 변수 자료형 추론
</summary>

        
```java

        var age=21;
        var height=165.5f;
        System.out.println(age);
        System.out.println(height); //마우스 올리기 실습

```
</details>
<details><summary>
메모리에서 값이 변경되지 않도록 컴파일러가 잡아주는 final
</summary>

        
```java

        //final, 변수를 상수처럼 만듦.
        final int MAX_NUM = 100;
        final int MIN_NUM;
        //MAX_NUM = 10; //마우스 올리기 실습
        //MIN_NUM =0;   //비추천
        //System.out.println(MIN_NUM);

```
&nbsp;&nbsp;&nbsp;&nbsp;⤷ #define은 리터럴 단계에서 코드의 텍스트를 바꿈.<br>
</details>
<details><summary>
형변환
</summary>

        
```java

        int a = 32;
        //int b = 1000000000000000000; //더 조그만 상자에 넣는 격
        long b = 1_000_000_000_000_000_000L;
        //float c = 32.6; //더 조그만 상자에 넣는 격
        float c = 32.6f;
        double d= 32.6;

        b=a; //더 큰 상자에 넣는 격
        a=(int)b;
        c=a; //실수 범위가 더 커
        b=(int)c; //크기가 같지만 막아 //실수는 정수로 바꾼 후 넣기
        
        double e=a+c;
        //double e=(double)((float)a+c);
        //b=a+c;
        b=(long)(a+c);
        b=a+(int)c;

```
</details>
<details><summary>
연산자와 피연산자
</summary>
➜ 대입연산자는 복사다. 이동이 아니다. <br>
➜ boolean A; System.out.print(!A) 는 false이다. <br>
➜ boolean의 연산값은 boolean만 가능. 자바의 특징. <br>
➜ 비트연산에서 부호비트 고려해야. <br>
</details>



> 제어

<details><summary>
Scanner
</summary>
➜ import java.util.Scanner; //java.util 패키지의 Scanner 클래스를 사용하겠다.<br>
➜ Scanner sc = new Scanner(System.in);<br>
➜ sc.close();<br>
</details>
<details><summary>
yield
</summary>
        
```java

        medal = switch (rank) {
            case 1 -> "금";
            case 2 -> "은";
            case 3 -> "동";
            default -> {
                System.out.println("순위 외");
                yield "참가상"; //반환.T.
            }
        };
        System.out.println(medal);

```

</details>
