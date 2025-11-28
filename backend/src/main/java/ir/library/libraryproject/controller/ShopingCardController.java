package ir.library.libraryproject.controller;

import ir.library.libraryproject.Service.ShopingCard.ShopingCardService;
import ir.library.libraryproject.dto.request.ShopingCardRequest;
import ir.library.libraryproject.dto.response.ShopingCardResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopingCard")
public class ShopingCardController {

    private final ShopingCardService shopingCardService;

    public ShopingCardController(ShopingCardService shopingCardService) {
        this.shopingCardService = shopingCardService;
    }

    @PostMapping
    public ResponseEntity<ShopingCardResponse> addBook(@RequestBody @Valid ShopingCardRequest shopingCardRequest){
        return ResponseEntity.ok(shopingCardService.addShopingCard(shopingCardRequest));
    }

}
