package ro.developmentfactory.myspringapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.developmentfactory.myspringapi.model.Item;
import ro.developmentfactory.myspringapi.model.exception.ItemNotFoundException;
import ro.developmentfactory.myspringapi.repository.IItemRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Component
@Service
public class ItemService {

    private final IItemRepository itemRepository;


    public ItemService(IItemRepository itemRepository)
    {
        this.itemRepository=itemRepository;
    }

    public Item addItem(Item item)
    {
        return itemRepository.save(item);
    }

    public List<Item> getItems()
    {
        return StreamSupport
                .stream( itemRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
    public Item getItem(Long id)
    {
        return itemRepository.findById(id).orElseThrow(()->new ItemNotFoundException(id));
    }

    public Item deleteItem(Long id) {
       Item item=getItem(id);
       itemRepository.delete(item);
       return item;
    }


    public Item editItem(Long id,Item item)
    {
        Item itemToEdit=getItem(id);
        itemToEdit.setSerialNumber(item.getSerialNumber());
        itemRepository.save(itemToEdit);
        return  itemToEdit;
    }
}
