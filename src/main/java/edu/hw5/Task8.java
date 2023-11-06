package edu.hw5;

public class Task8 {
    private Task8() {
    }

    public final static String REGULAR_1 = "^([0,1][0,1])*[0,1]$";
    public final static String REGULAR_2 = "^0([0,1][0,1])*[0,1]$|^1([0,1][0,1])*$";
    public final static String REGULAR_3 = "^((1*0){3}1*)*$";
    public final static String REGULAR_4 = "^(?!11$|111$)[0,1]*";
    public final static String REGULAR_5 = "^(1[0,1])*1?$";
    public final static String REGULAR_6 = "^(0{2,}1?|0*1?0*|1?0{2,})$";
    public final static String REGULAR_7 = "^(?![0,1]*11)[0,1]*$";

}
