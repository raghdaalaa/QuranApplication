package com.example.quranapplication;

public enum Translationlanguages {
    ENGLISH("en" , 17 ),
    FRENCH("fr" , 31) ,
    ARABIC("ar" ,3) ,
    German("de" ,27 ) ,
    Spanish("es" ,28),
    Russian("ru" ,45 ) ,
    Indonesia("id" ,33 );



   private String stringValue;
    private int intValue;
    Translationlanguages(String String, int value) {
       stringValue = String;
       intValue = value;

    }
   @Override
    public String toString() {
        return stringValue;
    }

    public int getIntValue(){
        return intValue;
    }

}
