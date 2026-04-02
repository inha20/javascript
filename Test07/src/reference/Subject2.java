package reference;

public class Subject2 {
    private String name;
    private int score;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(String score) {
        if (score<0) {this.score=0;}
        else if (score>100) {this.score=100;}
        else {this.score=score;}
    }
    public void showInfo() {
        System.out.println(name + ":" + score);
    }

}
