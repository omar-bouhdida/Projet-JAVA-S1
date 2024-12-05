package com.library.service;

import com.library.model.Loan;
import com.library.repository.LoanRepository;
import java.util.List;

public class LoanService {
    private final LoanRepository loanRepository = new LoanRepository();

    public void save(Loan loan) {
        loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.getAllLoans();
    }
}
