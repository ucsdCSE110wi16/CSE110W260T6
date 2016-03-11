package com.changli0914.webviewtest;

/**
 * enum type definition of NewsSource
 * Created by Chang Li on 2016/2/9 0009.
 */
public enum NewsSource {
    Fox,
    BBC,
    Yahoo,
    CNN,
    ABC,
    Other;

    public static int sourceToInt(NewsSource source) {
        switch (source) {
            case Fox:
                return 0;
            case BBC:
                return 1;
            case Yahoo:
                return 2;
            case CNN:
                return 3;
            case ABC:
                return 4;
            default:
                return 5;
        }
    }

    public static NewsSource intToSource(int num) {
        switch (num) {
            case 0:
                return Fox;
            case 1:
                return BBC;
            case 2:
                return Yahoo;
            case 3:
                return CNN;
            case 4:
                return ABC;
            default:
                return Other;
        }
    }
}
