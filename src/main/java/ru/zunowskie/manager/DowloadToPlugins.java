package ru.zunowskie.manager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import ru.zunowskie.zAPI;

import java.io.*;
import java.net.URL;
public class DowloadToPlugins {


    public static void toDowload(String urlto, String savePath, String fileName, Runnable callback) {
        Bukkit.getScheduler().runTaskAsynchronously(zAPI.getInstance(), () -> {
            try {
                File dir = new File(savePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File file = new File(dir, fileName);
                if (!file.exists()) {
                    URL url = new URL(urlto);
                    InputStream in = new BufferedInputStream(url.openStream());
                    FileOutputStream out = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];

                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }

                    out.close();
                    in.close();

                    PluginManager pluginManager = Bukkit.getPluginManager();
                    Plugin loadedPlugin = pluginManager.loadPlugin(file);
                    pluginManager.enablePlugin(loadedPlugin);
                }

                if (callback != null) {
                    Bukkit.getScheduler().runTask(zAPI.getInstance(), callback);
                }
            } catch (IOException | InvalidDescriptionException | InvalidPluginException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
