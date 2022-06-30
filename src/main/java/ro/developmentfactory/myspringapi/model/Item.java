package ro.developmentfactory.myspringapi.model;

import lombok.Data;
import ro.developmentfactory.myspringapi.model.dto.ItemDto;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    @ManyToOne
    private Cart cart;

    public static Item from(ItemDto itemDto) {
        Item item = new Item();
        item.setSerialNumber(itemDto.getSerialNumber());
        return item;
    }

}
