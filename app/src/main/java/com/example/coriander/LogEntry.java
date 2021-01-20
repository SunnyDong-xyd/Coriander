package com.example.coriander;

public class LogEntry {

    int mood;
    Boolean panicAttack;
    String userLog;

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
}
