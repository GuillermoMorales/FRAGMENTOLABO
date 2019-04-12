package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragmento.view.*
import java.lang.Exception

const val ARG_TEXT1 = "TEXTO1"
const val ARG_TEXT2 = "TEXTO2"

class Fragmento:Fragment(){

    var texto1:String?=null
    var texto2:String?=null
    var toolbox:CajitaFeliz?= null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is CajitaFeliz)
        {
            toolbox = context
        }
        else
        {
            throw Exception("Se necesita implementar la interfaz CajitaFeliz")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            texto1=getString("TEXTO1","")
            texto2=getString("TEXTO2","")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmento,container,false).apply {
            tv1.text = texto1;
            tv2.text = texto2;
            btn.setOnClickListener{
                toolbox?.clickListenerHandler(tv1)
            }

        }

    }

    companion object {
        fun newInstance(texto1:String,texto2:String) = Fragmento().apply {
            arguments = Bundle().apply {
                putString(ARG_TEXT1,texto1)
                putString(ARG_TEXT2,texto2)
            }
        }
    }

    interface CajitaFeliz{

        fun clickListenerHandler(view: TextView)
    }
}