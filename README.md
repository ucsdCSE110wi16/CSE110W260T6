# Side By Side Design Document

## 1. App Architecture

### Activities:
    MainActivity(ListView: show pair list)
        |---MyArrayAdapter -> Maintain the view for each item in the list
        |
        |---Click Item -> PairViewActivity (FragmentActivity: container of fragments)
        |                       |
        |                       |---Pair Title
        |                       |---PairViewFragment(WebView: Show a piece of news)
        |                       |                |(Slide to Switch)|    
        |                       |---PairViewFragment(WebView: Show a piece of news)
        |                       |---Rating Button
        |                               |-> RatingActivity (A Pop up Window)
        |
        |---Click Add Button -> AddPairActivity (EditText: get various user input)

### Layouts:
        - activity_main.xml         ->    Layout of MainActivity
        - activity_addpair.xml      ->    Layout of AddPairActivity
        - activity_pairview.xml     ->    Layout of PairViewActivity (FragmentActivity)
        - activity_rating.xml       ->    Layout of RatingActivity
        - fragment_pairview.xml     ->    Layout of Each Fragment in FragmentActivity
        - pairlist_layout.xml       ->    Layout of Each Item In ListView In MainActivity
        
### Classes:

        - News           -> Represents a Piece of News
        - Pair           -> Contains two piece of News, will be transmitted between 
                           different activities (e.g. MainActivity and PairViewActivity)
        - PairManager    -> Is used to communicate with remote DB, should offer pairs
                            to the App, cache images, add new pair to DB, etc.
        - MyArrayAdapter -> A customized ArrayAdapter
        - NewsCatrgory   -> Enum Class, used in Class News
        - NewsRegion     -> Enum Class, used in Class News
        - NewsSource     -> Enum Class, used in Class News



## 2. Future Work

### [1]. Completet the PairManager Class (Ronan, Amal)
        Should communicate with remote DB, sync, add new pair

### [2]. Complete the MainActivity (Emil, Jeff)
        Add a toolbar, enable filter(By Date, Region, Category, etc.)
        Can update ListView When user added new Pair
        
### [3]. AddPairActivity (Ronan, Amal)
        Fix the bug. Can Add New Pair.
        Check the availability of new pair (If the info is complete, if the url is valid)
        Add more field: Bias, Keywords, ...
    
### [4]. PairViewActivity (Daniel, Chang)
        Add new widgets to show titles when viewing the news (**DONE**)
        Show Bias
        Permit users to rate the pair/News (**DONE**)
        Cache the page to speed the load process

## Version
1.0.1

## Last Updated
Feb. 17, 2016

## Members
Jeffrey Trang, Emil Kirov, Chang Li, Daniel Yang, Amal Al-Haidari, Ronan Courture





