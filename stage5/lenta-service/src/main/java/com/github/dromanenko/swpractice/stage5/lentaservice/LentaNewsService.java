package com.github.dromanenko.swpractice.stage5.lentaservice;

import org.osgi.service.component.annotations.Component;

import com.github.dromanenko.swpractice.stage5.baseservice.BaseNewsService;
import com.github.dromanenko.swpractice.stage5.baseservice.NewsService;

import java.io.IOException;
import java.util.List;

@Component(service=NewsService.class)
public class LentaNewsService extends BaseNewsService implements NewsService {
    private static final String API_URL = "https://lenta.ru/rss/top7";
    private static final String RSS_TO_JSON_API = "https://feed2json.org/convert?url=";

    @Override
    public List<String> parse() throws IOException {
        return getTittlesFromURL(RSS_TO_JSON_API + API_URL);
    }

    @Override
    public String getAPIName() {
        return "Lenta";
    }
}
