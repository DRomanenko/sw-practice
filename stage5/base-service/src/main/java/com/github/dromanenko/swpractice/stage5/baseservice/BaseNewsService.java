package com.github.dromanenko.swpractice.stage5.baseservice;

import com.google.gson.Gson;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class BaseNewsService {
    protected static final Gson gson = new Gson();

    protected static InputStream downloadJSON(final String URL) throws IOException {
        return new URL(URL).openStream();
    }

    protected static List<String> getTittlesFromURL(final String URL) throws IOException {
        InputStreamReader reader = new InputStreamReader(downloadJSON(URL));
        Data data = gson.fromJson(reader, Data.class);
        List<String> titles = new ArrayList<>();
        data.items.forEach(value -> titles.add(value.title));
        return titles;
    }
}
