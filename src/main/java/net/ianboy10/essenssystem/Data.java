package net.ianboy10.essenssystem;

import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.util.UUID;

public class Data {
    private static final float DEFAULT_WALK_SPEED = 1.0F; // Default walk speed

    public static void registerPlayer(UUID uuid) { // Register the player
        if (!registeredPlayer(uuid)) {
            MySQL.update("INSERT INTO essen(uuid, fett, muskeln) VALUES ('" + uuid + "', '50', '0')");
        }
    }

    private static boolean registeredPlayer(UUID uuid) { // Check if the player is registered
        ResultSet rs = MySQL.getResult("SELECT * FROM essen WHERE uuid='" + uuid + "'");
        try {
            while (rs != null && rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static int getFett(UUID uuid) { // Check the Fat
        ResultSet rs = MySQL.getResult("SELECT * FROM essen WHERE uuid='" + uuid + "'");
        try {
            while (rs != null && rs.next()) {
                return rs.getInt("fett");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static int getMuskeln(UUID uuid) { // Check the Muscles
        ResultSet rs = MySQL.getResult("SELECT * FROM essen WHERE uuid='" + uuid + "'");
        try {
            while (rs != null && rs.next()) {
                return rs.getInt("muskeln");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void checkSpeedFett(Player p) {
        int fett = getFett(p.getUniqueId());
        float currentWalkSpeed = p.getWalkSpeed();
        float newWalkSpeed = currentWalkSpeed; // Start with current walk speed

        if (fett == 100) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.5F, 0.2F); // Minimum walk speed is 0.2F
        } else if (fett >= 80) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.4F, 0.2F);
        } else if (fett >= 60) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.3F, 0.2F);
        } else if (fett >= 40) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.2F, 0.2F);
        } else if (fett >= 20) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.1F, 0.2F);
        }

        p.setWalkSpeed(newWalkSpeed); // Set the Walkspeed
        System.out.println(newWalkSpeed);
    }

    public static void checkSpeedMuskeln(Player p) {
        int muskeln = getMuskeln(p.getUniqueId());
        float currentWalkSpeed = p.getWalkSpeed();
        float newWalkSpeed = currentWalkSpeed; // Start with current walk speed

        if (muskeln == 100) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.7F, 0.2F);
        } else if (muskeln >= 80) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.6F, 0.2F);
        } else if (muskeln >= 60) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.5F, 0.2F);
        } else if (muskeln >= 40) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.4F, 0.2F);
        } else if (muskeln >= 20) {
            newWalkSpeed = Math.max(currentWalkSpeed - 0.3F, 0.2F);
        } else if (muskeln >= 0) {
            newWalkSpeed = Math.max(currentWalkSpeed + 0.1F, 0.2F);
        }

        p.setWalkSpeed(newWalkSpeed); // Set the Walkspeed
        System.out.println(newWalkSpeed);
    }
}
