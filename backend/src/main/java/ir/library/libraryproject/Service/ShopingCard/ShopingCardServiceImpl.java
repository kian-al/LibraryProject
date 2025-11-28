package ir.library.libraryproject.Service.ShopingCard;

import ir.library.libraryproject.Model.*;
import ir.library.libraryproject.dto.request.ShopingCardRequest;
import ir.library.libraryproject.dto.response.ShopingCardResponse;
import ir.library.libraryproject.exception.RuleException;
import ir.library.libraryproject.repository.BookRepository;
import ir.library.libraryproject.repository.FactorRepository;
import ir.library.libraryproject.repository.ShopingCardRepository;
import ir.library.libraryproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShopingCardServiceImpl implements ShopingCardService {

    private final ShopingCardRepository shopingCardRepository;
    private final FactorRepository factorRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ShopingCardServiceImpl(ShopingCardRepository shopingCardRepository, FactorRepository factorRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.shopingCardRepository = shopingCardRepository;
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public ShopingCardResponse addShopingCard(ShopingCardRequest shopingCardRequest) {
        User user = userRepository.findById(shopingCardRequest.getUserId())
                .orElseThrow(() -> new RuleException("user.not.exist"));
        Book book = bookRepository.findById(shopingCardRequest.getBookId())
                .orElseThrow(() -> new RuleException("Book.not.found"));
        Optional<Factor> factorById = factorRepository.findByUserAndPayed(user, Payed.UNPAYED);
        Factor factor;
        factor = factorById.orElseGet(() -> createFactor(user));
        factorRepository.save(factor);
        ShopingCard shopingCard = createShopingCard(shopingCardRequest,book,factor);
        return createShopingCardResponse(shopingCardRepository.save(shopingCard));

    }

    private ShopingCardResponse createShopingCardResponse(ShopingCard shopingCard) {
        return ShopingCardResponse.builder()
                .shopingCard(shopingCard.getId())
                .factorId(shopingCard.getFactor().getId())
                .build();
    }

    private Factor createFactor(User user) {
        return Factor.builder()
                .user(user)
                .payed(Payed.UNPAYED)
                .build();
    }

    private ShopingCard createShopingCard(ShopingCardRequest shopingCardRequest, Book book, Factor factor) {
        return ShopingCard.builder()
                .book(book)
                .factor(factor)
                .count(shopingCardRequest.getCount())
                .build();
    }
}

