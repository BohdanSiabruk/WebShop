package com.epam.preproduction.siabruk.wrapper;

public class WrapperString extends CommonWrapper {

    public WrapperString(String hashString) {
        super(hashString);
    }

    @Override
    public int hashCode() {
        return hashString.length();
    }
}
