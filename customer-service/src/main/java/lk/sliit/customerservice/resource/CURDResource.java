package lk.sliit.customerservice.resource;

import lk.sliit.customerservice.wrapper.ResponseWrapper;

import java.util.List;

public interface CURDResource<M,I> {



    ResponseWrapper<M> insert(M model);
    ResponseWrapper<M> update(M model);
    ResponseWrapper<String> delete(I id) ;
    ResponseWrapper<List<M>> list();
    ResponseWrapper<M> getById(I id);




}
