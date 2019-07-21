package me.morrice.entidades;

import me.morrice.items.SkullBuilder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventarioGUI {
    private Inventory inv;

    public InventarioGUI() {
        inv = Bukkit.createInventory(null, 9, "§3§lServidores");
        insertItens();
    }
    private InventarioGUI insertItens(){
        ItemStack i = new SkullBuilder().setOwner("05Pikachu").setDisplayName("§e§lPixelmon").build();
                inv.setItem(4,i);

                return this;

    }

    public Inventory getInv() {
        return inv;
    }
}
