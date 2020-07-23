package restapp.service;

import org.springframework.stereotype.Service;
import restapp.entity.Customer;

import java.util.List;


public interface ClientService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
