package lk.ijse.dep7;

import lk.ijse.dep7.entity.Class;
import lk.ijse.dep7.entity.ClassStudent;
import lk.ijse.dep7.entity.ClassStudentPK;
import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo13 {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession()){

            session.beginTransaction();

            Class mad = session.find(Class.class, "MAD");

            List<ClassStudent> classStudentList = new ArrayList<>();
            Class cmjd = new Class("CMJD", "Comprehensive Master Java Developer", classStudentList);

            Student s004 = new Student("S004", "Aruni", "Matara");
            Student s005 = new Student("S005", "Dinusha", "Galle");

            ClassStudent cs001 = new ClassStudent(new ClassStudentPK(null, "S004"), Date.valueOf("2021-05-01"), mad, s004);
            ClassStudent cs002 = new ClassStudent(new ClassStudentPK("DEP", "S005"), Date.valueOf("2021-05-01"), mad, s005);

            classStudentList.add(cs001);
            classStudentList.add(cs002);

            session.persist(cmjd);

            session.getTransaction().commit();

        }

    }
}
