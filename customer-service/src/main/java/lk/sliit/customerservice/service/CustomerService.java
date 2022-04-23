package lk.sliit.customerservice.service;

import lk.sliit.customerservice.model.CustomerModel;
import lk.sliit.customerservice.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements CURDService<CustomerModel, Long> {

    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    @Override
    public CustomerModel insert(CustomerModel model) throws SQLException, ClassNotFoundException {
        customerRepository.save(model);
        return customerRepository.lastRecode();
    }

    @Override
    public CustomerModel update(CustomerModel model) throws SQLException, ClassNotFoundException {
        customerRepository.update(model);
        return customerRepository.findById(model.getId());
    }

    @Override
    public String delete(Long id) throws SQLException, ClassNotFoundException {
        customerRepository.delete(id);
        return "Delete competed";
    }

    @Override
    public List<CustomerModel> list() throws SQLException, ClassNotFoundException {
        return customerRepository.findALl();
    }

    @Override
    public CustomerModel getById(Long id) throws SQLException, ClassNotFoundException {
        return customerRepository.findById(id);
    }
}
