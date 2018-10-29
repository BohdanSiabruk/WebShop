package com.epam.preproduction.siabruk.wrapper;

public class WrapperSumNumbers extends CommonWrapper{


    public WrapperSumNumbers(String hashString) {
        super(hashString);
    }

    @Override
    public int hashCode() {

       int result = 0;
            for (int i = 0; i < hashString.length() && i < 4; i++){
                result += hashString.charAt(i);
            }

        return result;
    }
}
