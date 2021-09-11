package practice11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer{
    private static final String TEACHER = " I am a Teacher.";
    private LinkedList<Klass> klass;

    @Override
    public void update(Klass klass, Student student, NoticeType noticeType) {
        if (noticeType == NoticeType.JOIN_CLASS) {
            System.out.println("I am " + getName() + ". I know " + student.getName() + " has joined Class " + klass.getNumber() + ".");
        }
        if (noticeType == NoticeType.BECOME_LEADER) {
            System.out.println("I am " + getName() + ". I know " + student.getName() + " become Leader of Class " + klass.getNumber() + ".");
        }
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klass) {
        super(id, name, age);
        this.klass = klass;
        for (Klass klass1 : klass) {
            klass1.attach(this);
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public LinkedList<Klass> getClasses() {
        return klass;
    }

    public void setKlass(LinkedList<Klass> klass) {
        this.klass = klass;
    }

    public String introduce() {
        if (klass == null) {
            return super.introduce() + TEACHER + " I teach No Class.";
        } else {
            List<String> collect = klass.stream()
                    .map(s -> s.getNumber().toString())
                    .collect(Collectors.toList());
            return super.introduce() + TEACHER + " I teach Class " + String.join(", ", collect) + ".";
        }
    }

    public boolean isTeaching(Student student) {
        return isIn(student);
    }

    public boolean isIn(Student student) {
        for (Klass klass1 : klass) {
            if (klass1.isIn(student)) {
                return true;
            }
        }
        return false;
    }

    public String introduceWith(Student student) {
        if (klass.stream()
                .filter(s -> s.equals(student.getKlass()))
                .collect(Collectors.toList()).size() != 0) {
            return super.introduce() + TEACHER + " I teach " + student.getName() + ".";
        }
        return super.introduce()  + TEACHER + " I don't teach " + student.getName() + ".";
    }
}
