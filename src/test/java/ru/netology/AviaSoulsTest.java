package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    AviaSouls avia = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", "Калининград", 3_000, 12, 15);
    Ticket ticket2 = new Ticket("Санкт-Петербург", "Калининград", 7_500, 8, 13);
    Ticket ticket3 = new Ticket("Москва", "Калининград", 22_000, 9, 14);
    Ticket ticket4 = new Ticket("Томск", "Калининград", 21_250, 7, 16);
    Ticket ticket5 = new Ticket("Москва", "Калининград", 7_500, 21, 22);
    Ticket ticket6 = new Ticket("Новосибирск", "Астана", 14_600, 12, 20);

    @BeforeEach
    public void setup() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

    }


    @Test

    public void whenThePriceOfTheSecondTicketIsLess() {


        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenThePriceOfTheSecondTicketIsLMore() {

        int expected = 1;
        int actual = ticket4.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenThePriceIsZero() {


        int expected = 0;
        int actual = ticket2.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SortTicketsByPriceZeroResult() {


        Ticket[] expected = {};
        Ticket[] actual = avia.search("Москва", "Астана");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortResponseArrayInSearchWithOneResult() {

        Ticket[] expected = {ticket4};
        Ticket[] actual = avia.search("Томск", "Калининград");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void SortTicketsByPriceSeveralTickets() {

        Ticket[] expected = {ticket1, ticket5, ticket3};
        Ticket[] actual = avia.search("Москва", "Калининград");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void travelTimeTest() {
        Ticket ticket = new Ticket("Москва", "Калининград", 3_000, 12, 15);

        int expected = 3;
        int actual = ticket.travelTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testingСomparatorWhenTheFlightTimeIsLonger() {
        TicketTimeComparator<Ticket> comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingСomparatorWhenTimeIsEqual() {
        TicketTimeComparator<Ticket> comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(ticket3, ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testingСomparatorWhenTimeIsLess() {
        TicketTimeComparator<Ticket> comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(ticket2, ticket5);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchAndSortByTime() {
        TicketTimeComparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket1, ticket3};
        Ticket[] actual = avia.searchAndSortBy("Москва", "Калининград", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }


}
