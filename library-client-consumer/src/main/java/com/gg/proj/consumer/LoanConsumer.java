package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.BookConnector;
import com.gg.proj.consumer.connectors.LoanConnector;
import com.gg.proj.consumer.wsdl.loans.FindAllLoansByUserIdResponse;
import com.gg.proj.model.complex.LoanResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanConsumer {

    private static final Logger log = LoggerFactory.getLogger(LoanConsumer.class);

    private LoanConnector loanConnector;

    @Autowired
    public LoanConsumer(LoanConnector loanConnector) {
        this.loanConnector = loanConnector;
    }

    public FindAllLoansByUserIdResponse findMyCurrentLoans(Integer userId, String tokenUUID) {
        return loanConnector.findAllLoansByUserId(userId, tokenUUID);
    }

}
