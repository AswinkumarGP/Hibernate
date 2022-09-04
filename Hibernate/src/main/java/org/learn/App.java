package org.learn;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.transform.ResultTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Car car = new Car();
        car.setCarNo("1001");
        car.setCarModel("Tesla");

        List<Bank> bankList = new ArrayList<>();
        Bank bank = new Bank();
        bank.setLoanId("1000");
        bank.setLoanAmt("HDFC");

        Laptop laptop = new Laptop();
        laptop.setId("1");
        laptop.setBrand("Dell");

        List<Mobile> mobileList = new ArrayList<>();
        Mobile mobile = new Mobile();
        mobile.setMobileNumber("32465361719");

        StudentName studentName = new StudentName();
        studentName.setFirstName("Aswin");
        studentName.setLastName("GP");
        Student student = new Student();
        student.setRollNo(100);
        student.setName(studentName);
        student.setMark(90);
        student.setLaptop(laptop);
        student.setMobiles(mobileList);
        student.setLoan(bankList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        bank.setStudentList(studentList);
        bankList.add(bank);

        mobile.setStudent(student);
        mobileList.add(mobile);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class).addAnnotatedClass(Mobile.class).addAnnotatedClass(Bank.class).addAnnotatedClass(Car.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session mainSession = sessionFactory.openSession();
        mainSession.beginTransaction();
        mainSession.save(student);
        mainSession.save(laptop);
        mainSession.save(mobile);
        mainSession.save(bank);
        mainSession.save(car);
        mainSession.getTransaction().commit();
        mainSession.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Student std = session1.get(Student.class, 100);
        System.out.println(std);
        System.out.println(std.getLaptop().getBrand());
        for (Mobile mobile1 : std.getMobiles()){
            System.out.println(mobile1.getMobileNumber());
        }
        for (Bank bank1 : std.getLoan()) {
            System.out.println(bank1.getLoanAmt());
        }
        Student std1 = session1.get(Student.class, 100);
        Query query = session1.createQuery("from Car where carNo=1001");
        query.setCacheable(true);
        Car car1 = (Car)query.uniqueResult();
        System.out.println(car1.getCarModel());
        session1.getTransaction().commit();
        session1.close();

        System.out.println("session2 starts");
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Student std2 = session2.get(Student.class, 100);
        System.out.println(std2);
        System.out.println(std2.getLaptop().getBrand());
        for (Mobile mobile1 : std2.getMobiles()){
            System.out.println(mobile1.getMobileNumber());
        }
        for (Bank bank1 : std2.getLoan()) {
            System.out.println(bank1.getLoanAmt());
        }

        System.out.println("load");
        Car s10 = session2.load(Car.class, "1001");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //set second-level cache to false
        System.out.println(s10.getCarModel());

        Query query2 = session2.createQuery("from Car where carNo=1001");
        query2.setCacheable(true);
        Car car2 = (Car)query2.uniqueResult();
        //Car car2 = session2.get(Car.class, "1001");
        System.out.println(car2.getCarModel());

        String b = "1001";
        Query q3 = session2.createQuery("select carNo,carModel from Car c where c.carNo = :b");
        q3.setParameter("b", b);
        Object[] obj = (Object[])q3.uniqueResult();
        System.out.println(obj[0] +"-"+obj[1]);

        NativeQuery nativeQuery = session2.createNativeQuery("select * from car where carno=1001");
        nativeQuery.addEntity(Car.class);
        Car c1 = (Car)nativeQuery.uniqueResult();
        System.out.println(c1.getCarModel());
        //Object res = nativeQuery.uniqueResult();
        //System.out.println(res);

        NativeQuery nativeQuery2 = session2.createSQLQuery("select carno, carmodel from car where carno=1001");
        nativeQuery2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Map o3 = (Map)nativeQuery2.uniqueResult();
        System.out.println(o3);
        System.out.println(o3.get("CARNO"));

        session2.getTransaction().commit();
        session2.close();

    }
}
