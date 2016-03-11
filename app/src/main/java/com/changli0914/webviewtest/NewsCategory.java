package com.changli0914.webviewtest;

/**
 * enum type definition of News Category
 * Created by Chang Li on 2016/2/9 0009.
 */
public enum NewsCategory {
    Politics,
    Entertainment,
    Tech,
    Science,
    Health,
    Travel,
    Sports,
    Other;

    public static int categoryToInt(NewsCategory category) {
        switch (category) {
            case Politics:
                return 0;
            case Entertainment:
                return 1;
            case Tech:
                return 2;
            case Science:
                return 3;
            case Health:
                return 4;
            case Travel:
                return 5;
            case Sports:
                return 6;
            default:
                return 8;
        }
    }

    public static NewsCategory intToCategory(int num) {
        switch (num) {
            case 0:
                return NewsCategory.Politics;
            case 1:
                return NewsCategory.Entertainment;
            case 2:
                return NewsCategory.Tech;
            case 3:
                return NewsCategory.Science;
            case 4:
                return NewsCategory.Health;
            case 5:
                return NewsCategory.Travel;
            case 6:
                return NewsCategory.Sports;
            default:
                return NewsCategory.Other;
        }
    }
}
