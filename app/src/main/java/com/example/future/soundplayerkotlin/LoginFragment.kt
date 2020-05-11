package com.example.future.soundplayerkotlin


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_register.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var mAuth:FirebaseAuth ?= null
private var register : Register ?= null

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance()
        var view:View = inflater.inflate(R.layout.fragment_login, container, false)


        //Make Login Authentication
        view.button2.setOnClickListener(View.OnClickListener {
            val email = view.editText.text.toString()
            val pass = view.editText2.text.toString()
            if (!TextUtils.isEmpty(email.trim()) && !TextUtils.isEmpty(pass.trim())){
                mAuth!!.signInWithEmailAndPassword(email,pass).addOnCompleteListener(OnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(activity,HomeActivity::class.java))
                    }
                }).addOnFailureListener(OnFailureListener {
                    Toast.makeText(activity,it.message,Toast.LENGTH_LONG).show()
                })
            }
        })
        view.button3.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val loginActivity = activity as LoginActivity
                loginActivity.setRegisterFragment()
            }
        })
        return view;
    }
}

