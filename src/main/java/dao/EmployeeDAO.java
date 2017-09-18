package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jesus on 19.09.2017.
 */
public interface EmployeeDAO {

    //create
    void add(Employee employee) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;

    //update
    void update(Employee employee) throws SQLException;

    //delete
    void remove(Employee employee) throws SQLException;
}
