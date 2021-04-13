package com.github.dromanenko.swpractice.stage5.meduzaservice;

import org.osgi.service.component.annotations.Component;

import com.github.dromanenko.swpractice.stage5.baseservice.NewsService;
import com.github.dromanenko.swpractice.stage5.baseservice.BaseNewsService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPInputStream;

@Component(service=NewsService.class)
public class MeduzaNewsService extends BaseNewsService implements NewsService {
    private static final String API_URL = "https://meduza.io/api/v3/search?chrono=news&locale=ru&page=0&per_page=24";

    public static List<String> getTittlesFromURL(String URL) throws IOException {
        List<String> titles = new ArrayList<>();
        InputStreamReader reader = new InputStreamReader(new GZIPInputStream(downloadJSON(URL)));
        DataMeduza data = gson.fromJson(Objects.requireNonNull(reader), DataMeduza.class);
        data.documents.forEach((unused, value) -> titles.add(value.title));
        return titles;
    }

    @Override
    public List<String> parse() throws IOException {
        return getTittlesFromURL(API_URL);
    }

    @Override
    public String getAPIName() {
        return "Meduza";
    }
}
