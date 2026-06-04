```java
package fileprocess;

public class Student {
    private String id;
    private String name;
    private double score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString(){
        return String.format("[%s]%s : %.2f", id, name, score);
    }

    public Student(String id, String name, double score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
}

```
