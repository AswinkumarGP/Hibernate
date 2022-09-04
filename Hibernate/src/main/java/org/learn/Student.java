package org.learn;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student_table")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

    @Id
    private int rollNo;
    @Embedded
    private StudentName name;
    //@Transient
    private int mark;
    @OneToOne
    private Laptop laptop;
    @OneToMany(mappedBy = "student")
    private List<Mobile> mobiles;
    @ManyToMany(mappedBy = "studentList", fetch = FetchType.EAGER)
    private List<Bank> loan;

    public Student(){}

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    public List<Bank> getLoan() {
        return loan;
    }

    public void setLoan(List<Bank> loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name=" + name +
                ", mark=" + mark +
                '}';
    }
}
