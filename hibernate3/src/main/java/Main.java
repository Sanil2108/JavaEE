import org.hibernate.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 13/1/18.
 */
public class Main{

    @Entity
    @Cacheable
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @Table(name = "Student")
    static class Student{
        @Id
        private int rollNo;
        private String name;
        private int marks;

        @ManyToMany(mappedBy = "stud", fetch = FetchType.EAGER)
        private List<Laptop> laptop=new ArrayList<Laptop>();

        public List<Laptop> getLaptop() {
            return laptop;
        }

        public void setLaptop(List<Laptop> laptop) {
            this.laptop = laptop;
        }

        //        @OneToMany(mappedBy = "stud")
//        private ArrayList<Laptop> laptop;

        @Override
        public String toString() {
            return "Student{" +
                    "rollNo=" + rollNo +
                    ", name='" + name + '\'' +
                    ", marks=" + marks +
                    '}';
        }

        public int getRollNo() {
            return rollNo;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }
    }

    @Entity
    @Cacheable
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @Table(name = "Laptop")
    static class Laptop{
        @Id
        private int lid;
        private String lname;

        @ManyToMany
        private List<Student> stud=new ArrayList<Student>();

        public List<Student> getStud() {
            return stud;
        }

        public void setStud(List<Student> stud) {
            this.stud = stud;
        }

        //        @ManyToOne
//        private Student stud;

        @Override
        public String toString() {
            return "Laptop{" +
                    "lid=" + lid +
                    ", lname='" + lname + '\'' +
                    '}';
        }

        public int getLid() {
            return lid;
        }

        public void setLid(int lid) {
            this.lid = lid;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }
    }

    public static void main(String[] args){
        Configuration configuration=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

//        Transaction tx=session.beginTransaction();

//        Laptop laptop=new Laptop();
//        laptop.setLid(0);
//        laptop.setLname("Lenovo Z50-70");
//
//        Student student=new Student();
//        student.getLaptop().add(laptop);
//        student.setMarks(90);
//        student.setName("Student1");
//        student.setRollNo(0);
//
//        laptop.getStud().add(student);
//
//        session.save(student);
//        session.save(laptop);

        Student s;
        s=session.get(Student.class, 0);
        System.out.println(s);
        session.close();

        Session session2=sessionFactory.openSession();
        session2.beginTransaction();
        s=session2.get(Student.class, 0);
        System.out.println(s);
        session2.close();

//        Collection<Laptop> laptops=s.getLaptop();
//        for(Laptop l:laptops){
//            System.out.println(l);
//        }

//        tx.commit();
    }

}
