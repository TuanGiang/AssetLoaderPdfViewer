package com.acutecoder.pdf.setting
import androidx.webkit.WebSettingsCompat

public class AssetSettings {
    val pathSettings = mutableListOf<PathSettings>()

    fun addPath(key: String, path: String) {
        // check if key already exists
        val existingPath = pathSettings.find { it.key == key }
        if(existingPath != null) {
           pathSettings.removeIf { it.key == key }
        }
        pathSettings.add(PathSettings(key, path))
    }

    fun getPath(key: String): PathSettings? {
        return pathSettings.find { it.key == key }
    }

    fun removePath(key: String) {
        pathSettings.removeIf { it.key == key }
    }

    fun clearAll() {
        pathSettings.clear()
    }

    class PathSettings(val key: String, val path: String)

    companion object {
        private var instance: AssetSettings? = null
        fun getInstance(): AssetSettings {
            if (instance == null) {
                instance = AssetSettings()
            }
            return instance!!
        }
    }
}

public class DisabledActionSettings {
    var disabledSettings: Int = 0

    fun setDisabledActionModeMenuItems(@WebSettingsCompat.MenuItemFlags menuItems: Int) {
        this.disabledSettings = menuItems
    }

    companion object {
        private var instance: DisabledActionSettings? = null
        fun getInstance(): DisabledActionSettings {
            if (instance == null) {
                instance = DisabledActionSettings()
            }
            return instance!!
        }
    }
}
