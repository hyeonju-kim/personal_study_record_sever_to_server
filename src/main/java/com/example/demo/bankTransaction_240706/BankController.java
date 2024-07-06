package com.example.demo.bankTransaction_240706;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BankController {
    private final BankService bankService;

    // 10분마다 history.csv 파일 읽어 RestTemplate 으로 localhost:8080으로 쏘기
    @Scheduled(fixedRate = 60000) // 10분마다 실행 (600,000ms)
    public void sendFileData() throws IOException {
        bankService.uploadDepositTotalToDB();
    }

    // 10분마다 history.csv 파일 읽어 RestTemplate 으로 localhost:8080으로 쏘기
    @Scheduled(fixedRate = 60000) // 10분마다 실행 (600,000ms)
    public void uploadSortedListToDB() throws IOException {
        bankService.uploadSortedListToDB();
    }
}
