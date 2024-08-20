package com.example.cadastro

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView.OnItemSelectedListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastro.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.limparBt.setOnClickListener {
            with (amb) {
                nomeCompletoEt.setText("")
                telefoneEt.setText("")
                emailEt.setText("")
                listaEmailCb.isChecked = false
                sexoRg.clearCheck()
                cidadeEt.setText("")
                ufSp.setSelection(-1);
            }
        }
    }
}