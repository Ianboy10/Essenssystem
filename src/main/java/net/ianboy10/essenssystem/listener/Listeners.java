package net.ianboy10.essenssystem.listener;

import net.ianboy10.essenssystem.Data;
import net.ianboy10.essenssystem.MySQL;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Data.registerPlayer(p.getUniqueId()); // Register the player
        Data.checkSpeedFett(p); // Check the speed of the player's fat
        Data.checkSpeedMuskeln(p); // Check the speed of the player's muscles
    }

    @EventHandler
    public void onUseEssen(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.SKULL_ITEM && p.getItemInHand().getI18NDisplayName().equals("§bSteak") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            p.sendMessage("§aDu hast ein §a§lSteak §agegessen.");
            int fett = Data.getFett(p.getUniqueId()); // Get the player's fat (fett)
            int muskeln = Data.getMuskeln(p.getUniqueId()); // Get the player's muscles (muskeln)
            System.out.println(fett + " " + muskeln);

            int fettneu = fett + 1;
            int muskelnneu = muskeln + 1;
            if (fettneu >= 100) {
                fettneu = 100;
            }
            if (muskelnneu >= 100) {
                muskelnneu = 100;
            }
            MySQL.update("UPDATE essen SET fett='" + fettneu + "' WHERE uuid='" + p.getUniqueId() + "'");
            MySQL.update("UPDATE essen SET muskeln='" + muskelnneu + "' WHERE uuid='" + p.getUniqueId() + "'");

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
            // p.playSound(p.getLocation(), "", 1, 1);
            Data.checkSpeedFett(p);
            Data.checkSpeedMuskeln(p);
        }
        if (p.getItemInHand().getType() == Material.SKULL_ITEM && p.getItemInHand().getI18NDisplayName().equals("§bNudeln") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            p.sendMessage("§aDu hast §a§lNudeln §agegessen.");
            int fett = Data.getFett(p.getUniqueId()); // Get the player's fat (fett)
            int muskeln = Data.getMuskeln(p.getUniqueId()); // Get the player's muscles (muskeln)
            System.out.println(fett + " " + muskeln);

            int fettneu = fett + 1;
            int muskelnneu = muskeln - 1;
            if (fettneu >= 100) {
                fettneu = 100;
            }
            if (muskelnneu >= 100) {
                muskelnneu = 100;
            }
            MySQL.update("UPDATE essen SET fett='" + fettneu + "' WHERE uuid='" + p.getUniqueId() + "'");
            MySQL.update("UPDATE essen SET muskeln='" + muskelnneu + "' WHERE uuid='" + p.getUniqueId() + "'");

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
            // p.playSound(p.getLocation(), "", 1, 1);
            Data.checkSpeedFett(p);
            Data.checkSpeedMuskeln(p);
        }
        if (p.getItemInHand().getType() == Material.SKULL_ITEM && p.getItemInHand().getI18NDisplayName().equals("§bBrot") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            p.sendMessage("§aDu hast ein §a§lBrot §agegessen.");
            int fett = Data.getFett(p.getUniqueId()); // Get the player's fat (fett)
            int muskeln = Data.getMuskeln(p.getUniqueId()); // Get the player's muscles (muskeln)
            System.out.println(fett + " " + muskeln);

            int fettneu = fett + 1;
            int muskelnneu = muskeln - 1;
            if (fettneu >= 100) {
                fettneu = 100;
            }
            if (muskelnneu >= 100) {
                muskelnneu = 100;
            }
            MySQL.update("UPDATE essen SET fett='" + fettneu + "' WHERE uuid='" + p.getUniqueId() + "'");
            MySQL.update("UPDATE essen SET muskeln='" + muskelnneu + "' WHERE uuid='" + p.getUniqueId() + "'");

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
            // p.playSound(p.getLocation(), "", 1, 1);
            Data.checkSpeedFett(p);
            Data.checkSpeedMuskeln(p);
        }
    }

    @EventHandler
    public void onUseTrinken(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.SKULL_ITEM && p.getItemInHand().getI18NDisplayName().equals("§bCola") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            p.sendMessage("§bDu hast §b§lCola §bgetrunken.");
            int fett = Data.getFett(p.getUniqueId()); // Get the player's fat (fett)
            int muskeln = Data.getMuskeln(p.getUniqueId()); // Get the player's muscles (muskeln)
            System.out.println(fett + " " + muskeln);

            int fettneu = fett + 1;
            int muskelnneu = muskeln - 1;
            if (fettneu >= 100) {
                fettneu = 100;
            }
            if (muskelnneu >= 100) {
                muskelnneu = 100;
            }
            MySQL.update("UPDATE essen SET fett='" + fettneu + "' WHERE uuid='" + p.getUniqueId() + "'");
            MySQL.update("UPDATE essen SET muskeln='" + muskelnneu + "' WHERE uuid='" + p.getUniqueId() + "'");

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
            // p.playSound(p.getLocation(), "", 1, 1);
            Data.checkSpeedFett(p);
            Data.checkSpeedMuskeln(p);
        }
        if (p.getItemInHand().getType() == Material.SKULL_ITEM && p.getItemInHand().getI18NDisplayName().equals("§bFanta") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            p.sendMessage("§bDu hast §b§lFanta §bgetrunken.");
            int fett = Data.getFett(p.getUniqueId()); // Get the player's fat (fett)
            int muskeln = Data.getMuskeln(p.getUniqueId()); // Get the player's muscles (muskeln)
            System.out.println(fett + " " + muskeln);

            int fettneu = fett + 2;
            int muskelnneu = muskeln - 2;
            if (fettneu >= 100) {
                fettneu = 100;
            }
            if (muskelnneu >= 100) {
                muskelnneu = 100;
            }
            MySQL.update("UPDATE essen SET fett='" + fettneu + "' WHERE uuid='" + p.getUniqueId() + "'");
            MySQL.update("UPDATE essen SET muskeln='" + muskelnneu + "' WHERE uuid='" + p.getUniqueId() + "'");

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
            // p.playSound(p.getLocation(), "", 1, 1);
            Data.checkSpeedFett(p);
            Data.checkSpeedMuskeln(p);
        }
        if (p.getItemInHand().getType() == Material.SKULL_ITEM && p.getItemInHand().getI18NDisplayName().equals("§bProteinshake") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            p.sendMessage("§bDu hast ein §b§lProteinshake §bgetrunken.");
            int fett = Data.getFett(p.getUniqueId()); // Get the player's fat (fett)
            int muskeln = Data.getMuskeln(p.getUniqueId()); // Get the player's muscles (muskeln)
            System.out.println(fett + " " + muskeln);

            int fettneu = fett + 5;
            int muskelnneu = muskeln + 5;
            if (fettneu >= 100) {
                fettneu = 100;
            }
            if (muskelnneu >= 100) {
                muskelnneu = 100;
            }
            MySQL.update("UPDATE essen SET fett='" + fettneu + "' WHERE uuid='" + p.getUniqueId() + "'");
            MySQL.update("UPDATE essen SET muskeln='" + muskelnneu + "' WHERE uuid='" + p.getUniqueId() + "'");

            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
            // p.playSound(p.getLocation(), "", 1, 1);
            Data.checkSpeedFett(p);
            Data.checkSpeedMuskeln(p);
        }
    }
}
