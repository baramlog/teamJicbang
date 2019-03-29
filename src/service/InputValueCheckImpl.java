package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValueCheckImpl implements InputValueCheck {

    @Override
    public boolean checkNumber(String cmd, int startNum, int endNum) {

        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(cmd);
        if (m.matches()) {
            if(startNum <= Integer.parseInt(cmd) && Integer.parseInt(cmd) <= endNum)
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
