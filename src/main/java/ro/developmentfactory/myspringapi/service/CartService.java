package ro.developmentfactory.myspringapi.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.developmentfactory.myspringapi.model.Cart;
import ro.developmentfactory.myspringapi.model.Item;
import ro.developmentfactory.myspringapi.model.exception.CartNotFoundException;
import ro.developmentfactory.myspringapi.model.exception.ItemsIsAlreadyAssignedException;
import ro.developmentfactory.myspringapi.repository.ICartRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Service
public class CartService {
    private final ICartRepository cartRepository;
    private final ItemService itemService;

    public CartService(ICartRepository cartRepository, ItemService itemService) {
        this.cartRepository = cartRepository;
        this.itemService = itemService;
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCarts() {
        return StreamSupport
                .stream(cartRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
    }

    public Cart deleteCart(Long id) {
        Cart cart = getCart(id);
        cartRepository.delete(cart);
        return cart;
    }

    @Transactional
    public Cart editCart(Long id, Cart cart) {
        Cart cartToEdit = getCart(id);
        cartToEdit.setName(cart.getName());
        return cartToEdit;
    }

    @Transactional
    public Cart addItemToCart(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);
        if(Objects.nonNull(item.getCart()))
        {
            throw new ItemsIsAlreadyAssignedException(itemId,item.getCart().getId());
        }
        cart.addItem(item);
        item.setCart(cart);
        return cart;
    }

    @Transactional
    public Cart removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }


    public Cart getCartRepository(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }
}
