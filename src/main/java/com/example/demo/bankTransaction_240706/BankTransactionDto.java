package com.example.demo.bankTransaction_240706;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class BankTransactionDto {
    private long depositTotal;
    private List<BankTransaction> sortedBankTransaction;

    public BankTransactionDto(long depositTotal) {
        this.depositTotal = depositTotal;
    }

    public BankTransactionDto(List<BankTransaction> sortedBankTransaction) {
        this.sortedBankTransaction = sortedBankTransaction;
    }
}
