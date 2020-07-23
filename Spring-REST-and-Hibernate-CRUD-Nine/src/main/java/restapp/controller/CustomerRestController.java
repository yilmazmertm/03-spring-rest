package restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapp.entity.Customer;
import restapp.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private ClientService customerClientService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerClientService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer theCustomer = customerClientService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer (@RequestBody Customer theCustomer) {
        theCustomer.setId(0);

        customerClientService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @RequestMapping( value = "/customers" , method = {RequestMethod.PUT})
    public Customer updateCustomer(@RequestBody Customer theCustomer){

        customerClientService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer tempCustomer = customerClientService.getCustomer(customerId);
        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        customerClientService.deleteCustomer(customerId);
        return "Deleted customer is - " + customerId;
    }
}
