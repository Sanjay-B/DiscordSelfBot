package net.notfab.discord.selfbot;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;
import java.io.File;

/**
 * DiscordSelfBot - http://notfab.net/
 * Created by Fabricio20 on 4/10/2016.
 */
public class Main {

    @Getter private static Main Instance;
    @Getter private JDA JDA;

    @Getter @Setter
    private boolean Idle;

    @Getter private final String OriginalName;

    public Main() {
        Instance = this;
        JSONObject o = FileUtils.readFile(new File("Config.json"));
        if(!o.has("Token")) {
            System.out.print("Error: File Is Missing Token Field.");
            System.exit(-1);
        }
        try {
            String token = o.getString("Token");
            JDA = new JDABuilder(AccountType.CLIENT).setToken(token).setAutoReconnect(true).buildBlocking();
        } catch (LoginException ex1) {
            System.out.println("Error: Invalid Credentials.");
            System.exit(-2);
        } catch (InterruptedException ex2) {
            ex2.printStackTrace();
            System.exit(-3);
        } catch (RateLimitedException e) {
            System.out.println("We have been rate limited!");
            System.exit(-4);
        }
        OriginalName = JDA.getSelfUser().getName();
        JDA.addEventListener(new CommandListener());
        JDA.addEventListener(new MessageListener());
    }

}
