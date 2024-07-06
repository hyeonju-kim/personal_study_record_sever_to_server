package com.example.demo.bankTransaction_240706;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  RestTemplate 을 사용하여 특정 URL로 원하는 데이터를 전송하는 로직
 */
@Service
@RequiredArgsConstructor
public class BankService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String TOTAL_DEPOSIT_URL = "http://localhost:8080/bank/deposit/total/upload";
    private static final String SORTED_USE_CODE_URL = "http://localhost:8080/bank/useCode/sort/upload";

    // 1. 전체 입출금액의 total을 전송
    public void uploadDepositTotalToDB() throws IOException {
        List<BankTransaction> transactions = FileService.convertToBT();

        long totalDeposit = 0;
        for (BankTransaction transaction : transactions) {
            totalDeposit += transaction.getDeposit();
        }
        // 특정 URL로 BankTransactionDto 전송 🎯
        restTemplate.postForObject(TOTAL_DEPOSIT_URL, new BankTransactionDto(totalDeposit), BankTransactionDto.class);
        System.out.println(new BankTransactionDto(totalDeposit));
    }

    // 2. 사용구분코드(A1, A2, A3) 순으로 정렬된 리스트 전송
    public void uploadSortedListToDB() throws IOException {
        List<BankTransaction> transactions = FileService.convertToBT();

        Collections.sort(transactions, new Comparator<BankTransaction>() {
            @Override
            public int compare(BankTransaction o1, BankTransaction o2) {
                return o1.getUseCode().compareTo(o2.getUseCode());
            }
        });
        // 특정 URL로 BankTransactionDto 전송 🎯
        restTemplate.postForObject(SORTED_USE_CODE_URL, new BankTransactionDto(transactions), BankTransactionDto.class);
        System.out.println(new BankTransactionDto(transactions));
    }
}
