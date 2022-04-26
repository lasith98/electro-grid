package lk.sliit.customerservice.repository;

import lk.sliit.customerservice.model.CustomerModel;

public class CustomerRepository extends Repository<CustomerModel, Long> {
    private static CustomerRepository repository;

    private CustomerRepository() {

    }


    public static CustomerRepository getInstance() {
        if (repository == null) {
            repository = new CustomerRepository();
            repository.tableName = "customer";
            repository.model = new CustomerModel();
        }
        return repository;
    }
}
