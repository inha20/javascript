package abstractex;
/* 다른 파일의 주석
//인스턴스 변수는 선언과 동시에 초기화 가능. 동일한 내용을 생성자에서 다시 실행할 필요 없음.
//생성자 앞에 접근제한자 생성 가능. 내부적 생성자 호출 시에.
*/

import java.util.ArrayList;

//public 클래스는 파일 당 한 개만 허용.
abstract class Animal{
    public void move() {
        System.out.println("Animal.move()");
    }
}

class Human extends Animal{
    //접근제한자는 오버라이딩하며 더 넓은 범위를 사용하여야 한다.
    //private - default - protected - public.
    @Override
    public void move() {
        System.out.println("Human.move()");
    }

    public void readBook() {
        System.out.println("Human.readBook()");
    }
}

//Object(최상위 클래스) <- Animal <- Tiger
//extends 상속을 위한 키워드, 오직 1개의 클래스만 상속 가능. 자바는 단일상속.(==확장)
class Tiger extends Animal{
    //어노테이션. 컴파일러에게 알려주는 주석. 삽입 권고.
    @Override
    public void move() {
        super.move();//상위 클래스 animal의 move() 실행
        System.out.println("Tiger.move() too");
    }

    public void Hunting() {
        System.out.println("Tiger.Hunting()");
    }

}

class Eagle extends Animal {
    @Override
    public void move() {
        System.out.println("Eagle.move()");
    }

    public void Flying() {
        System.out.println("Eagle.Flying()");
    }
}

//java는 단일상속, extends에 클래스 나열할 수 없음.
//class TigerEagle extends Tiger, Eagle {   }

public class AnimalTest {
    //Human, Tiger, Eagle 모두 Animal의 Sub 클래스로서 자동으로 Super클래스로 형변환 가능.
    //클래스(static, 정적)메소드. (인스턴스 여부와 관계 없이)클래스소속, 클래스에 의해 호출이 가능.
    //클래스 메소드의 호출 : 해당 클래스의 클래스 메소드나 인스턴스 메소드 모두 가능.
    public static void moveAnimal1(Animal ani) {
        ani.move();
        //호출되지 않는 이유 : 클래스 메소드인 moveAnimal1()은 클래스 내 인스턴스 메소드인 moveAnimal2()를 호출할 수 없어요!!!!!
        //moveAnimal2(ani);
    }

    //인스턴스 메소드
    //인스턴스 메소드의 호출은 클래스 내의 인스턴스 메소드만 호출 가능!!!!!
    public void moveAnimal2(Animal ani) {
        ani.move();
        //인스턴스 메소드는 본인 클래스의 클래스 메소드 호출이 가능.
        moveAnimal1(ani);
    }

    //클래스 메소드
    public static void main(String[] args) {
        //클래스 메소드인 main은 본인 클래스 소속인 다른 클래스 메소드인 moveAnimal1() 호출이 가능하다.
        //아래 문장이 안되는 이유는 Animal이 abstract class이기 때문.
        //abstract class는 단독 인스턴스화 불가.
        //오직 상속받은 sub class를 통해 가능.
        //AnimalTest.moveAnimal1(new Animal());
        //본인메소드의 클래스메소드는 클래스명을 붙이지 않아도 된다.
        moveAnimal1(new Human());
        moveAnimal1(new Tiger());
        moveAnimal1(new Eagle());

        //클래스 메소드에서 동일 클래스 내의 인스턴스를 직접 호출 불가능.
        //moveAnimal2(new Animal());

        //동일 소속이라도 인스턴스 생성 후에나 호출이 가능.
        AnimalTest aniTest = new AnimalTest();
        aniTest.moveAnimal2(new Human());
        aniTest.moveAnimal2(new Tiger());
        aniTest.moveAnimal2(new Eagle());

        ArrayList<Animal> aniList = new ArrayList<Animal>();

        //Animal a = new Human().
        //boxing. sub -> super.
        //Animal은 참조할 수 있지만 생성은 불가능한 추상 클래스입니다.
        //aniList.add(new Animal());
        aniList.add(new Human());
        aniList.add(new Eagle());
        aniList.add(new Tiger());

        for(var ani : aniList){
            ani.move();
            if (ani instanceof Human) {
                //unboxing : 많은 비용이 소모됨.
                ((Human) ani).readBook();
            }else if (ani instanceof Tiger){
                ((Tiger) ani).Hunting();
            }
        }
    }
}
