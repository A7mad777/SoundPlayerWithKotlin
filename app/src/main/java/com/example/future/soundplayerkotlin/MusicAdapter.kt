package com.example.future.soundplayerkotlin

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.music_row.view.*

import kotlin.coroutines.experimental.coroutineContext
import kotlin.reflect.KClass

@Suppress("DEPRECATION")
class MusicAdapter(internal var context : Context) : RecyclerView.Adapter<MusicAdapter.MusicCard>() {

    var list: ArrayList<Music> = ArrayList()
    private var mediaPlayer : MediaPlayer ?= null



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MusicCard {
        var view:View =LayoutInflater.from(p0.context).inflate(R.layout.music_row,p0,false)
        return MusicCard(view,context)
    }

    override fun getItemCount(): Int {
        return if (list != null) list!!.size else 0
    }

    override fun onBindViewHolder(p0: MusicCard, p1: Int) {
        val music = list!!.get(p1)
        p0.textView.setText(music.text)
        var playingSong : String = SharedUtil.getSong(context)
        p0.fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                    try {
                        var uri: Uri = Uri.parse(music.audio)
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
                        mediaPlayer.setDataSource(context, uri)
                        mediaPlayer.prepare()
                        mediaPlayer.start()
                        p0.fab.setImageResource(R.drawable.ic_pause_black_24dp)
                        p0.isPlaying.visibility = View.GONE

                    } catch (e: Exception) {
                        System.out.println(e.printStackTrace())
                    }

                }

        })
    }
    fun addAll(){

    }
    class MusicCard(itemView: View,context: Context) : RecyclerView.ViewHolder(itemView) {
        var list: ArrayList<Music> ?= null
        var textView = itemView.textView
        var fab = itemView.floatingActionButton
        var isPlaying = itemView.textView4
        var onClick = itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context,PlayActivity::class.java)
                context.startActivity(intent)
            }
        })

              }

    fun setData(list: ArrayList<Music>){
        this.list = list

    }
}