package com.example.testrealtimedatabasekotlin_master

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testrealtimedatabasekotlin_master.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database1: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("Users")
        myRef.setValue("Hello, World!")

        binding.registerBtn.setOnClickListener {
            val firstName = binding.firstName.text.toString()
            val userName = binding.userName.text.toString()
            val mailAdress = binding.mailAdress.text.toString()
            val password = binding.password.text.toString()

            database1 = FirebaseDatabase.getInstance().getReference("Users")
            val user = User(firstName, mailAdress, password, userName)
            database1.child(userName).setValue(user).addOnSuccessListener {
                binding.firstName.text.clear()
                binding.userName.text.clear()
                binding.mailAdress.text.clear()
                binding.password.text.clear()

                Toast.makeText(this,"Successfully saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
