package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

import static hello.TimeManipulation.*;

/**
 *
 * @author wdomingues@id.uff.br
 */
public class MessageBean implements Serializable {
     
    private String aut;
    private String autEMail;
    private String originalRepo;
    private String lang;
    private String time;
    private String localTZ;
    private String weekDay;
    private String msg;
    private String msg2;
    private String weekDayMsg;
    private String footerMsg;
    private String timeMsg;

    public MessageBean() {
    }

    public String getAut() {
        return "Winne Domingues";
    }
    public String getAutEMail() {
        return "wdomingues@id.uff.br";
    }
    public String getOriginalRepo() {
        return "jviterbo/uff-bsi-dac-2022-2-00-heroku";
    }
    public String getLang() {
        return lang;
    }
    public String getLocalTZ() {
        return localTZ;
    }

    public Calendar getTime() {
        String ltz = getLocalTZ();
        TimeZone tz = TimeZone.getTimeZone(ltz);
        TimeZone.setDefault(tz);
        Calendar calInstance = getCalInstance();
        calInstance.setTimeZone(tz);
        return calInstance;
    }

    public String getWeekDay() {
        Calendar time = getTime();
        return TimeManipulation.getWeekDay(time, getLang());
    }

    public void setLang(String value) {
        lang = value;
    }

    public void setLocalTZ(String localTZ) {
        this.localTZ = localTZ;
    }

    public String getMsg() {
        Calendar time = getTime();
        char periodOfDay = getPeriodOfDay(time);
        return getGreeting(this.lang, periodOfDay);
    }
    public String getMsg2() {
        switch (this.lang) {
            case "pt":
                return "Elaborado por";
            case "en":
                return "Created by";
            case "de":
                return "Erstellt von";
            case "fr":
                return "Créé par";
        }
        return "";
    }

    public String getWeekDayMsg() {
        switch (this.lang) {
            case "pt":
                return "Hoje é";
            case "en":
                return "Today is";
            case "de":
                return "Heute ist";
            case "fr":
                return "Aujourd'hui est ";
        }
        return "";
    }
    public String getFooterMsg() {
        switch (this.lang) {
            case "pt":
                return "derivado de " + getOriginalRepo() + " - estendido por " + getAutEMail() + ".";
            case "en":
                return "forked from " + getOriginalRepo() + " - extended by " + getAutEMail() + ".";
            case "de":
                return "aus " + getOriginalRepo() + " gegabelt - erweitert von " + getAutEMail() + ".";
            case "fr":
                return "dérivé de " + getOriginalRepo() + " - étendu par " + getAutEMail() + ".";
        }
        return "";
    }
    public String getTimeMsg() {
        return getTime().getTime().toString();
    }
}

