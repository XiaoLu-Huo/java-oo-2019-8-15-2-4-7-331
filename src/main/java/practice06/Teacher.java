package practice06;

public class Teacher extends Person{
    private Integer klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String introduce = super.introduce();
        if (klass == null) {
            return introduce + " I am a Teacher. I teach No Class.";
        }
        return introduce + " I am a Teacher. I teach Class " + klass + ".";
    }
}
