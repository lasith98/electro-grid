package lk.sliit.customerservice.service;


import java.sql.SQLException;
import java.util.List;

public interface CURDService<M, I> {


    M insert(M model) throws SQLException, ClassNotFoundException;

    M update(M model) throws SQLException, ClassNotFoundException;

    String delete(I id) throws SQLException, ClassNotFoundException;

    List<M> list() throws SQLException, ClassNotFoundException;

    M getById(I id) throws SQLException, ClassNotFoundException;


}
