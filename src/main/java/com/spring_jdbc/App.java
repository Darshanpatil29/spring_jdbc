package com.spring_jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.spring_jdbc.dao.StudentDao;
import com.spring_jdbc.dao.StudentDaoImpl;
import com.spring_jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World this is Spring JDBC Tutorial!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentDao studentDao=context.getBean("studentDaoImpl",StudentDaoImpl.class);
//        Student student=new Student();
//        student.setId(400);
//        student.setName("Arya");
//        student.setCity("Bravos");
//        studentDao.insert(student);
        
//        Student student=new Student();
//        student.setId(304);
//        student.setName("Tyrion");
//        student.setCity("Marrine");
//        System.out.println(studentDao.update(student));
        
//        Student student=new Student();
//        student.setId(306);
//	      System.out.println(studentDao.delete(student));
        
//	      Student std=studentDao.display(300);
//	      System.out.println(std);
//	      std.toString();
        
        List<Student> stdList=studentDao.display();
        System.out.println(stdList);
        
//        JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        String query="insert into student(id,name,city) values (?,?,?)";
//        
////        int result=jdbcTemplate.update(query,300,"David","Winterfell" );
////        System.out.println(result);
////        
//        List<Object []> studList=new ArrayList<>(
//        		Arrays.asList(
//        				 new Object[]{305, "Robert", "King"},
//        				 new Object[]{306, "Joffrey", "King ||"}
//        	)
//        );
//        studList.forEach(student->System.out.println(Arrays.toString(student)));
//        int [] result1=jdbcTemplate.batchUpdate(query,studList);
//        System.out.println("result1: "+ Arrays.stream(result1).sum());
    }
}
