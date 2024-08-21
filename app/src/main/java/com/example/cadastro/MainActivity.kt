package com.example.cadastro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastro.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var uf: String = ""
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
                ufSp.setSelection(0);
            }
        }

        amb.ufSp.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?,
                                        positon: Int,
                                        id: Long) {
                uf = when(positon) {
                    0 -> "Indefinido"
                    else -> amb.ufSp.selectedItem.toString()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //NSA
            }

        }

        amb.salvaBt.setOnClickListener {
            with(amb) {
                val nome = nomeCompletoEt.text.toString()
                val telefone = telefoneEt.text.toString()
                val email = emailEt.text.toString()
                val participarListaEmail = when(listaEmailCb.isChecked) {
                    true -> "sim"
                    else -> "nao"
                }

                val selectedSexoId = sexoRg.checkedRadioButtonId;
                val sexo = when(selectedSexoId) {
                    R.id.masculinoRb -> "Masculino"
                    R.id.femininoRb -> "Feminino"
                    else -> "Indefinido"
                }

                val cidade = cidadeEt.text.toString()
                val uf = ufSp.selectedItem.toString()

                val message = String.format("###     Dados Salvo     ###\n\n" +
                        "nome: %s\n" +
                        "telefone: %s\n" +
                        "email: %s\n" +
                        "interesse na lista de email: %s\n" +
                        "sexo: %s\n" +
                        "cidade: %s\n" +
                        "UF: %s\n", nome, telefone,email, participarListaEmail, sexo, cidade, uf)

                Toast.makeText(this@MainActivity,
                    message,
                    Toast.LENGTH_LONG).show()
            }


        }
    }
}