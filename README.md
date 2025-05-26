package com.kmbl.cros.accountinquiryservice.utils;

import static com.kmbl.cros.accountinquiryservice.constants.AppConstants.GAM_DATE_TIME;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class CbsUtils {

    /**
     * Converts a ByteBuffer to a String using UTF-8 encoding.
     *
     * @param value The ByteBuffer to convert.
     * @return The converted String, or null if the input value was null.
     */
    public static String byteBufferToStr(ByteBuffer value) {
        if (value == null) {
            return null;
        }
        ByteBuffer duplicate = value.duplicate();
        return StandardCharsets.UTF_8.decode(duplicate).toString();
    }

    /**
     * Converts a Double to a BigDecimal with a scale of 4, rounded using HALF_UP mode.
     *
     * @param value The Double value to convert.
     * @return The converted BigDecimal, or null if the input value was null.
     */
    public static BigDecimal doubleToBigDecimal(Double value) {
        return value != null ? new BigDecimal(value).setScale(4, RoundingMode.HALF_UP) : null;
    }

    /**
     * Converts a Number object to a Long.
     *
     * @param value The Number object to convert.
     * @return The converted Long, or null if the input value was null or not a Number.
     */
    public static Long numberToLong(Object value) {
        return value != null ? ((Number) value).longValue() : null;
    }

    /**
     * Parses a CharSequence as a LocalDateTime using the GAM_DATE_TIME format.
     * Throws a DateTimeParseException if the input value cannot be parsed.
     *
     * @param value The CharSequence to parse.
     * @return The parsed LocalDateTime, or null if the input value was null.
     */
    public static LocalDateTime strToLocalDateTime(CharSequence value) {
        try {
            return LocalDateTime.parse(value.toString(), GAM_DATE_TIME);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Parses a String DateTime to date using the YYYY-MM-DDT00:HH:MM:SSS or YYYY-MM-DDT00:HH:MM format.
     * @param value The String to parse.
     * @return The parsed DateTime in String YYYY-MM-DDT00:HH:MM:SSS format, or null if the input value was null.
     */
    public static String strDateTimeToDate(String value) {
        try {
            String date = value.split("T")[0];
            return date + "T00:00:00.001";
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Converts an object to a String using its String representation.
     *
     * @param value The CharSequence to parse.
     * @return The converted String, or null if the input value was null.
     */
    public static String charSeqToStr(CharSequence value) {
        return value != null ? String.valueOf(value) : null;
    }
}
