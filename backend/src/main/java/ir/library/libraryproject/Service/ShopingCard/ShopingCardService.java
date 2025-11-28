package ir.library.libraryproject.Service.ShopingCard;

import ir.library.libraryproject.dto.request.ShopingCardRequest;
import ir.library.libraryproject.dto.response.ShopingCardResponse;

public interface ShopingCardService {

    ShopingCardResponse addShopingCard(ShopingCardRequest shopingCardRequest);

}
