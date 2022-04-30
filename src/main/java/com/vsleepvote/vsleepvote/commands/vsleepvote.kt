package com.vsleepvote.vsleepvote.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object vsleepvote : CommandExecutor{
    var votedPlayers = mutableListOf<String>()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender.name == "CONSOLE") {
            sender.sendMessage("Your not an online player!")
        }
        if(args.size > 1 || args.size == 0) {
            sender.sendMessage("Invalid syntax!")
            return true
        }
        if(args[0] == "vote") {
            if(sender.name in votedPlayers) {
                Bukkit.getPlayer(sender.name)?.sendMessage("You already voted!")
                return true
            }
            if(votedPlayers.size < Bukkit.getOnlinePlayers().size) {
                Bukkit.getOnlinePlayers().forEach {
                    Bukkit.getPlayer("${it.name}")?.sendMessage("${votedPlayers.size} people voted out of ${Bukkit.getOnlinePlayers().size}, the night will not be skipped")
                }
            }
            votedPlayers.add(sender.name)
            Bukkit.getPlayer(sender.name)?.sendMessage("${Bukkit.getPlayer(sender.name)?.name} vote to skip night!")
            var vpp = (Bukkit.getOnlinePlayers().size / 100) * votedPlayers.size
            if(vpp > 90) {
                Bukkit.getWorld("world")?.time = 1500
                sender.sendMessage("If the percentage of players who voted is more than 90, the night will be skipped!")
            }
            if(Bukkit.getOnlinePlayers().size < 2) {
                Bukkit.getWorld("world")?.time = 1500
                sender.sendMessage("Night skipped!")
            }
        }
        votedPlayers.forEach { el -> Bukkit.getConsoleSender().sendMessage(el) }
        if(args[0] == "fskip") {
            if(!sender.isOp) {
                sender.sendMessage("Your not an operator!")
                return true
            } else {
                Bukkit.getWorld("world")?.time = 1500
                sender.sendMessage("Night skipped!")
            }
        }
        return true
    }
}