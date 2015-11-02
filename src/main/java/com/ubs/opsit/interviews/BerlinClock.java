package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
        if (aTime.matches("([01][0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]")) {
            return getFormattedTime(aTime);
        } else {
            return null;
        }
    }

    private String getFormattedTime(String time) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] splittedTime = time.split(":");
        stringBuffer.append("\r\n");
        stringBuffer.append(getSecondsLamp(splittedTime[2]));
        stringBuffer.append("\r\n");
        stringBuffer.append(getHoursLamps(splittedTime[0]));
        stringBuffer.append("\r\n");
        stringBuffer.append(getMinutesLamps(splittedTime[1]));
        return stringBuffer.toString();
    }

    private String getHoursLamps(String inputHours) {
        int hours = Integer.parseInt(inputHours);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            if (hours / 5 > 0) {
                stringBuffer.append("R");
                hours = hours - 5;
            } else {
                stringBuffer.append("O");
            }
        }
        stringBuffer.append("\r\n");
        for (int i = 0; i < 4; i++) {
            if (hours % 5 > 0) {
                stringBuffer.append("R");
                hours--;
            } else {
                stringBuffer.append("O");
            }
        }
        return stringBuffer.toString();
    }

    private String getMinutesLamps(String inputMinutes) {
        int minutes = Integer.parseInt(inputMinutes);
        int numberOfRedLamps = minutes / 15;
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 11; i++) {
            if (minutes / 5 > 0) {
                stringBuffer.append("Y");
                minutes = minutes - 5;
            } else {
                stringBuffer.append("O");
            }
        }
        while (numberOfRedLamps > 0) {
            stringBuffer.replace(numberOfRedLamps * 3 - 1, numberOfRedLamps * 3, "R");
            numberOfRedLamps--;
        }
        stringBuffer.append("\r\n");
        for (int i = 0; i < 4; i++) {
            if (minutes % 5 > 0) {
                stringBuffer.append("Y");
                minutes--;
            } else {
                stringBuffer.append("O");
            }
        }
        return stringBuffer.toString();
    }

    private String getSecondsLamp(String seconds) {
        if (Integer.parseInt(seconds) % 2 == 0) {
            return "Y";
        } else {
            return "O";
        }
    }
}
