package org.vanillaplus.statfacts.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * 
 * @author Alex Davidyuk
 * This is where the settings manager will go.
 * Everyone should learn how a SettingsManager works.
 * Go here to learn: https://www.youtube.com/watch?v=_S0hIVT9wAA&list=PLAF3anQEEkzQXwse2G7QXJELQPYe7numC&index=3
 * 
 */


public class SettingsManager {
	 
    private SettingsManager() { }
   
    static SettingsManager instance = new SettingsManager();
   
    public static SettingsManager getInstance() {
            return instance;
    }
   
    Plugin p;
   
    FileConfiguration config;
    File cfile;
   
    FileConfiguration data;
    File dfile;
   
    public void setup(Plugin p) {
            cfile = new File(p.getDataFolder(), "config.yml");
            config = p.getConfig();
            //config.options().copyDefaults(true);
            //saveConfig();
           
            if (!p.getDataFolder().exists()) {
                    p.getDataFolder().mkdir();
            }
           
            dfile = new File(p.getDataFolder(), "data.yml");
           
            if (!dfile.exists()) {
                    try {
                            dfile.createNewFile();
                    }
                    catch (IOException e) {
                            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
                    }
            }
           
            data = YamlConfiguration.loadConfiguration(dfile);
    }
   
    public FileConfiguration getData() {
            return data;
    }
   
    public void saveData() {
            try {
                    data.save(dfile);
            }
            catch (IOException e) {
                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
            }
    }
   
    public void reloadData() {
            data = YamlConfiguration.loadConfiguration(dfile);
    }
   
    public FileConfiguration getConfig() {
            return config;
    }
   
    public void saveConfig() {
            try {
                    config.save(cfile);
            }
            catch (IOException e) {
                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
            }
    }
   
    public void reloadConfig() {
            config = YamlConfiguration.loadConfiguration(cfile);
    }
   
    public PluginDescriptionFile getDesc() {
            return p.getDescription();
    }
}
