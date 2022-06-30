package ro.developmentfactory.myspringapi.model.dto;

import lombok.Data;
import ro.developmentfactory.myspringapi.model.Item;

import java.util.Objects;

@Data
public class ItemDto {
    private Long id;
    private String serialNumber;
    private PlainCartDto plainCartDto;

    //Data Transfer object
    public static ItemDto from(Item item) {
        ItemDto itemDto=new ItemDto();
        itemDto.setId(itemDto.getId());
        itemDto.setSerialNumber(item.getSerialNumber());
        if(Objects.nonNull(item.getCart()))
        {
            itemDto.setPlainCartDto(PlainCartDto.from(item.getCart()));
        }

        return itemDto;
    }


}
