package me.morrice;

import me.morrice.comandos.Ajuda;
import me.morrice.comandos.Discord;
import me.morrice.comandos.Links;
import me.morrice.eventos.Inventario;
import me.morrice.eventos.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class morrice extends JavaPlugin {

    @Override
    public void onEnable(){
        loadConfig();
        Bukkit.getConsoleSender().sendMessage(getConfig().getString ("Config.MsgON").replace("&", "§"));
        registrarEventos();
        registrarComandos();

    }

    private void registrarComandos(){

        getCommand("ajuda").setExecutor(new Ajuda());
        getCommand("discord").setExecutor(new Discord());
        getCommand("links").setExecutor(new Links());
    }


    private void registrarEventos(){

        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new Inventario(), this);
    }

    @Override
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(getConfig().getString ("Config.MsgOFF").replace("&", "§"));

    }

    private void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
}
