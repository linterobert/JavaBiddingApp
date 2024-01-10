package com.LinteRobert.springboot101.mappers;

import com.LinteRobert.springboot101.dtos.PostCreditCard;
import com.LinteRobert.springboot101.dtos.ReturnCreditCard;
import com.LinteRobert.springboot101.entities.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {
    public CreditCard postCreditCardToCreditCard(PostCreditCard postCreditCard) {
        return new CreditCard(postCreditCard.getCardNumber(), postCreditCard.getCvc(), postCreditCard.getExpiredDate());
    }

    public ReturnCreditCard creditCardToReturnCreditCard(CreditCard creditCard) {
        return new ReturnCreditCard(creditCard.getId(), creditCard.getCardNumber(), creditCard.getCvc(), creditCard.getExpiredDate(), creditCard.getUser().getId());
    }
}
