package com.palash.authenticatephonenumberexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.palash.authenticatephonenumberexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = Firebase.auth

        if (mAuth.currentUser != null)
            binding.tvMobile.text = "User Phone Number\n${mAuth.currentUser!!.phoneNumber}"

        binding.btnSignOut.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, OtpSendActivity::class.java))
            finish()
        }
    }
}