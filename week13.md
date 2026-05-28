exception
```java
package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling1{
    public void main() {
        try {
            FileInputStream fs = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            //여기서 처리하지 않고 main() 호출측으로 넘기기
            //throw new RuntimeException(e);

            //여기서 처리하는 경우
            System.out.println(e);
        }
        System.out.println("오류가 일어났음으로 프로그램을 종료합니다.");
    }
}
/**
main()메소드에서 처리하지 않고 jvm으로 떠넘기기 525p
public class ExceptionHandling1{
    public void main() throws FileNotFoundException{
        FileInputStream fs = new FileInputStream("a.txt");
    }
}
**/
```

```java
package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling2 {
    static void main() {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("a.txt");
        }catch(FileNotFoundException e){
            e.printStackTrace();
            //System.out.println(e);
        }finally{
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

```

```java
package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling3 {
    static void main() {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("a.txt");
            System.out.println(fs.read());
        }catch(FileNotFoundException e){
            e.printStackTrace();
            //System.out.println(e);
        }catch(IOException e) {
            //IOException 계열 오류만 처리
        }catch(Exception e){
            //FileNotFound, IO 예외를 제외한 모든 오류 처리
        } finally{
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

```java
package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling4 {
    static void main() {
        //fs.close()를 try 벗어나면 자동으로 수행. java7부터.
        try (FileInputStream fs = new FileInputStream("a.txt")){

        }catch(FileNotFoundException e) {
            e.printStackTrace();
            //System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

```

```java
package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling5 {
    static void main() {
        //fs.close()를 try 벗어나면 자동으로 수행
        try {
            //java9부터 지원. try() 밖에서 생성해도 close() 실행
            FileInputStream fs = new FileInputStream("a.txt");
            try(fs){

            } catch (Exception e) {

            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            //System.out.println(e);
        }
    }
}

```








generics
