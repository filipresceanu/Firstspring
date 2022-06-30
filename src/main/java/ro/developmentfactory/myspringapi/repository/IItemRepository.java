package ro.developmentfactory.myspringapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.developmentfactory.myspringapi.model.Item;

@Repository
public interface IItemRepository extends CrudRepository<Item,Long > {
}
