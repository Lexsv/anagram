package ua.com.anagrams


import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View

import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.getSystemService

import kotlinx.android.synthetic.main.anagrams.*
import ua.com.anagrams.extensions.anagrams





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anagrams)
        initViewe(savedInstanceState)

        et_anagrams_revers.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE){
                val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(v.windowToken, 0)
                tv_anagrams_result.text =(et_anagrams_revers.text.toString().anagrams())
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        ib_revers.setOnClickListener {
            et_anagrams_revers.onEditorAction(EditorInfo.IME_ACTION_DONE)
            tv_anagrams_result.text =(et_anagrams_revers.text.toString().anagrams())
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("result",tv_anagrams_result.text.toString() )
    }

    fun initViewe (savedInstanceState : Bundle? ){
        tv_anagrams_result.text = savedInstanceState?.getString("result" , "") ?: ""
    }
}
