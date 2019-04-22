package com.gg.proj.business;

import com.gg.proj.business.mapper.BookMapper;
import com.gg.proj.business.mapper.LoanMapper;
import com.gg.proj.consumer.LoanConsumer;
import com.gg.proj.consumer.wsdl.loans.FindAllLoansByUserIdResponse;
import com.gg.proj.consumer.wsdl.loans.Loan;
import com.gg.proj.consumer.wsdl.loans.LoanDetailed;
import com.gg.proj.model.LoanModel;
import com.gg.proj.model.complex.LoanResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 *
 * Business class, its role is to call the mapper to map objects
 */
@Component
public class LoanManager {

    private static final Logger log = LoggerFactory.getLogger(LoanManager.class);
    private LoanMapper loanMapper;
    private BookMapper bookMapper;
    private LoanConsumer loanConsumer;

    @Autowired
    public LoanManager(LoanMapper loanMapper, BookMapper bookMapper, LoanConsumer loanConsumer) {
        this.loanMapper = loanMapper;
        this.bookMapper = bookMapper;
        this.loanConsumer = loanConsumer;
    }

    public List<LoanResultModel> getMyCurrentLoans(Integer userId, UUID tokenUUID) {
        FindAllLoansByUserIdResponse response = loanConsumer.findMyCurrentLoans(userId, tokenUUID.toString());

        List<LoanDetailed> loanDetailedList = response.getLoansDetailed();
        List<LoanResultModel> loanResultModelList = new ArrayList<>();

        for (LoanDetailed ld : loanDetailedList) {
            LoanResultModel resultModel = new LoanResultModel();
            resultModel.setBookMinModel(bookMapper.bookToBookMinModel(ld.getBook()));
            resultModel.setLoanModel(loanMapper.loanDetailedToLoanModel(ld));
            loanResultModelList.add(resultModel);
//            ld.getBook().getId();
//            LoanModel model = new LoanModel();
//            model.setBookId
        }

        return loanResultModelList;
    }

    public void extendMyLoan(int loanId, String endDate, Integer userId, UUID tokenUUID) {
        Loan loan = loanConsumer.findById(loanId, tokenUUID.toString());
        LoanModel loanModel = loanMapper.loanToLoanModel(loan);
        log.debug("date : " + endDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        if (endDate != null && !endDate.equals("")) {
            LocalDate localEndDate = LocalDate.parse(endDate, formatter);
            log.debug("localDate : " + localEndDate.toString());

            loanModel.setLoanEndDate(localEndDate);

        }

        loanConsumer.extend(loanMapper.loanModelToLoan(loanModel),tokenUUID.toString());
    }
}
