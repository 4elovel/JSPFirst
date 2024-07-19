package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuoteService {

    private final List<Quote> quotes;

    public QuoteService() {
        quotes = new ArrayList<>();
        // Додати початкові цитати
        quotes.add(new Quote(1,
                "Освіта - це найпотужніша зброя, яку ви можете використовувати для зміни світу.",
                "Нельсон Мандела", "Освіта"));
        quotes.add(new Quote(2, "Єдиний шлях до великого успіху - це любити те, що ви робите.",
                "Стів Джобс", "Особистий розвиток"));
        quotes.add(new Quote(3, "Мир починається з усмішки.", "Мати Тереза", "Відносини"));
        quotes.add(new Quote(4, "Історія повторюється: перший раз як трагедія, другий як фарс.",
                "Карл Маркс", "Історія"));
    }

    public List<Quote> getAllQuotes() {
        return quotes;
    }

    public List<Quote> getQuotesByCategory(String category) {
        return quotes.stream().filter(q -> q.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Quote> searchQuotesByKeyword(String keyword) {
        return quotes.stream().filter(q -> q.getText().contains(keyword))
                .collect(Collectors.toList());
    }

    public void addQuote(String text, String author, String category) {
        int id = quotes.size() + 1;
        quotes.add(new Quote(id, text, author, category));
    }

    public void editQuote(int id, String text, String author, String category) {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setText(text);
                quote.setAuthor(author);
                quote.setCategory(category);
                break;
            }
        }
    }

    public void deleteQuote(int id) {
        quotes.removeIf(q -> q.getId() == id);
    }

    public Quote getRandomQuote() {
        Random rand = new Random();
        return quotes.get(rand.nextInt(quotes.size()));
    }
}
