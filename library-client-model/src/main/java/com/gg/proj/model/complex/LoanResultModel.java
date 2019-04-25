package com.gg.proj.model.complex;

import com.gg.proj.model.BookMinModel;
import com.gg.proj.model.LoanModel;

public class LoanResultModel {

    private LoanModel loanModel;
    private BookMinModel bookMinModel;

    public LoanResultModel() {
    }

    public LoanResultModel(LoanModel loanModel, BookMinModel bookMinModel) {
        this.loanModel = loanModel;
        this.bookMinModel = bookMinModel;
    }

    public LoanModel getLoanModel() {
        return loanModel;
    }

    public void setLoanModel(LoanModel loanModel) {
        this.loanModel = loanModel;
    }

    public BookMinModel getBookMinModel() {
        return bookMinModel;
    }

    public void setBookMinModel(BookMinModel bookMinModel) {
        this.bookMinModel = bookMinModel;
    }

    @Override
    public String toString() {
        return "LoanResultModel{" +
                "loanModel=" + loanModel +
                ", bookMinModel=" + bookMinModel +
                '}';
    }


}
