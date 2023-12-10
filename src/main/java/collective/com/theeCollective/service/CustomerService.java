package collective.com.theeCollective.service;

import collective.com.theeCollective.dto.CustomerDto;
import collective.com.theeCollective.model.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAllCustomers();
    Customer saveCustomer(Customer customer);
}
