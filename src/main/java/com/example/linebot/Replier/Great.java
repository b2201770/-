package com.example.linebot.Replier;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.time.LocalTime;

public class Great implements Replire{
    @Override
    public Message reply(){
        LocalTime lt = LocalTime.now();
        int hour = lt.getHour();
        if(hour>=17){
            return new TextMessage("こんばんは！");
        }
        if(hour>=11){
            return new TextMessage("こんにちは！");
        }
        return new TextMessage("おはよう！");
    }
}