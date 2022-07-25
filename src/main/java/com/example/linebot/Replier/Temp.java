package com.example.linebot.Replier;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;


public class Temp implements Replire{
    @Override
    public Message reply(){
        String temp="明日の天気は20.3℃です";
        return new TextMessage(temp);
    }
}
