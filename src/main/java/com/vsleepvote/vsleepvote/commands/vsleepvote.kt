package com.vsleepvote.vsleepvote.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object vsleepvote : CommandExecutor{
    var votedPlayers = mutableListOf<String>("", "")
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.size > 1 || args.size == 0) {
            sender.sendMessage("Invalid syntax!")
            return true
        }
        if(args[0] == "vote") {
            votedPlayers.add(sender.name)
            Bukkit.getPlayer(sender.name)?.sendMessage("${Bukkit.getPlayer(sender.name)?.name} vote to skip night!")

            if(votedPlayers.size > 5 || Bukkit.getOnlinePlayers().size < 2)
                Bukkit.getWorld("world")?.time = 1500
                sender.sendMessage("Night skipped!")
        }
        votedPlayers.forEach { el -> Bukkit.getConsoleSender().sendMessage(el) }
        return true
    }
}