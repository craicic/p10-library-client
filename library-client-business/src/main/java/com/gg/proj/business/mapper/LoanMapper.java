package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.loans.Loan;
import com.gg.proj.consumer.wsdl.loans.LoanDetailed;
import com.gg.proj.model.LoanModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mappings({
            @Mapping(source = "book.id", target = "bookId"),
            @Mapping(source = "userId", target = "userId")
    })
    LoanModel loanDetailedToLoanModel(LoanDetailed ld);

    LoanModel loanToLoanModel(Loan loan);

    Loan loanModelToLoan(LoanModel loanModel);
}
