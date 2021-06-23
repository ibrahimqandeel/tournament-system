package validator;

import base.GameEnum;

public class MatchValidator {

    public static boolean validateMatchRecord(String[] matchRecord) {
        String sportName = "";
        if (matchRecord != null && matchRecord.length >= 3 && matchRecord[0] != null && !matchRecord[0].isEmpty()) {
            sportName = matchRecord[0];
        }
        return (sportName.equalsIgnoreCase(GameEnum.BASKETBALL.name())
                || sportName.equalsIgnoreCase(GameEnum.HANDBALL.name()));
    }
}
