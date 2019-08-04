package ua.com.anagrams


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.inputmethod.EditorInfo

import kotlinx.android.synthetic.main.anagrams.*
import ua.com.anagrams.extensions.anagrams





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anagrams)
        initViewe(savedInstanceState)

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
