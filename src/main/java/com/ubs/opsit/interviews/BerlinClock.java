package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClock implements TimeConverter {
    private static final String YELLOW = "Y";
    private static final String OFF = "O";
    private static final String RED = "R";
    private static final Logger LOG = LoggerFactory.getLogger(BerlinClock.class);

    @Override
    public String convertTime(String aTime) {
        if (aTime.matches("([01][0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]")) {
            return getFormattedTime(aTime);
        } else {
            LOG.error("Time passed to BerlinClock is in wrong format. " +
                    "Should be string time started from 00:00:00 to 24:00:00.");
            return null;
        }
    }

    /**
     * Method which return composed string with lamps for all rows
     *
     * @param time in format 00:00:00
     * @return string with time formatted as Berlin clock
     */
    private String getFormattedTime(String time) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splittedTime = time.split(":");

        stringBuilder.append("\r\n");
        stringBuilder.append(getSecondsLamp(splittedTime[2]));
        stringBuilder.append("\r\n");
        stringBuilder.append(getHoursFirstRowLamps(splittedTime[0]));
        stringBuilder.append("\r\n");
        stringBuilder.append(getHoursSecondRowLamps(splittedTime[0]));
        stringBuilder.append("\r\n");
        stringBuilder.append(getMinutesFirstRowLamps(splittedTime[1]));
        stringBuilder.append("\r\n");
        stringBuilder.append(getMinutesSecondRowLamps(splittedTime[1]));
        return stringBuilder.toString();
    }

    /**
     * Method which return string with lamps for first hours row
     *
     * @param inputHours string with hours in 2 digits format
     * @return string with lamps for first row
     */
    private String getHoursFirstRowLamps(String inputHours) {
        return getRowLamps(Integer.parseInt(inputHours) / 5, 4, RED);
    }

    /**
     * Method which return string with lamps for second hours row
     *
     * @param inputHours string with hours in 2 digits format
     * @return string with lamps for second row
     */
    private String getHoursSecondRowLamps(String inputHours) {
        return getRowLamps(Integer.parseInt(inputHours) % 5, 4, RED);
    }

    /**
     * Method which return string with lamps for first minutes row
     *
     * @param inputMinutes string with minutes  in 2 digits format
     * @return string with lamps for first row
     */
    private String getMinutesFirstRowLamps(String inputMinutes) {
        return getRowLamps(Integer.parseInt(inputMinutes) / 5, 11, YELLOW);
    }

    /**
     * Method which return string with lamps for second minutes row
     *
     * @param inputMinutes string with minutes  in 2 digits format
     * @return string with lamps for second row
     */
    private String getMinutesSecondRowLamps(String inputMinutes) {
        return getRowLamps(Integer.parseInt(inputMinutes) % 5, 4, YELLOW);
    }

    /**
     * Method which return composed string with lamps enabled\disabled according to parameters
     *
     * @param numberOfLampsEnabled amount of enabled lamps in current row
     * @param numberOfLampsInRow   amount of lamps in current row
     * @param colorOfEnabledLamp   color of enabled lamps in current row
     * @return string with lamps
     */
    private String getRowLamps(int numberOfLampsEnabled, int numberOfLampsInRow, String colorOfEnabledLamp) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (numberOfLampsInRow) {
            case 11:
                for (int i = 1; i <= numberOfLampsEnabled; i++) {
                    if (0 == (i % 3)) {
                        stringBuilder.append(RED);
                    } else {
                        stringBuilder.append(colorOfEnabledLamp);
                    }
                }
                break;
            default:
                for (int i = 1; i <= numberOfLampsEnabled; i++) {
                    stringBuilder.append(colorOfEnabledLamp);
                }
                break;
        }
        for (int i = numberOfLampsEnabled + 1; i <= numberOfLampsInRow; i++) {
            stringBuilder.append(OFF);
        }
        return stringBuilder.toString();
    }

    /**
     * Method which return string with lamps for seconds row
     *
     * @param seconds string with seconds  in 2 digits format
     * @return string with lamps for seconds row
     */
    private String getSecondsLamp(String seconds) {
        return getRowLamps((Integer.parseInt(seconds) + 1) % 2, 1, YELLOW);
    }
}
