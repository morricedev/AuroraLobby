package me.morrice.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Ajuda implements CommandExecutor {

    HashMap<Player, Long> ajuda = new HashMap<Player, Long>();



    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("ajuda")){


            if (ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))) {
                p.sendMessage("§cAguarde " +converter(p) + " §csegundos para usar o comando novamente!");
                return true;
            } else ajuda.remove(p);


            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));



            if(args.length == 0){
                p.sendMessage("");
                p.sendMessage("§6AJUDA");
                p.sendMessage("§61.§7 /ajuda 1 para obter informacoes sobre o server");
                p.sendMessage("§62.§7 /ajuda 2 para obter os comandos");
                p.sendMessage("");
                return true;
            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("1")){
                    p.sendMessage("");
                    p.sendMessage("§6INFORMACOES");
                    p.sendMessage("§61.§7 O servidor esta em §cBETA");
                    p.sendMessage("§62.§7 Para jogar no pixelmon precisa do §cPixelmonReforged 7.0.6 e Biomes O' Plenty");
                    p.sendMessage("§63.§7 Para obter esses mods digite §c/links");
                    p.sendMessage("");

                    return true;
                }
                if(args[0].equalsIgnoreCase("2")){
                    p.sendMessage("");
                    p.sendMessage("§6COMANDOS");
                    p.sendMessage("§61.§7 /discord");
                    p.sendMessage("§62.§7 /links");
                    p.sendMessage("");
                    return true;
                }
            }

        }

        return false;
    }

    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1+ TimeUnit.MILLISECONDS.toSeconds(tempo) * -1 ;

    }
}