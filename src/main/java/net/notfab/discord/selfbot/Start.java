package net.notfab.discord.selfbot;

import org.json.JSONObject;

import java.io.File;

/**
 * DiscordSelfBot - http://notfab.net/
 * Created by Fabricio20 on 4/10/2016.
 */
public class Start {

    public static void main(String[] args) {
        File config = new File("Config.json");
        if(!config.exists()) {
            JSONObject o = new JSONObject();
            o.put("Token", "your-token-here=please");
            FileUtils.writeFile(config, o);
        }
        new Main();
    }

}
