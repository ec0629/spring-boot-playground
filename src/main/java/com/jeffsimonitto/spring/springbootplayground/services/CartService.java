package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.Cart;
import com.jeffsimonitto.spring.springbootplayground.entities.CartItem;
import com.jeffsimonitto.spring.springbootplayground.entities.Item;
import com.jeffsimonitto.spring.springbootplayground.repositories.CartRepository;
import com.jeffsimonitto.spring.springbootplayground.repositories.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    public CartService(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(String cartId, Integer itemId) {
        Cart cart = this.cartRepository.findById(cartId)
                .orElseGet(() -> new Cart(cartId));

        cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getItem().getId().equals(itemId))
                .findAny()
                .map(cartItem -> {
                    cartItem.increment();
                    return cart;
                })
                .orElseGet(() -> {
                    Item item = this.itemRepository.findById(itemId)
                            .orElseThrow(() -> new IllegalStateException("Can't seem to find Item type " + itemId));
                    cart.getCartItems().add(new CartItem(item, cart));
                    return cart;
                });
        return this.cartRepository.save(cart);
    }
}
