package validator;

import base.GameEnum;

public class PlayerValidator {

    public static boolean validateMultiplePlayers(String[] matchRecord) {
        if (matchRecord == null || matchRecord.length < 3) {
            return false;
        }
        String sportName = matchRecord[0];
        if (sportName.equalsIgnoreCase(GameEnum.BASKETBALL.name())) {
            return validateBasketballPlayersList(matchRecord);
        } else if (sportName.equalsIgnoreCase(GameEnum.HANDBALL.name())) {
            return validateHandballPlayersList(matchRecord);
        }
        return false;
    }

    public static boolean validateBasketballPlayersList(String[] playersRecordsList) {
        boolean isValidRecord;
        for (int i = 1; i < playersRecordsList.length; i++) {
            isValidRecord = validateBasketballPlayer(playersRecordsList[i]);
            if (!isValidRecord) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateHandballPlayersList(String[] playersRecordsList) {
        boolean isValidRecord;
        for (int i = 1; i < playersRecordsList.length; i++) {
            isValidRecord = validateHandballPlayer(playersRecordsList[i]);
            if (!isValidRecord) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateBasketballPlayer(String basketballPlayerRecord) {
        if (basketballPlayerRecord != null && !basketballPlayerRecord.isEmpty()) {
            String[] playerDetails = basketballPlayerRecord.split(";");
            return playerDetails != null && playerDetails.length == 8;
        }
        return false;
    }

    public static boolean validateHandballPlayer(String handballPlayerRecord) {
        if (handballPlayerRecord != null && !handballPlayerRecord.isEmpty()) {
            String[] playerDetails = handballPlayerRecord.split(";");
            return playerDetails != null && playerDetails.length == 7;
        }
        return false;
    }
}
