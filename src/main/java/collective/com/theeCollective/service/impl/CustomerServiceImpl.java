package collective.com.theeCollective.service.impl;

import collective.com.theeCollective.dto.CustomerDto;
import collective.com.theeCollective.model.Customer;
import collective.com.theeCollective.repository.CustomerRepository;
import collective.com.theeCollective.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> mapToCustomerDto(customer)).collect(Collectors.toList());
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    private CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .names(customer.getNames())
                .email(customer.getEmail())
                .username(customer.getUsername())
                .age(customer.getAge())
                .password(customer.getPassword())
                .build();
        return customerDto;
    }


}
