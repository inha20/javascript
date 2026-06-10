# UML → Java 변환 레퍼런스

> 30초 안에 찾아라. UML 기호 → 코드 패턴 순서로 정리.

---

## 1. interface

**UML 표시:** `<<interface>> Calc`

```java
interface Calc {
    double PI = 3.141592;          // 자동으로 public static final
    int add(int a, int b);         // 자동으로 public abstract
    int add(int a, int b, int c);
}
```

- 변수 → 자동 `public static final` (상수만 가능)
- 메소드 → 자동 `public abstract`
- 인스턴스화 **불가**, 타입으로는 **가능** (`Calc c = new ElecCalculator()`)
- 다중 implements 가능: `class A implements X, Y`
- default 메소드 충돌 시 반드시 @Override 후 `X.super.order()` 형식으로 해결

```java
// 인터페이스 간 상속은 extends
interface MyInterface extends X, Y {
    void myMethod();
}
```

---

## 2. abstract class

**UML 표시:** 클래스명 이탤릭체 또는 `<<abstract>>`

```java
abstract class Animal {
    // 일반 메소드도 가질 수 있음
    public void move() {
        System.out.println("Animal.move()");
    }
    // 추상 메소드 (UML에서 이탤릭체)
    // 선언만 하고 구현 없음
    // public abstract void sound();
}
```

- 단독 인스턴스화 **불가** (`new Animal()` X)
- 일반 메소드 + 추상 메소드 **모두** 가질 수 있음
- 상속받은 자식이 추상 메소드 @Override 필수

---

## 3. extends (상속)

**UML 표시:** 자식 ──▷ 부모 (속이 빈 실선 삼각형 화살표)

```java
class Tiger extends Animal {
    @Override
    public void move() {
        super.move();   // 부모 메소드 실행
        System.out.println("Tiger.move() too");
    }
}
```

- Java는 **단일 상속**만 가능 (extends 뒤에 클래스 하나만)
- 접근제한자는 오버라이딩 시 **더 넓게만** 가능
  - `private → default → protected → public`
- `@Override` 어노테이션 권장

---

## 4. implements (인터페이스 구현)

**UML 표시:** 클래스 ──▷ 인터페이스 (속이 빈 점선 삼각형 화살표)

```java
// abstract class는 일부만 구현 가능
abstract class Calculator extends Object implements Calc {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
    // add(int, int, int) 는 자식에게 위임
}

// 일반 class는 모든 메소드 @Override 필수
class ElecCalculator extends Calculator {
    @Override
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

---

## 5. 생성자 & super()

**UML 표시:** `+ClassName(params)`  ← 생성자는 반환타입 표시 없음

```java
class Person {
    private String name;
    private int age;

    // 생성자: 반환타입 없음, 클래스명과 동일
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    private String id;

    public Student(String id, String name, int age) {
        super(name, age);   // ← 반드시 첫 줄! 부모 생성자 호출
        this.id = id;
    }
}
```

- `super()` 는 자식 생성자 **첫 번째 줄**에만 위치
- 부모 생성자를 명시하지 않으면 컴파일러가 `super()` 자동 삽입

---

## 6. getter / setter 패턴

```java
// getter: 반환타입 있음, return
public String getName() {
    return name;
}

// setter: void, this.필드 = 매개변수
public void setName(String name) {
    this.name = name;
}
```

---

## 7. UML 기호 빠른 참조표

| UML 기호 | Java 키워드 |
|---------|-----------|
| 속이 빈 실선 삼각형 화살표 | `extends` |
| 속이 빈 점선 삼각형 화살표 | `implements` |
| `+` 앞에 붙음 | `public` |
| `-` 앞에 붙음 | `private` |
| `#` 앞에 붙음 | `protected` |
| `~` 앞에 붙음 | `default` |
| 밑줄 | `static` |
| 이탤릭체 | `abstract` |
| `<<interface>>` | `interface` |
