package me.morrice.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Links implements CommandExecutor {
    HashMap<Player, Long> links = new HashMap<Player, Long>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("links")){

            if (links.containsKey(p) && !(System.currentTimeMillis() >= links.get(p))){
                p.sendMessage("§cAguarde " +converter(p) + " §csegundos para usar o comando novamente!");
                return true;
            } else links.remove(p);

            links.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));

            if(args.length ==0) {
                p.sendMessage("");
                p.sendMessage("§6PixelmonReforged:");
                p.sendMessage("§7www.technicpack.net/modpack/pixelmon-reforged.1150447");
                p.sendMessage("");
                p.sendMessage("§6Biomes O 'Plenty:");
                p.sendMessage("§7https://www.curseforge.com/minecraft/mc-mods/biomes-o-plenty");
                p.sendMessage("");
                return true;
            }
        }


        return false;
    }

    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - links.get(p);
        return 1+ TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }

}