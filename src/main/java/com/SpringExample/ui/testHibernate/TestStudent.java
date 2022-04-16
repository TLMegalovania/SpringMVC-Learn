package com.SpringExample.ui.testHibernate;

import com.SpringExample.hibernate.HibernateInitialize;
import com.SpringExample.model.Course;
import com.SpringExample.model.Student;
import com.SpringExample.model.StudentCourse;
import com.SpringExample.model.StudentCoursePK;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.scene.control.Slider;
import org.aspectj.weaver.ast.Test;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.w3c.dom.css.CSS2Properties;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class TestStudent {

    private void add(){

        Student s1 = new Student();
        s1.setStuNo("s0001");
        s1.setStuName("张山");
        s1.setSex("男");
        s1.setEmail("s0001@whu.edu.cn");
        s1.setTel("18986110001");

        Student s2 = new Student();
        s2.setStuNo("s0002");
        s2.setStuName("李四");
        s2.setSex("男");
        s2.setEmail("s0002@whu.edu.cn");
        s2.setTel("18986110002");

        Student s3 = new Student();
        s3.setStuNo("s0003");
        s3.setStuName("王五");
        s3.setSex("女");
        s3.setEmail("s0003@whu.edu.cn");
        s3.setTel("18986110003");

        Course c1 = new Course();
        c1.setCourseNo("c0001");
        c1.setCourseName("数据结构");
        c1.setXf(4.0);

        Course c2 = new Course();
        c2.setCourseNo("c0002");
        c2.setCourseName("数据库系统概论");
        c2.setXf(4.0);

        Course c3 = new Course();
        c3.setCourseNo("c0003");
        c3.setCourseName("操作系统");
        c3.setXf(3);

        Course c4 = new Course();
        c4.setCourseNo("c0004");
        c4.setCourseName("web程序设计");
        c4.setXf(2);

        StudentCoursePK scPK1 = new StudentCoursePK();
        scPK1.setStuNo("s0001");
        scPK1.setCourseNo("c0001");

        StudentCourse sc1 = new StudentCourse();
        sc1.setScPk(scPK1);
        sc1.setYear("2020");
        sc1.setTeacherName("张老师");
        sc1.setScore(80);

        //s0001
        StudentCoursePK scPK2 = new StudentCoursePK();
        scPK2.setStuNo("s0001");
        scPK2.setCourseNo("c0002");

        StudentCourse sc2 = new StudentCourse();
        sc2.setScPk(scPK2);
        sc2.setYear("2020");
        sc2.setTeacherName("李老师");
        sc2.setScore(90);

        StudentCoursePK scPK3 = new StudentCoursePK();
        scPK3.setStuNo("s0001");
        scPK3.setCourseNo("c0003");

        StudentCourse sc3 = new StudentCourse();
        sc3.setScPk(scPK3);
        sc3.setYear("2020");
        sc3.setTeacherName("王老师");
        sc3.setScore(100);

        //s0002
        StudentCoursePK scPK4 = new StudentCoursePK();
        scPK4.setStuNo("s0002");
        scPK4.setCourseNo("c0001");

        StudentCourse sc4 = new StudentCourse();
        sc4.setScPk(scPK4);
        sc4.setYear("2020");
        sc4.setTeacherName("张老师");
        sc4.setScore(80);


        StudentCoursePK scPK5 = new StudentCoursePK();
        scPK5.setStuNo("s0002");
        scPK5.setCourseNo("c0003");

        StudentCourse sc5 = new StudentCourse();
        sc5.setScPk(scPK5);
        sc5.setYear("2020");
        sc5.setTeacherName("王老师");
        sc5.setScore(90);

        //s0003
        StudentCoursePK scPK6 = new StudentCoursePK();
        scPK6.setStuNo("s0003");
        scPK6.setCourseNo("c0002");

        StudentCourse sc6 = new StudentCourse();
        sc6.setScPk(scPK6);
        sc6.setYear("2020");
        sc6.setTeacherName("李老师");
        sc6.setScore(94);

        StudentCoursePK scPK7 = new StudentCoursePK();
        scPK7.setStuNo("s0003");
        scPK7.setCourseNo("c0003");

        StudentCourse sc7 = new StudentCourse();
        sc7.setScPk(scPK7);
        sc7.setYear("2020");
        sc7.setTeacherName("王老师");
        sc7.setScore(95);

        StudentCoursePK scPK8 = new StudentCoursePK();
        scPK8.setStuNo("s0003");
        scPK8.setCourseNo("c0004");

        StudentCourse sc8 = new StudentCourse();
        sc8.setScPk(scPK8);
        sc8.setYear("2021");
        sc8.setTeacherName("刘老师");
        sc8.setScore(99);

        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            session.beginTransaction();//开启事务
            session.save(s1);//执行数据库添加操作， 目前处于持久化状态
            session.save(s2);
            session.save(s3);

            session.save(c1);
            session.save(c2);
            session.save(c3);
            session.save(c4);

            session.save(sc1);
            session.save(sc2);
            session.save(sc3);
            session.save(sc4);
            session.save(sc5);
            session.save(sc6);
            session.save(sc7);
            session.save(sc8);
            session.getTransaction().commit();//事务提交 ，目前处于脏对象状态
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //基于many-to-one,根据从表，查主表
    private void query1(){

        StudentCoursePK scPK = new StudentCoursePK();
        scPK.setStuNo("s0001");
        scPK.setCourseNo("c0001");

        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            session.beginTransaction();//开启事务
            StudentCourse result =  (StudentCourse)session.get(StudentCourse.class, scPK);

            System.out.println("学号："+ result.getScPk().getStuNo());
            System.out.println("课程："+ result.getScPk().getCourseNo());
            System.out.println("选课年份："+ result.getYear());
            System.out.println("教师："+ result.getTeacherName());
            System.out.println("成绩："+ result.getScore());

            //延迟加载
            System.out.println("学生姓名："+ result.getStudent().getStuName());

            session.getTransaction().commit();//事务提交 ，目前处于脏对象状态
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //基于one-to-many 根据主表，查从表
    private void query2(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            session.beginTransaction();//开启事务
            Student result =  (Student)session.get(Student.class, "s0001");

            System.out.println("学号："+ result.getStuNo());
            System.out.println("姓名："+ result.getStuName());

            Set<StudentCourse> studentCourseSet = result.getStudentCourses();

            System.out.println("选课列表：");
            for (StudentCourse sc: studentCourseSet) {
                System.out.print("课程：" + sc.getScPk().getCourseNo() + "  ");
                System.out.print("选课年份：" + sc.getYear() + "  ");
                System.out.print("教师：" + sc.getTeacherName() + "  ");
                System.out.print("成绩：" + sc.getScore() + "  ");
                System.out.println("");
            }

            session.getTransaction().commit();//事务提交 ，目前处于脏对象状态
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //Hibernate Query Language (hql)
    private void hql1(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            String hql = " from Student student";
            hql += " where student.sex='男'";

            Query q = session.createQuery(hql);
            List<Student> results = q.list();

            for (Student result : results) {
                System.out.println("学号：" + result.getStuNo());
                System.out.println("姓名：" + result.getStuName());
                System.out.println("性别：" + result.getSex());


                Set<StudentCourse> studentCourseSet = result.getStudentCourses();

                System.out.println("选课列表：");
                for (StudentCourse sc : studentCourseSet) {
                    System.out.print("课程：" + sc.getScPk().getCourseNo() + "  ");
                    System.out.print("选课年份：" + sc.getYear() + "  ");
                    System.out.print("教师：" + sc.getTeacherName() + "  ");
                    System.out.print("成绩：" + sc.getScore() + "  ");
                    System.out.println("");
                }

            }

            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //hql的参数传递
    private void hql2(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            String hql = " from Student student";
            hql += " where student.sex=?1";
            hql += " and student.stuName like ?0";

            Query q = session.createQuery(hql);
            q.setParameter(1, "男");
            q.setParameter(0, "%张%");
            List<Student> results = q.list();

            for (Student result : results) {
                System.out.println("学号：" + result.getStuNo());
                System.out.println("姓名：" + result.getStuName());
                System.out.println("性别：" + result.getSex());

                Set<StudentCourse> studentCourseSet = result.getStudentCourses();

                System.out.println("选课列表：");
                for (StudentCourse sc : studentCourseSet) {
                    System.out.print("课程：" + sc.getScPk().getCourseNo() + "  ");
                    System.out.print("选课年份：" + sc.getYear() + "  ");
                    System.out.print("教师：" + sc.getTeacherName() + "  ");
                    System.out.print("成绩：" + sc.getScore() + "  ");
                    System.out.println("");
                }
            }

            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }


    //hql的参数传递
    private void hql3(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            String hql = " from Student student";
            hql += " where student.sex=:sexP";

            Query q = session.createQuery(hql);
            q.setParameter("sexP", "女");
            List<Student> results = q.list();

            for (Student result : results) {
                System.out.println("学号：" + result.getStuNo());
                System.out.println("姓名：" + result.getStuName());
                System.out.println("性别：" + result.getSex());

                Set<StudentCourse> studentCourseSet = result.getStudentCourses();

                System.out.println("选课列表：");
                for (StudentCourse sc : studentCourseSet) {
                    System.out.print("课程：" + sc.getScPk().getCourseNo() + "  ");
                    System.out.print("选课年份：" + sc.getYear() + "  ");
                    System.out.print("教师：" + sc.getTeacherName() + "  ");
                    System.out.print("成绩：" + sc.getScore() + "  ");
                    System.out.println("");
                }
            }

            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //hql的排序
    private void hql4(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            String hql = " from StudentCourse sc";
            hql += " order by sc.scPk.stuNo asc, sc.scPk.courseNo desc";

            Query q = session.createQuery(hql);

            List<StudentCourse> results = q.list();

            for (StudentCourse result : results) {

                    System.out.print("学号：" + result.getScPk().getStuNo() + "  ");
                    System.out.print("课程：" + result.getScPk().getCourseNo() + "  ");
                    System.out.print("选课年份：" + result.getYear() + "  ");
                    System.out.print("教师：" + result.getTeacherName() + "  ");
                    System.out.print("成绩：" + result.getScore() + "  ");
                    System.out.println("");

            }

            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }


    //hql的聚合函数sum, min, max, avg, count
    private void hql5(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            String hql = " select avg(sc.score) from StudentCourse sc";
            hql += " where sc.scPk.stuNo='s0001'";

            Query q = session.createQuery(hql);

            double avgScore = (Double)q.uniqueResult();
            System.out.println("平均成绩：" + avgScore);


            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //hql的group
    private void hql6(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            String hql = " select sc.scPk.stuNo, count(sc.scPk.courseNo) from StudentCourse sc";
            hql += " group by sc.scPk.stuNo";

            Query q = session.createQuery(hql);

            List results = q.list();
            Iterator iterator = results.iterator();
            while (iterator.hasNext()){
                Object[] result = (Object[])iterator.next();
                System.out.println("学号：" + (String)result[0] + ", 选课数:" + (Long)result[1]);
            }



            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //hql的多表联合查询
    private void hql7(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            session.beginTransaction();//开启事务

            String hql = " select student.stuNo,student.stuName, student.sex, sc.scPk.courseNo, sc.year, sc.teacherName, sc.score,sc.remark" +
                    " from Student student, StudentCourse sc " +
                    " where student.stuNo = sc.scPk.stuNo";
            hql += " order by student.stuNo, sc.scPk.courseNo";

            Query q = session.createQuery(hql);

            List results = q.list();
            Iterator iterator = results.iterator();
            while (iterator.hasNext()){
                Object[] result = (Object[])iterator.next();
                System.out.print("学号：" + (String)result[0]);
                System.out.print(",姓名：" + (String)result[1]);
                System.out.print(",性别：" + (String)result[2]);
                System.out.print(",选课编号：" + (String)result[3]);
                System.out.print(",选课年份：" + (String)result[4]);
                System.out.print(",老师：" + (String)result[5]);
                System.out.print(",成绩：" + (Integer)result[6]);
                System.out.print(",备注：" + (String)result[7]);
                System.out.println("");
            }



            session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }

    //Criteria查询
    private void hql8(){
        Session session = null;			//声明Session对象
        try {
            session = HibernateInitialize.getSession();//获取Session
            //session.beginTransaction();//开启事务

            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("sex", "男"));
            criteria.addOrder(Order.desc("stuNo"));
            List<Student> results = criteria.list();

            for (Student result : results) {
                System.out.println("学号：" + result.getStuNo());
                System.out.println("姓名：" + result.getStuName());
                System.out.println("性别：" + result.getSex());

                Set<StudentCourse> studentCourseSet = result.getStudentCourses();

                System.out.println("选课列表：");
                for (StudentCourse sc : studentCourseSet) {
                    System.out.print("课程：" + sc.getScPk().getCourseNo() + "  ");
                    System.out.print("选课年份：" + sc.getYear() + "  ");
                    System.out.print("教师：" + sc.getTeacherName() + "  ");
                    System.out.print("成绩：" + sc.getScore() + "  ");
                    System.out.println("");
                }
            }

            //session.getTransaction().commit();//
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            HibernateInitialize.closeSession();//关闭Session对象，目前处于托管状态，最后被JVM回收
        }
    }
    public static void main(String[] args) {
        TestStudent testStudent = new TestStudent();
        //testStudent.add();

        //testStudent.query1();
        //testStudent.query2();

        //testStudent.hql1();
        //testStudent.hql2();
        //testStudent.hql3();

        //testStudent.hql4();

        //testStudent.hql5();

        //testStudent.hql6();

        //testStudent.hql7();

        testStudent.hql8();
    }
}
