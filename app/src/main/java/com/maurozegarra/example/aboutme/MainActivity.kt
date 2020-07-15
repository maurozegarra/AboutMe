package com.maurozegarra.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.maurozegarra.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Binding object for MainActivity.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: ActivityMainBinding

    // Instance of User data class.
    private val user: User = User("Mauro Zegarra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the value of the user variable that is declared and used in the layout file.
        binding.user = user

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            user?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
