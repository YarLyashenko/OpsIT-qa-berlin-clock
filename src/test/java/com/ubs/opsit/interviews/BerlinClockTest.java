package com.ubs.opsit.interviews;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class BerlinClockTest {

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTime() {
        String time = "13:12:11";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nO\r\nRROO\r\nRRRO\r\nYYOOOOOOOOO\r\nYYOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeMidnight() {
        String time = "00:00:00";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nY\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeNextMidnight() {
        String time = "24:00:00";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nY\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeSecondAfterMidnight() {
        String time = "00:00:01";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nO\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeMorning() {
        String time = "07:55:50";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nY\r\nROOO\r\nRROO\r\nYYRYYRYYRYY\r\nOOOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeNoon() {
        String time = "12:00:00";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nY\r\nRROO\r\nRROO\r\nOOOOOOOOOOO\r\nOOOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeEvening() {
        String time = "19:31:21";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nO\r\nRRRO\r\nRRRR\r\nYYRYYROOOOO\r\nYOOO", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeSecondBeforeMidnight() {
        String time = "23:59:59";
        assertEquals("Berlin clock return wrong results for time " + time,
                "\r\nO\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY", new BerlinClock().convertTime(time));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeNegative() {
        assertNull("Berlin clock does not return null for wrong argument", new BerlinClock().convertTime("13:12"));
    }

    /**
     * Method: convertTime(String aTime)
     */
    @Test
    public void testConvertTimeNull() {
        assertNull("Berlin clock does not return null for null argument", new BerlinClock().convertTime(null));
    }

    /**
     * Method: getFormattedTime(String time)
     */
    @Test
    public void testGetFormattedTime() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getFormattedTime", String.class);
            method.setAccessible(true);
            assertEquals("\r\nY\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO", method.invoke(clock, "24:00:00"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }

    /**
     * Method: getHoursFirstRowLamps(String inputHours)
     */
    @Test
    public void testGetHoursFirstRowLamps() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getHoursFirstRowLamps", String.class);
            method.setAccessible(true);
            assertEquals("RRRR", method.invoke(clock, "24"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }

    /**
     * Method: getHoursSecondRowLamps(String inputHours)
     */
    @Test
    public void testGetHoursSecondRowLamps() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getHoursSecondRowLamps", String.class);
            method.setAccessible(true);
            assertEquals("RRRR", method.invoke(clock, "24"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }

    /**
     * Method: getMinutesFirstRowLamps(String inputMinutes)
     */
    @Test
    public void testGetMinutesFirstRowLamps() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getMinutesFirstRowLamps", String.class);
            method.setAccessible(true);
            assertEquals("YYRYOOOOOOO", method.invoke(clock, "24"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }

    /**
     * Method: getMinutesSecondRowLamps(String inputMinutes)
     */
    @Test
    public void testGetMinutesSecondRowLamps() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getMinutesSecondRowLamps", String.class);
            method.setAccessible(true);
            assertEquals("YOOO", method.invoke(clock, "21"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }

    /**
     * Method: getRowLamps(int numberOfLampsEnabled, int numberOfLampsInRow, String colorOfEnabledLamp)
     */
    @Test
    public void testGetRowLamps() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getRowLamps", int.class, int.class, String.class);
            method.setAccessible(true);
            assertEquals("YOOO", method.invoke(clock, 1, 4, "Y"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }

    /**
     * Method: getSecondsLamp(String seconds)
     */
    @Test
    public void testGetSecondsLamp() {
        try {
            BerlinClock clock = new BerlinClock();
            Method method = clock.getClass().getDeclaredMethod("getSecondsLamp", String.class);
            method.setAccessible(true);
            assertEquals("O", method.invoke(clock, "21"));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            fail(e.getClass().toString() + "\r\n" + e.getMessage());
        }
    }
}
