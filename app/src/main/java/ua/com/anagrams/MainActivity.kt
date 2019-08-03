package ua.com.anagrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.anagrams.*
import ua.com.anagrams.extensions.anagrams

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anagrams)

        bt_anagrams_revers.setOnClickListener {
            tv_anagrams_result.setText("")
            tv_anagrams_result.setText(et_anagrams_revers.text.toString().anagrams())
        }
    }
}
