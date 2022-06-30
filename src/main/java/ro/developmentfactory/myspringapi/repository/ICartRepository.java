package ro.developmentfactory.myspringapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.developmentfactory.myspringapi.model.Cart;

@Repository
public interface ICartRepository extends CrudRepository<Cart,Long> {
}
