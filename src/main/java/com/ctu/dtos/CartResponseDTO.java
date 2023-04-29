package com.ctu.dtos;

import java.util.ArrayList;
import java.util.List;

import com.ctu.model.Cart;

public class CartResponseDTO {
    private Long cartTotal;
    private Double cartPrice;
    private List<ProductResponseDTO> cartDetails = new ArrayList<ProductResponseDTO>();
    
                
    public CartResponseDTO(){}

    public CartResponseDTO(Cart cart) {
        this.cartTotal = cart.getCartTotal();
        this.cartPrice = cart.getCartPrice();
        cart.getCartDetails().forEach((e) -> this.cartDetails.add(new ProductResponseDTO(e)));
    }

    public Long getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Long cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public List<ProductResponseDTO> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<ProductResponseDTO> cartDetails) {
        this.cartDetails = cartDetails;
    }

}
