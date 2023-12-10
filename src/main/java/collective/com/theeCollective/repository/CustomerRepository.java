package collective.com.theeCollective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import collective.com.theeCollective.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
    @Override
    Optional<Customer> findById(Long aLong);

}
