package ua.com.anagrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.anagrams.*
import ua.com.anagrams.extensions.anagrams

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anagrams)
        initViewe(savedInstanceState)

        bt_anagrams_revers.setOnClickListener {
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
