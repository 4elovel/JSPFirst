package org.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.example.Model.Quote;
import org.example.Model.QuoteService;


public class QuoteController extends HttpServlet {

    private QuoteService quoteService;

    @Override
    public void init() throws ServletException {
        super.init();
        quoteService = new QuoteService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String category = request.getParameter("category");
        String keyword = request.getParameter("keyword");

        List<Quote> quotesToShow;

        if (category != null) {
            quotesToShow = quoteService.getQuotesByCategory(category);
        } else if (keyword != null) {
            quotesToShow = quoteService.searchQuotesByKeyword(keyword);
        } else {
            quotesToShow = quoteService.getAllQuotes();
        }

        Quote randomQuote = quoteService.getRandomQuote();
        request.setAttribute("randomQuote", randomQuote);
        request.setAttribute("quotes", quotesToShow);
        request.getRequestDispatcher("/quotes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String quoteText = request.getParameter("quoteText");
        String quoteAuthor = request.getParameter("quoteAuthor");
        String quoteCategory = request.getParameter("quoteCategory");
        String quoteId = request.getParameter("quoteId");

        if ("add".equals(action) && quoteText != null && quoteAuthor != null
                && quoteCategory != null) {
            quoteService.addQuote(quoteText, quoteAuthor, quoteCategory);
        } else if ("edit".equals(action) && quoteId != null && quoteText != null
                && quoteAuthor != null && quoteCategory != null) {
            quoteService.editQuote(Integer.parseInt(quoteId), quoteText, quoteAuthor,
                    quoteCategory);
        } else if ("delete".equals(action) && quoteId != null) {
            quoteService.deleteQuote(Integer.parseInt(quoteId));
        }

        response.sendRedirect("quotes");
    }
}
