package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.Cart;
import com.jeffsimonitto.spring.springbootplayground.entities.CartItem;
import com.jeffsimonitto.spring.springbootplayground.entities.Item;
import com.jeffsimonitto.spring.springbootplayground.repositories.CartRepository;
import com.jeffsimonitto.spring.springbootplayground.repositories.ItemRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    public InventoryService(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> getCart(String cartId) {
        return this.cartRepository.findById(cartId);
    }

    public Iterable<Item> getInventory() {
        return this.itemRepository.findAll();
    }

    public Item saveItem(Item newItem) {
        return this.itemRepository.save(newItem);
    }

    public void deleteItem(Integer id) {
        this.itemRepository.deleteById(id);
    }

    public Cart addItemToCart(String cartId, Integer itemId) {
        Cart cart = this.cartRepository.findById(cartId)
                .orElseGet(() -> new Cart("My Cart"));

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

    public Cart removeOneFromCart(String cartId, Integer itemId) {
        Cart cart = this.cartRepository.findById(cartId)
                .orElseGet(() -> new Cart("My Cart"));

        cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getItem().getId().equals(itemId))
                .findAny()
                .ifPresent(CartItem::decrement);

        cart.getCartItems().removeIf(cartItem -> cartItem.getQuantity() <= 0);
        return this.cartRepository.save(cart);
    }

    public Iterable<Item> searchByExample(String name, String description, boolean useAnd) {
        Item item = new Item(name, description, 0.0);

        ExampleMatcher matcher = (useAnd
            ? ExampleMatcher.matchingAll()
            : ExampleMatcher.matchingAny())
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnorePaths("price");
        Example<Item> probe = Example.of(item, matcher);
        return itemRepository.findAll(probe);
    }
}
