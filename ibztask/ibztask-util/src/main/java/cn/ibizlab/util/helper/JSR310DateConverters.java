package cn.ibizlab.util.helper;


import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.time.*;
import java.util.Date;

/**
 * <p>JSR310DateConverters class.</p>
 */
public final class JSR310DateConverters {

    private JSR310DateConverters() {
    }


    public static class TimestampToDateConverter implements Converter<Timestamp, Date> {

        public static final TimestampToDateConverter INSTANCE = new TimestampToDateConverter();

        private TimestampToDateConverter() {
        }

        @Override
        public Date convert(Timestamp source) {
            return source == null ? null : new Date(source.getTime());
        }
    }

    public static class DateToTimestampConverter implements Converter<Date, Timestamp> {

        public static final DateToTimestampConverter INSTANCE = new DateToTimestampConverter();

        private DateToTimestampConverter() {
        }

        @Override
        public Timestamp convert(Date source) {
            return source == null ? null : new Timestamp(source.getTime());
        }
    }

    public static class LocalDateToDateConverter implements Converter<LocalDate, Date> {

        public static final LocalDateToDateConverter INSTANCE = new LocalDateToDateConverter();

        private LocalDateToDateConverter() {
        }

        @Override
        public Date convert(LocalDate source) {
            return source == null ? null : Date.from(source.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }

    public static class DateToLocalDateConverter implements Converter<Date, LocalDate> {

        public static final DateToLocalDateConverter INSTANCE = new DateToLocalDateConverter();

        private DateToLocalDateConverter() {
        }

        @Override
        public LocalDate convert(Date source) {
            return source == null ? null : ZonedDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault())
                .toLocalDate();
        }
    }

    public static class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date> {

        public static final ZonedDateTimeToDateConverter INSTANCE = new ZonedDateTimeToDateConverter();

        private ZonedDateTimeToDateConverter() {
        }

        @Override
        public Date convert(ZonedDateTime source) {
            return source == null ? null : Date.from(source.toInstant());
        }
    }

    public static class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {

        public static final DateToZonedDateTimeConverter INSTANCE = new DateToZonedDateTimeConverter();

        private DateToZonedDateTimeConverter() {
        }

        @Override
        public ZonedDateTime convert(Date source) {
            return source == null ? null : ZonedDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        }
    }

    public static class LocalDateTimeToDateConverter implements Converter<LocalDateTime, Date> {

        public static final LocalDateTimeToDateConverter INSTANCE = new LocalDateTimeToDateConverter();

        private LocalDateTimeToDateConverter() {
        }

        @Override
        public Date convert(LocalDateTime source) {
            return source == null ? null : Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
        }
    }

    public static class DateToLocalDateTimeConverter implements Converter<Date, LocalDateTime> {

        public static final DateToLocalDateTimeConverter INSTANCE = new DateToLocalDateTimeConverter();

        private DateToLocalDateTimeConverter() {
        }

        @Override
        public LocalDateTime convert(Date source) {
            return source == null ? null : LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        }
    }

    public static class DurationToLongConverter implements Converter<Duration, Long> {

        public static final DurationToLongConverter INSTANCE = new DurationToLongConverter();

        private DurationToLongConverter() {
        }

        @Override
        public Long convert(Duration source) {
            return source == null ? null : source.toNanos();
        }
    }

    public static class LongToDurationConverter implements Converter<Long, Duration> {

        public static final LongToDurationConverter INSTANCE = new LongToDurationConverter();

        private LongToDurationConverter() {
        }

        @Override
        public Duration convert(Long source) {
            return source == null ? null : Duration.ofNanos(source);
        }
    }
}