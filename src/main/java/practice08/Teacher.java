package practice08;


public class Teacher extends Person{
    private static final String TEACHER = " I am a Teacher.";
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id,name, age);
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
        String introduce = super.introduce();
        if (klass == null) {
            return introduce + TEACHER + " I teach No Class.";
        }
        return introduce + TEACHER + " I teach " + klass.getDisplayName() + ".";
    }

    public String introduceWith(Student student) {
        String introduce = super.introduce();
        if (student.getKlass().getNumber().equals(klass.getNumber())) {
            return introduce + TEACHER + " I teach " + student.getName() + ".";
        }
        return introduce + TEACHER + " I don't teach " + student.getName() + ".";
    }
}
