package com.codecool.science;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScienceJournalTest {

    @Test
    void testScienceJournalSizeWorks() {
        ScienceJournal journal = new ScienceJournal();
        assertThat(journal.size()).isZero();
        journal.add(new Article("author", "title", 1999));
        assertThat(journal.size()).isEqualTo(1);
        journal.add(new Article("author B", "title", 1999));
        assertThat(journal.size()).isEqualTo(2);
    }

    @Test
    void testScienceJournalFindsArticlesByAuthor() {
        ScienceJournal journal = new ScienceJournal();
        journal.add(new Article("author Y", "title B", 1999));
        journal.add(new Article("author", "title A", 1999));
        journal.add(new Article("author", "title D", 1999));
        journal.add(new Article("author", "title C", 1999));
        journal.add(new Article("author", "title B", 1999));
        journal.add(new Article("author X", "title B", 1999));
        List<Article> articles = journal.findByAuthor("author");
        assertThat(articles).hasSize(4);
    }

    @Test
    void testScienceJournalFindsArticlesByAuthorInCorrectOrder() {
        ScienceJournal journal = new ScienceJournal();
        journal.add(new Article("author Y", "title B", 1999));
        journal.add(new Article("author", "title A", 1999));
        journal.add(new Article("author", "title D", 1999));
        journal.add(new Article("author", "title C", 1999));
        journal.add(new Article("author", "title B", 1999));
        journal.add(new Article("author X", "title B", 1999));
        List<Article> articles = journal.findByAuthor("author");
        assertThat(articles).hasSize(4);
        assertThat(articles.stream().map(Article::getTitle)).isSorted();

        journal.add(new Article("author Y", "title B", 2022));
        journal.add(new Article("author", "title A2", 1999));
        journal.add(new Article("author", "title D", 2019));
        journal.add(new Article("author", "title C", 2003));
        journal.add(new Article("author", "title B", 2001));
        journal.add(new Article("author X", "title B", 1997));
        List<Article> articles2 = journal.findByAuthor("author");
        assertThat(articles2).hasSize(8);
        assertThat(articles2.stream().map(Article::getYear)).isSorted();
        assertThat(articles2.stream().map(Article::getAuthor)).containsAnyOf("author");
    }

    @Test
    void testScienceJournalFindsArticlesByAuthorAndYear() {
        ScienceJournal journal = new ScienceJournal();
        journal.add(new Article("author Y", "title B", 1999));
        journal.add(new Article("author", "title A", 1999));
        journal.add(new Article("author", "title D", 1999));
        journal.add(new Article("author", "title C", 1999));
        journal.add(new Article("author", "title B", 1999));
        journal.add(new Article("author X", "title B", 1999));
        journal.add(new Article("author Y", "title B", 2022));
        journal.add(new Article("author", "title A2", 1999));
        journal.add(new Article("author", "title D", 2019));
        journal.add(new Article("author", "title C", 2003));
        journal.add(new Article("author", "title B", 2001));
        journal.add(new Article("author X", "title B", 1997));
        List<Article> articles = journal.findByAuthorAndYear("author", 1999);
        assertThat(articles).hasSize(5);
        assertThat(articles
                .stream()
                .map(Article::getTitle)
        ).containsExactlyInAnyOrder("title A", "title A2", "title B", "title C", "title D");
    }

    @Test
    void testScienceJournalFindsArticlesByAuthorAndYearInOrder() {
        ScienceJournal journal = new ScienceJournal();
        journal.add(new Article("author Y", "title B", 1999));
        journal.add(new Article("author", "title A", 1999));
        journal.add(new Article("author", "title D", 1999));
        journal.add(new Article("author", "title C", 1999));
        journal.add(new Article("author", "title B", 1999));
        journal.add(new Article("author X", "title B", 1999));
        journal.add(new Article("author Y", "title B", 2022));
        journal.add(new Article("author", "title A2", 1999));
        journal.add(new Article("author", "title D", 2019));
        journal.add(new Article("author", "title C", 2003));
        journal.add(new Article("author", "title B", 2001));
        journal.add(new Article("author X", "title B", 1997));
        List<Article> articles = journal.findByAuthorAndYear("author", 1999);
        assertThat(articles).hasSize(5);
        assertThat(articles
                .stream()
                .map(Article::getTitle)
        ).containsExactly("title A", "title A2", "title B", "title C", "title D");
    }

    @Test
    void testScienceJournalFindsArticlesByAuthorPart() {
        ScienceJournal journal = new ScienceJournal();
        journal.add(new Article("author Y", "title B", 1999));
        journal.add(new Article("author", "title A", 1999));
        journal.add(new Article("author", "title D", 1999));
        journal.add(new Article("author", "title C", 1999));
        journal.add(new Article("author", "title B", 1999));
        journal.add(new Article("author X", "title B", 1999));
        journal.add(new Article("author Y", "title B", 2022));
        journal.add(new Article("author", "title A2", 1999));
        journal.add(new Article("author", "title D", 2019));
        journal.add(new Article("author", "title C", 2003));
        journal.add(new Article("author", "title B", 2001));
        journal.add(new Article("author X", "title B", 1997));
        List<Article> articles = journal.findByAuthorLike("uthor X");
        assertThat(articles).hasSize(2);
    }
}