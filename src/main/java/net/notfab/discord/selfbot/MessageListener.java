package net.notfab.discord.selfbot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * DiscordSelfBot - http://notfab.net/
 * Created by Fabricio20 on 4/10/2016.
 */
public class MessageListener extends ListenerAdapter {

    private final String LENNY = "( ͡° ͜ʖ ͡°)";
    private final String SHRUG = "¯\_(ツ)_/¯";
    private final String TABLEFLIP = "(╯°□°）╯︵ ┻━┻"; //Cuz why not? :P 

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(!e.getAuthor().getId().equals(Main.getInstance().getJDA().getSelfUser().getId())) {
            return;
        }
        if(e.getMessage().getContent().contains("(lenny)")) {
            e.getMessage().editMessage(e.getMessage().getRawContent().replace("(lenny)", this.LENNY)).queue();
        } else if(e.getMessage().getContent().contains("(shrug)")) {
            e.getMessage().editMessage(e.getMessage().getRawContent().replace("(shrug)", this.SHRUG)).queue();
        } else if(e.getMessage().getContent().contains(":lenny:")) {
            e.getMessage().editMessage(e.getMessage().getRawContent().replace(":lenny:", this.LENNY)).queue();
        } else if(e.getMessage().getContent().contains(":shrug:")) {
            e.getMessage().editMessage(e.getMessage().getRawContent().replace(":shrug:", this.SHRUG)).queue();
        } else if(e.getMessage().getContent().contains(":tableflip:")) {
            e.getMessage().editMessage(e.getMessage().getRawContent().replace(":tableflip:", this.TABLEFLIP)).queue();
        }
    }

}


