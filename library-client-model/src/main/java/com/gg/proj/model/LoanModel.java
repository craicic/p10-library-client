package com.gg.proj.model;

import java.time.LocalDate;
import java.util.Objects;

public class LoanModel {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private boolean extended;
    private boolean closed;

    public LoanModel() {
    }

    public LoanModel(Integer id, Integer userId, Integer bookId, LocalDate loanStartDate, LocalDate loanEndDate, boolean extended, boolean closed) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.extended = extended;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public LocalDate getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(LocalDate loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "LoanModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", loanStartDate=" + loanStartDate +
                ", loanEndDate=" + loanEndDate +
                ", extended=" + extended +
                ", closed=" + closed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanModel loanModel = (LoanModel) o;
        return extended == loanModel.extended &&
                closed == loanModel.closed &&
                userId.equals(loanModel.userId) &&
                bookId.equals(loanModel.bookId) &&
                loanStartDate.equals(loanModel.loanStartDate) &&
                loanEndDate.equals(loanModel.loanEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId, loanStartDate, loanEndDate, extended, closed);
    }
}
