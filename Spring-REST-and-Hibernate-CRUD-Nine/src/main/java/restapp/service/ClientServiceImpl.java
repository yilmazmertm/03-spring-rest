package restapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import restapp.dao.ClientDAO;
import restapp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO customerClientDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerClientDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerClientDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerClientDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerClientDAO.deleteCustomer(theId);
    }
}
