package com.changli0914.webviewtest;

/**
 * enum type definition of News Region
 * Created by Chang Li on 2016/2/9 0009.
 */
public enum NewsRegion {
    Local,
    US,
    World,
    NotSpecified;

    public static int regionToInt(NewsRegion region) {
        switch (region) {
            case Local:
                return 0;
            case US:
                return 1;
            case World:
                return 2;
            default:
                return 3;
        }
    }

    public static NewsRegion intToRegion(int num) {
        switch (num) {
            case 0:
                return Local;
            case 1:
                return US;
            case 2:
                return World;
            default:
                return NotSpecified;
        }
    }
}
