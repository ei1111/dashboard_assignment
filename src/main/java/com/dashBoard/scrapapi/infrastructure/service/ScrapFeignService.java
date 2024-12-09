package com.dashBoard.scrapapi.infrastructure.service;


import com.dashBoard.scrapapi.infrastructure.domain.ScrapData;
import com.dashBoard.scrapapi.feigntest.ScrapClient;
import com.dashBoard.scrapapi.request.ApiRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class ScrapFeignService {
    private final ScrapClient scrapClient;
    public ScrapData scrapingToApi(ApiRequestDto apiRequestDto) {
        Map<String, Object> scraping = (Map)scrapClient.scraping(apiRequestDto);
        return new ScrapData();
    }
}
