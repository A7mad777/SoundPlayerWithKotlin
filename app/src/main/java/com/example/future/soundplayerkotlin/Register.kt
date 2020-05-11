package com.example.future.soundplayerkotlin


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var mAuth:FirebaseAuth?=null

/**
 * A simple [Fragment] subclass.
 *
 */
class Register : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       mAuth = FirebaseAuth.getInstance()
        var view:View = inflater.inflate(R.layout.fragment_register, container, false)

        //Make Register Authentication...
        view.button4.setOnClickListener(View.OnClickListener {
            val email = view.editText3.text.toString()
            val pass = view.editText4.text.toString()
            val pass1 = view.editText5.text.toString()
            if (!TextUtils.isEmpty(email.trim()) && !TextUtils.isEmpty(pass) && TextUtils.equals(pass,pass1)){
                mAuth!!.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(OnCompleteListener {
                    startActivity(Intent(activity,HomeActivity::class.java))
                }).addOnFailureListener(OnFailureListener {
                    Toast.makeText(activity,it.message,Toast.LENGTH_LONG).show()
                })
            }
        })

        //Back to LoginFragment..
        view.button5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
              val loginActivity = activity as LoginActivity
                loginActivity.setLoginFragment()
            }
        })
        return view
    }
}
