package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.controller.CustomerController;
import com.eazybytes.accounts.dto.LoansDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{
    private static final Logger logger = LoggerFactory.getLogger(LoansFallback.class);

    @Override
    public ResponseEntity<LoansDto> fetchLoansDetails(String mobileNumber, String corelationId) {
        logger.debug("Inside loans fallback");
        return null;
    }
}
