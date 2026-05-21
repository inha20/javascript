```java
package Interface;

interface Calc{
    double PI = 3.141592;
    int add(int num1, int num2);
    int add(int num1, int num2, int num3);
}

abstract class Calculator extends Object implements Calc{
    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }
}

class ElecCalculator extends Calculator {
    @Override
    public int add(int num1, int num2, int num3) {
        return num1+num2+num3;
    }
    public int sub(int num1, int num2 ){return num1-num2;}
}

public class CalculatorTest {
    static void main() {
        ElecCalculator c = new ElecCalculator();
        System.out.println(Calc.PI);
        System.out.println(c.PI);
        System.out.println(Calculator.PI);
        System.out.println(ElecCalculator.PI);

        System.out.println(c.add(1,2));
        System.out.println(c.add(1,2,3));
        System.out.println(c.sub(1,2));

        //인스턴스변수 instanceof 추상클래스
        if (c instanceof Calculator) {
            var cc = (Calculator) c;
            System.out.println(cc.add(1,2));
            System.out.println(cc.add(1,2,3));
            //System.out.println(cc.sub(1,2));
        }

        //인스턴스변수 instanceof 인터페이스
        if (c instanceof Calc) {
            var cc = (Calc) c;
            System.out.println(cc.add(1,2));
            System.out.println(cc.add(1,2,3));
            //System.out.println(cc.sub(1,2));
        }
        //->인터페이스는 인스턴스화는 불가능하지만 타입으로서는 동작한다. 추상클래스와 동일.
    }
}

```
```java
package Interface;
import java.io.IOException;
import java.util.Scanner;

interface Scheduler{
    void getNextCall();//상담내역 가져오기
    void sendCallToAgent();//상담원 배분
}

class RoundRobin implements Scheduler{
    @Override
    public void getNextCall() {
        System.out.println("순서대로 가져옴.");
    }
    @Override
    public void sendCallToAgent() {
        System.out.println("다음 순서에 배당.");
    }
}

class LeastJob implements Scheduler{
    @Override
    public void getNextCall() {
        System.out.println("순서대로 가져옴");
    }
    @Override
    public void sendCallToAgent() {
        System.out.println("대기 인원 적은 상담원에게 배부");
    }
}

class PriorityAllocation implements Scheduler{
    @Override
    public void sendCallToAgent() {
        System.out.println("등급 높은 고객 먼저");
    }
    @Override
    public void getNextCall() {
        System.out.println("능력 좋은 상담원에게 배분");
    }
}

public class SchedulerTest {
    //System.io.exception은 IOException 발생할 수 있음.
    //read()는 그것을 자신이 호출한 곳으로 전달 throw.
    //호출한 측은 그 Exception을 처리하거나
    //그렇지 않으면 호출한 곳에 다시 전달.
    //main()은 jvm이 호출하는데, 던져진걸 jvm이 받으면 프로그램이 죽어.
    static void main() throws IOException{
        //키보드로 문자 하나를 입력받는 메소드
        //문자를 ascii(unicode) 값에 해당하는
        //정수값을 반환.
        int ch = System.in.read();
        Scheduler scheduler = null;
        if(ch=='R'||ch=='r'){
            scheduler = new RoundRobin();
        }
        else if (ch=='L'||ch=='l'){
            scheduler = new LeastJob();
        }else if (ch=='P'||ch=='p'){
            scheduler = new PriorityAllocation();
        }else{
            System.out.println("미지원기능");
            return;
        }

        scheduler.getNextCall();
        scheduler.sendCallToAgent();
    }
}
```
```java
package interfaceex2;

interface IBuy{
    void buy();
    default void order(){
        System.out.println("구매주문");
    }
}
interface ICell{
    void cell();
    default void order(){
        System.out.println("판매주문");
    }
}

class Customer implements IBuy, ICell{
    @Override
    public void buy() {
        System.out.println("구매하기");
    }
    @Override
    public void cell() {
        System.out.println("판매하기");
    }
    @Override
    public void order() {
        IBuy.super.order();
        ICell.super.order();
    }
}

public class CustomerTest {
}

```
```java
package interfaceex2;

interface X {
    void x();
}

interface Y {
    void y();
}

//인터페이스간 상속은 extends로 나열
interface MyInterface extends X, Y{
    void myMethod();
}

class MyClass implements MyInterface{
    @Override
    public void y() {

    }

    @Override
    public void x() {

    }

    @Override
    public void myMethod() {

    }
}

public class MyClassTest {
}

```
