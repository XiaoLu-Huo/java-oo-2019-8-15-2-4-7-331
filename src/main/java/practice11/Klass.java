package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private Integer number;
    private Student leader;


    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(Student student, NoticeType noticeType) {
        for (Observer observer : observers) {
            observer.update(this, student, noticeType);
        }
    }

    public Student getLeader() {
        return leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number.equals(klass.number);
    }


    public void assignLeader(Student leader) {
        if (this.equals(leader.getKlass())) {
            this.leader = leader;
            notifyObservers(leader, NoticeType.BECOME_LEADER);
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        notifyObservers(student, NoticeType.JOIN_CLASS);
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

    public boolean isIn(Student student) {
        return this.equals(student.getKlass());
    }
}
