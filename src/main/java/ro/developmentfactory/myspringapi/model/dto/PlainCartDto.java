package ro.developmentfactory.myspringapi.model.dto;

import lombok.Data;
import ro.developmentfactory.myspringapi.model.Cart;

@Data
public class PlainCartDto {
    private Long id;
    private String name;

    public static PlainCartDto from(Cart cart)
    {
        PlainCartDto plainCartDto=new PlainCartDto();
        plainCartDto.setId(cart.getId());
        plainCartDto.setName(cart.getName());
        return plainCartDto;
    }

}
