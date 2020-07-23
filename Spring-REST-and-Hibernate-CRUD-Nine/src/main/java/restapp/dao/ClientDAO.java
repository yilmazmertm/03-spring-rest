package restapp.dao;

import org.springframework.stereotype.Repository;
import restapp.entity.Customer;

import java.util.List;

public interface ClientDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
