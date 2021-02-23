package com.example.coriander;

public class LogEntry {
    //TODO: Add method for filename creation. Add method for creation and retrieval of file contents
    int mood;
    Boolean panicAttack;
    String userLog;
    int year;
    int month;
    int day;

    public LogEntry(){
    }

    public LogEntry(int mood, Boolean panicAttack, String userLog){
        this.mood = mood;
        this.panicAttack = panicAttack;
        this.userLog = userLog;
    }

    public void setMood(int mood){
        this.mood = mood;
    }

    public void setPanicAttack(Boolean panicAttack){
        this.panicAttack = panicAttack;
    }

    public void setUserLog(String userLog){
        this.userLog = userLog;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }
}
