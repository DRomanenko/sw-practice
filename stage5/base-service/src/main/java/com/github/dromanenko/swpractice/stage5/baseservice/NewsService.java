package com.github.dromanenko.swpractice.stage5.baseservice;

import java.io.IOException;
import java.util.List;

public interface NewsService {
    List<String> parse() throws IOException;
    String getAPIName();
}
