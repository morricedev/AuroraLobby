package me.morrice.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Discord implements CommandExecutor {

    HashMap<Player, Long> discord = new HashMap<Player, Long>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("discord")){

            if (discord.containsKey(p) && !(System.currentTimeMillis() >= discord.get(p))){
                p.sendMessage("§cAguarde " +converter(p) + " §csegundos para usar o comando novamente!");
                return true;
            } else discord.remove(p);

           discord.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));

            if(args.length ==0) {
                p.sendMessage("");
                p.sendMessage("§6Nosso discord:");
                p.sendMessage("§7discord.gg/v4XXyUw");
                p.sendMessage("");
                return true;
            }
        }


        return false;
    }

    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - discord.get(p);
        return 1+ TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }

}
