package basic;

public class Student {

    public Student(int id, String name, String course){
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int id;
    public String name;

    public String course;

    public int getId(){
        return this.id;
    }
}
