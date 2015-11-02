package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClock implements TimeConverter {
    public static final String YELLOW = "Y";
    public static final String OFF = "O";
    public static final String RED = "R";
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

    private String getFormattedTime(String time) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] splittedTime = time.split(":");
        stringBuffer.append("\r\n");
        stringBuffer.append(getSecondsLamp(splittedTime[2]));
        stringBuffer.append("\r\n");
        stringBuffer.append(getHoursFirstRowLamps(splittedTime[0]));
        stringBuffer.append("\r\n");
        stringBuffer.append(getHoursSecondRowLamps(splittedTime[0]));
        stringBuffer.append("\r\n");
        stringBuffer.append(getMinutesFirstRowLamps(splittedTime[1]));
        stringBuffer.append("\r\n");
        stringBuffer.append(getMinutesSecondRowLamps(splittedTime[1]));
        return stringBuffer.toString();
    }

    private String getHoursFirstRowLamps(String inputHours) {
        int numberOfLumpsOn = Integer.parseInt(inputHours) / 5;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= numberOfLumpsOn; i++) {
            stringBuffer.append(RED);
        }
        for (int i = numberOfLumpsOn + 1; i <= 4; i++) {
            stringBuffer.append(OFF);
        }
        return stringBuffer.toString();
    }

    private String getHoursSecondRowLamps(String inputHours) {
        int numberOfLumpsOn = Integer.parseInt(inputHours) % 5;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= numberOfLumpsOn; i++) {
            stringBuffer.append(RED);
        }
        for (int i = numberOfLumpsOn + 1; i <= 4; i++) {
            stringBuffer.append(OFF);
        }
        return stringBuffer.toString();
    }

    private String getMinutesFirstRowLamps(String inputMinutes) {
        int numberOfLumpsOn = Integer.parseInt(inputMinutes) / 5;
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 1; i <= numberOfLumpsOn; i++) {
            if (0 == i % 3) {
                stringBuffer.append(RED);
            } else {
                stringBuffer.append(YELLOW);
            }
        }
        for (int i = numberOfLumpsOn + 1; i <= 11; i++) {
            stringBuffer.append(OFF);
        }
        return stringBuffer.toString();
    }

    private String getMinutesSecondRowLamps(String inputMinutes) {
        int numberOfLumpsOn = Integer.parseInt(inputMinutes) % 5;
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 1; i <= numberOfLumpsOn; i++) {
            stringBuffer.append(YELLOW);
        }
        for (int i = numberOfLumpsOn + 1; i <= 4; i++) {
            stringBuffer.append(OFF);
        }
        return stringBuffer.toString();
    }

    private String getSecondsLamp(String seconds) {
        if (Integer.parseInt(seconds) % 2 == 0) {
            return YELLOW;
        } else {
            return OFF;
        }
    }
}
