package ru.zunowskie.Manager.Utils;



import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {


        public static String getDate(){
            return (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
        }
    }

