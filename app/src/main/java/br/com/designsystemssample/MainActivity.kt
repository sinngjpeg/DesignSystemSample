package br.com.designsystemssample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.com.dsgirls.ButtonDesign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_botao = findViewById<ButtonDesign>(R.id.btnButton)
        btn_botao.setOnClickListener {
            val intent = Intent (this, ButtonSample::class.java)
            startActivity(intent)
        }
        val btn_check = findViewById<ButtonDesign>(R.id.btnCheckBox)
        btn_check.setOnClickListener {
            val intent = Intent (this, CheckBoxSample::class.java)
            startActivity(intent)

        }
    }
}