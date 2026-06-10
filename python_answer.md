```java
import java.time.LocalDate;

public class Member {

    private String name;
    private LocalDate regDate;
    private LocalDate expireDate;

    public Member(String name, LocalDate regDate) {
        this.name = name;
        this.regDate = regDate;
        this.expireDate = regDate.plusDays(30);
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return name + "|" + regDate + "|" + expireDate;
    }
}
```
```java
ArrayList<Member> members = new ArrayList<>();

members.add(
    new Member(
        "홍길동",
        LocalDate.now()
    )
);
```
```java
public static void save(
        ArrayList<Member> members)
        throws Exception {

    BufferedWriter bw =
        new BufferedWriter(
            new FileWriter("member.dat"));

    for(Member m : members) {
        bw.write(m.toString());
        bw.newLine();
    }

    bw.close();
}
```
```java
public static ArrayList<Member> load()
        throws Exception {

    ArrayList<Member> members =
        new ArrayList<>();

    File file =
        new File("member.dat");

    if(!file.exists())
        return members;

    BufferedReader br =
        new BufferedReader(
            new FileReader(file));

    String line;

    while((line = br.readLine()) != null) {

        String[] token =
            line.split("\\|");

        Member m =
            new Member(
                token[0],
                LocalDate.parse(token[1])
            );

        members.add(m);
    }

    br.close();

    return members;
}
```
```java
public static boolean isExpired(
        Member member) {

    return LocalDate.now()
            .isAfter(
                member.getExpireDate());
}
```