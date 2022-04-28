package com.vsleepvote.vsleepvote

import com.vsleepvote.vsleepvote.commands.vsleepvote
import lombok.Getter
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class VSleepVote : JavaPlugin() {
    @Getter
    var configFile = File(dataFolder, "config.yml")
    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("$configFile \n $config")
        getCommand("vsleepvote")?.setExecutor(vsleepvote)
        Bukkit.getConsoleSender().sendMessage("vSleep Vote started!")
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}