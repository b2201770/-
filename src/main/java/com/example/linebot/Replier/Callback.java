package com.example.linebot.Replier;

import com.example.linebot.Replier.Follow;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.MessageEvent;
import com.example.linebot.Replier.Parrot;
import com.example.linebot.Replier.Great;
import com.example.linebot.Replier.Omikuji;

@LineMessageHandler
public class Callback {
    public static final Logger log=LoggerFactory.getLogger(Callback.class);
    private boolean densyaflag;

    @EventMapping
    public Message handleFollow(FollowEvent event){
        Follow follow = new Follow(event);
        return follow.reply();
    }
    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent>event){
        TextMessageContent tmc =event.getMessage();
        String text =tmc.getText();
        if (text.equals("やあ")) {
            Great great = new Great();
            return great.reply();
        }
        else if (text.equals("おみくじ")) {
            Omikuji omikuji = new Omikuji();
            return omikuji.reply();
        }
         else if(text.equals("明日の気温")){
             Temp temp = new Temp();
             return temp.reply();
        }
         else{
                Parrot parrot =new Parrot(event);
                return parrot.reply();
        }
    }
}
