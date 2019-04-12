package com.example.myapplication

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Fragmento.CajitaFeliz {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmento=Fragmento.newInstance("Hardcore","text")
        supportFragmentManager.beginTransaction().add(R.id.activity_content,fragmento).commit();

        if(resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            Toast.makeText(this,"Esta en landscape",Toast.LENGTH_LONG).show()
        }
    }

    override fun clickListenerHandler(view: TextView)
    {
        view.text="bbsita"
    }
}
