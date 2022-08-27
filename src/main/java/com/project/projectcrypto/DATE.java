package com.project.projectcrypto;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class DATE {

    public String datecalculator (){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }
}