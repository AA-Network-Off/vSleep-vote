package com.vsleepvote.vsleepvote

import com.vsleepvote.vsleepvote.commands.vsleepvote
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class VSleepVote : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("$config")
        getCommand("vsleepvote")?.setExecutor(vsleepvote)
        Bukkit.getConsoleSender().sendMessage("vSleep Vote started!")
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}