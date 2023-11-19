package edu.project3;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Filter {
    private final Stream<Request> delegate;

    public Filter(List<Request> delegate) {
        this.delegate = delegate.stream();
    }

    public Stream<Request> minDate(LocalDate minDate) {
        if (minDate == null) {
            return delegate;
        }

        return delegate.filter(
            entry -> {
                LocalDate date = entry.dateTime().toLocalDate();
                return date.isAfter(minDate) || date.isEqual(minDate);
            }
        );
    }

    public Stream<Request> maxDate(LocalDate maxDate) {
        if (maxDate == null) {
            return delegate;
        }

        return delegate.filter(
            entry -> {
                LocalDate date = entry.dateTime().toLocalDate();
                return date.isBefore(maxDate) || date.isEqual(maxDate);
            }
        );
    }

    public Stream<Request> betweenDates(LocalDate minDate, LocalDate maxDate) {
        if (minDate == null) {
            return maxDate(maxDate);
        } else if (maxDate == null) {
            return minDate(minDate);
        }

        return delegate.filter(
            entry -> {
                LocalDate date = entry.dateTime().toLocalDate();
                return (date.isAfter(minDate) || date.isEqual(minDate))
                    && (date.isBefore(maxDate) || date.isEqual(maxDate));
            }
        );
    }
}
