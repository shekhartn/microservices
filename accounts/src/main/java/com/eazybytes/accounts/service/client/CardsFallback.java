package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    private static final Logger logger = LoggerFactory.getLogger(CardsFallback.class);

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String mobileNumber, String correlationId) {
        logger.debug("Inside cards fallback");
        return null;
    }

}