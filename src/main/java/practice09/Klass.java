package practice09;

public class Klass {
    private Integer number;
    private Student leader;

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (this.equals(leader.getKlass())) {
            this.leader = leader;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Klass klass = (Klass) obj;
        return number.equals(klass.number);
    }
}
