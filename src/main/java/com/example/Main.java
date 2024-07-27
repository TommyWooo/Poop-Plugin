package com.example;

import java.util.logging.Level;

import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Item;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack.*;
public class Main extends JavaPlugin {

  public class MyListener implements Listener{
    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
      Player player = event.getPlayer();

       if(player.isSneaking()) {
        player.sendMessage(ChatColor.GRAY + "Ahh" + ChatColor.RED + ChatColor.BOLD + " That felt gud!!");
         ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
         ItemMeta meta = item.getItemMeta();
         meta.setDisplayName(ChatColor.GOLD + "Poop");
         item.setItemMeta(meta);
         player.getWorld().dropItem(player.getLocation(), item);
//        meta.setLore(Arrays.asList("First line of lore", "second line of lore"));
         

      }
    }
  }
  
  @Override
  public void onEnable() {
    getLogger().log(Level.INFO, "Made by Tommy - Jul 26  - v8");
    getServer().getPluginManager().registerEvents(new MyListener(), this);
  }

  @Override
  public void onDisable() {
    getLogger().log(Level.INFO, "thank you so much for installing my plugin - Tommy");
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd,
                          String label, String[] args) {
    if(label.equalsIgnoreCase("credits")) {
      sender.sendMessage("Made by Tommy on July 26 - v8");
    }
    return false;
  }
  
}
