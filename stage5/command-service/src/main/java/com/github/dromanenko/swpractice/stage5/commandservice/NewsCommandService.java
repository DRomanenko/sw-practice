package com.github.dromanenko.swpractice.stage5.commandservice;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.github.dromanenko.swpractice.stage5.baseservice.NewsService;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Component(
        property = {
                "name=NewsService",
                "osgi.command.scope=news",
                "osgi.command.function=stats"
        },
        service = NewsCommand.class
)
public class NewsCommandService implements NewsCommand {
    private static final List<NewsService> REGISTERED_SOURCES = new ArrayList<>();
    private static final Set<String> IGNORED_WORDS = Set.of("не", "и", "а", "со", "это", "что",
            "в", "без", "до", "из", "к", "на", "по", "о", "от", "перед", "при",
            "через", "с", "у", "за", "над", "об", "под", "про", "для"
    );

    @Reference(cardinality = ReferenceCardinality.MULTIPLE, service = NewsService.class)
    public void registerSource(NewsService source) {
        REGISTERED_SOURCES.add(source);
    }

    private static void countWords(Map<String, Integer> wordCounter, List<String> titles, boolean ignoreWords) {
        titles.forEach(value -> Arrays.stream(value.toLowerCase().split("[^\\p{L}]+")).forEach(word -> {
            if (!word.isEmpty()) {
                if (!ignoreWords || !IGNORED_WORDS.contains(word)) {
                    if (wordCounter.containsKey(word)) {
                        wordCounter.put(word, wordCounter.get(word) + 1);
                    } else {
                        wordCounter.put(word, 1);
                    }
                }
            }
        }));
    }

    private static void printStats(Map<String, Integer> wordCounter) {
        wordCounter.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .forEach(System.out::println);
    }

    @Override
    public void stats(final String[] sources) {
        if (REGISTERED_SOURCES.size() == 0) {
            System.out.println("No source is registered!");
            return;
        }
        if (sources == null || sources.length != 1 || Arrays.stream(sources).allMatch(Objects::isNull)) {
            System.out.println("Registered sources:");
            AtomicInteger qty = new AtomicInteger(1);
            REGISTERED_SOURCES.forEach(parser -> System.out.println((qty.getAndIncrement()) + ". " + parser.getAPIName()));
            System.out.println("All");
            return;
        }
        String source = sources[0].toLowerCase();
        AtomicBoolean flag = new AtomicBoolean(false);
        REGISTERED_SOURCES.forEach(parser -> flag.set(flag.get() || parser.getAPIName().equals(source)));
        if (flag.get() && !("all").equals(source)) {
            System.out.println("Choose from registered sources!");
            return;
        }
        Map<String, Integer> wordCounter = new HashMap<>();
        REGISTERED_SOURCES.forEach(parser -> {
            if (source.equals("all") || parser.getAPIName().equalsIgnoreCase(source)) {
                try {
                    countWords(wordCounter, parser.parse(), true);
                    wordCounter.forEach((key, val) -> val = 0);
                } catch (IOException e) {
                    System.out.println("The " + parser.getAPIName() + " source couldn't be registered. The network is inaccessible.");
                }
            }
        });
        printStats(wordCounter);
    }
}
