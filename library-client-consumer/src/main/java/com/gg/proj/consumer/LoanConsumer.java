package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.LoanConnector;
import com.gg.proj.consumer.wsdl.loans.FindAllLoansByUserIdResponse;
import com.gg.proj.consumer.wsdl.loans.GetLoanResponse;
import com.gg.proj.consumer.wsdl.loans.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Consumer class, it call the connector
 */
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

    public Loan findById(int loanId, String tokenUUID) {
        return loanConnector.findById(loanId, tokenUUID).getLoan();
    }

    public void extend(Loan loan, String tokenUUID) {
        loanConnector.extend(loan, tokenUUID);
    }
}
