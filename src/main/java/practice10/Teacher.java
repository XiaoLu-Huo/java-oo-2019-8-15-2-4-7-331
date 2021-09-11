package practice10;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private static final String TEACHER = " I am a Teacher.";
    private LinkedList<Klass> klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public LinkedList<Klass> getClasses() {
        return klass;
    }

    public void setKlass(LinkedList<Klass> klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        if (klass != null) {
            List<String> collect = klass.stream()
                    .map(s -> s.getNumber().toString())
                    .collect(Collectors.toList());
            return super.introduce() + TEACHER + " I teach Class " + String.join(", ", collect) + ".";
        } else {
            return super.introduce() + TEACHER + " I teach No Class.";
        }
    }

    public boolean isTeaching(Student student) {
        return isIn(student);
    }

    public boolean isIn(Student student) {
        return klass.stream()
                .anyMatch(s -> s.isIn(student));
    }

    public String introduceWith(Student student) {
        List<Klass> collect = klass.stream().filter(s -> s.equals(student.getKlass())).collect(Collectors.toList());
        if (collect.size() != 0) {
            return super.introduce() + TEACHER + " I teach " + student.getName() + ".";
        }
        return super.introduce()  + TEACHER + " I don't teach " + student.getName() + ".";
    }
}
