package practice08;

public class Student extends Person{
    private static final String STUDENT = " I am a Student.";
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        if (this.equals(klass.getLeader())) {
            return super.introduce() + STUDENT + " I am Leader of " + klass.getDisplayName() + ".";
        }
        return super.introduce() + STUDENT + " I am at " + klass.getDisplayName() + ".";
    }

}
