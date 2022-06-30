package ro.developmentfactory.myspringapi.model.dto;

import lombok.Data;
import ro.developmentfactory.myspringapi.model.Cart;
import ro.developmentfactory.myspringapi.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {
    private Long id;
    private String name;
    private List<ItemDto> itemDtos=new ArrayList<>();

    public static CartDto from(Cart cart)
    {
        CartDto cartDto=new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setName(cart.getName());
        cartDto.setItemDtos(cart.getItems().stream().map(ItemDto::from).collect(Collectors.toList()));
        return cartDto;
    }
}
