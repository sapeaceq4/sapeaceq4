package com.sapient.ace.spring.jdbc.transactions;

import com.sapient.ace.spring.model.Employee;
import org.apache.activemq.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by Ravdeep Singh on 2/16/2017.
 */

public class EmployeeTransactionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    public int saveEmployee(Employee e) {
        String query = "insert into employee values( '" + e.getId() + "', '" + e.getName() + "', '" + e.getSalary() + "')";
        return jdbcTemplate.update(query);
    }

    public void updateEmployee(Employee e) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {

            String query = "update employee set name = '" + e.getName() + "', salary = '" + 90000 + "' where id = '" + e.getId() + "' ";
            System.out.println(query);
            jdbcTemplate.update(query);
//            transactionManager.commit(status);
        } catch (Exception exe) {
            System.out.println(exe.getMessage());
        }


    }

    public int deleteEmployee(Employee e) {
        String query = "delete from employee where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }

}
