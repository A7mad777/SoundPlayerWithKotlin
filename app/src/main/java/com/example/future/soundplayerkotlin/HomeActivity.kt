package com.example.future.soundplayerkotlin

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*

private var refrence : DatabaseReference?= null
private var adapter : MusicAdapter ?= null
lateinit var mRecyclerView : RecyclerView
private var typeface : Typeface ?= null
private var auth : FirebaseAuth?= null
//lateinit var mDataBase : DatabaseReference


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        typeface = Typeface.createFromAsset(assets,"Billabong.ttf")
        textView3.typeface = typeface

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = MusicAdapter(this)
        recyclerView.adapter = adapter
        mRecyclerView = findViewById(R.id.recyclerView)

        //Set FireBase DataBase of RecyclerView
        var mDataBase = FirebaseDatabase.getInstance().getReference().child("ayahs").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.hasChildren()) {
                    val userList = ArrayList<Music>()
                    for (child in p0.children){
                        userList.add(child.getValue(Music::class.java)!!)
                    }
                    adapter!!.setData(userList)
                    adapter!!.notifyDataSetChanged()

                }
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        auth!!.signOut();
        var intent : Intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish();
        return super.onOptionsItemSelected(item)
    }
}
