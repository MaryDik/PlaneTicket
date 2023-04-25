package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator<T> implements Comparator<Ticket> {


    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.travelTime() < t2.travelTime()) {
            return -1;
        } else if (t1.travelTime() > t2.travelTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}



