package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jesus on 17.09.2017.
 */
public class Domain {
    public static void main(String [] args){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Kyiv");
        address.setStreet("Pidvysotskogo");
        address.setPostCode("10014");

        Project project = new Project();
        project.setTitle("Kyiv UA");

        Employee employee = new Employee();
        employee.setFirstName("Jesus");
        employee.setLastName("Raichuk");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1996,Calendar.MAY, 12);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(project);
        session.save(employee);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
