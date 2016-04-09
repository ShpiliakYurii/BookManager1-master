package com.springapp.mvc.controller;

/**
 * Created by Yurii on 14.03.2016.
 */
public class Events {
    public static boolean validateApparatus(Table t){
        System.out.println("Validate method is runing");
        if(t.getFieldByName("name").getValue().length() > 45 )
            return false;
        return true;
    }

    public static boolean validateMedicinecard(Table t){
        if(t.getFieldByName("pib").getValue().length() > 45 )
            return false;
        if(t.getFieldByName("adress").getValue().length() > 45 )
            return false;
        if(t.getFieldByName("identifyCode").getValue().length() != 10 )
            return false;
        return true;
    }
}
