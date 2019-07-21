package me.morrice.eventos;

import me.morrice.entidades.InventarioGUI;
import me.morrice.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Inventario implements Listener {

    //GUI
    @EventHandler
    public void clicar(InventoryClickEvent e){
        if (e.getInventory().getName().equalsIgnoreCase("§cPixelmon")) return;

        ItemStack i = e.getCurrentItem();
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();
        if(i.getType() == Material.SKULL_ITEM) {
            p.chat("/warp npc");
        }
        }

   //ABRIR GUI AO CLICAR NA BUSSULA
   @EventHandler
   public void bussula(PlayerInteractEvent e){
       Player p = e.getPlayer();
       if(p.getInventory().getItemInMainHand().getType() == Material.COMPASS){
           if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
               p.openInventory(new InventarioGUI().getInv());
               p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10,10 );
           }
       }
   }

    //ITENS SETADOS AO ENTRAR
    @EventHandler
    public void entrar (PlayerJoinEvent e){
        Player p = e.getPlayer();
        ItemStack vine1 = new ItemBuilder(Material.VINE)
                .setDisplayName("§3§lAurora")
                .addEnchantment(Enchantment.DURABILITY,1)
                .hideAllFlags()
                .build();
        p.getInventory().setItem(0,vine1);

        //NOVO ITEM ABAIXO
        ItemStack bar = new ItemBuilder(Material.DOUBLE_PLANT)
                .setDisplayName("§c§lAurora")
                .build();
        p.getInventory().setItem(1,bar);

        //NOVO ITEM ABAIXO
        ItemStack vine2 = new ItemBuilder(Material.VINE)
                .setDisplayName("§3§lAurora")
                .addEnchantment(Enchantment.DURABILITY,3)
                .hideAllFlags()
                .build();
        p.getInventory().setItem(2,vine2);

        //NOVO ITEM ABAIXO
        ItemStack bar2 = new ItemBuilder(Material.DOUBLE_PLANT)
                .setDisplayName("§c§lAurora")
                .build();
        p.getInventory().setItem(3,bar2);

        //NOVO ITEM ABAIXO
        ItemStack bussula = new ItemBuilder(Material.COMPASS)
                .setDisplayName("§3Servidores")
                .setLore("§cNavege entre os servidores")
                .build();
        p.getInventory().setItem(4,bussula);

        //NOVO ITEM ABAIXO
        ItemStack vine3 = new ItemBuilder(Material.VINE)
                .setDisplayName("§3§lAurora")
                .addEnchantment(Enchantment.DURABILITY,8)
                .hideAllFlags()
                .build();
        p.getInventory().setItem(5,vine3);

        //NOVO ITEM ABAIXO
        ItemStack bar3 = new ItemBuilder(Material.DOUBLE_PLANT)
                .setDisplayName("§c§lAurora")
                .build();
        p.getInventory().setItem(6,bar3);

        //NOVO ITEM ABAIXO
        ItemStack vine4 = new ItemBuilder(Material.VINE)
                .setDisplayName("§3§lAurora")
                .addEnchantment(Enchantment.DURABILITY,8)
                .hideAllFlags()
                .build();
        p.getInventory().setItem(7,vine4);

        //NOVO ITEM ABAIXO
        ItemStack bar4 = new ItemBuilder(Material.DOUBLE_PLANT)
                .setDisplayName("§c§lAurora")
                .build();
        p.getInventory().setItem(8,bar4);
    }
}
