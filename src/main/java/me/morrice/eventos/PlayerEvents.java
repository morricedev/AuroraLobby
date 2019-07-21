package me.morrice.eventos;


import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEvents implements Listener {

    //NOVO EVENTO ABAIXO
    @EventHandler
    public void quebrar(BlockBreakEvent e){
    Player p = e.getPlayer();
    if(p.isOp()){
        e.setCancelled(false);
    }else{
        e.setCancelled(true);
        p.sendMessage("§4Voce nao pode quebrar blocos!");
    }
    }

    //NOVO EVENTO ABAIXO
    @EventHandler
    public void colocar(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.isOp()){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
            p.sendMessage("§4Voce nao pode colocar blocos!");
        }
    }

    //NOVO EVENTO ABAIXO
    @EventHandler
    public void entrar (PlayerJoinEvent e){
        e.setJoinMessage("§4§l[§a§l+§4§l] §f"+e.getPlayer().getName());
        Player p = e.getPlayer();
        p.sendMessage("§2Ola " + p.getDisplayName() + ", §2seja bem-vindo ao Aurora! :P");
        p.sendMessage("§2Se estiver com duvidas digite /ajuda");

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§3§lDigite /ajuda para mais informações"));

    }

    //NOVO EVENTO ABAIXO
    @EventHandler
    public void pvp (EntityDamageEvent e){
        if(e.getEntity()instanceof Player);
        e.setCancelled(true);
    }

    //NOVO EVENTO ABAIXO
    @EventHandler
    public void drop (PlayerDropItemEvent e){
        e.setCancelled(true);
        }

    //NOVO EVENTO ABAIXO
    @EventHandler
    public void sair (PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§4§l[§c§l-§4§l] §f"+e.getPlayer().getName());
        p.getInventory().clear();
    }
}



