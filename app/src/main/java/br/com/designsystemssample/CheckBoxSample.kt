package br.com.designsystemssample

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class CheckBoxSample : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkbox)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return false
    }
}