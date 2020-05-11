package com.example.future.soundplayerkotlin

import android.content.Context
import android.content.SharedPreferences

class SharedUtil {
companion object {
    fun saveInShared(context: Context, value: Boolean) {
        var musicApp: SharedPreferences = context.getSharedPreferences("musicApp", Context.MODE_PRIVATE)
        musicApp.edit().putBoolean("isplaying", value).commit()
    }

    fun getInShared(context: Context): Boolean {
        var musicApp: SharedPreferences = context.getSharedPreferences("musicApp", Context.MODE_PRIVATE)
        return musicApp.edit().putBoolean("isplaying", false).commit()
    }

    fun saveSong(context: Context,name :String) {
        var musicApp: SharedPreferences = context.getSharedPreferences("musicApp", Context.MODE_PRIVATE)
        musicApp.edit().putString("song", name).commit()
    }

    fun getSong(context: Context): String {
        var musicApp: SharedPreferences = context.getSharedPreferences("musicApp", Context.MODE_PRIVATE)
        return musicApp.getString("song", "")
    }
}
}