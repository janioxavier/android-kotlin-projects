package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_text.*

class MainActivity : AppCompatActivity(), AlimentoListFragment.OnItemClickAlimento {

    private lateinit var textFragment: TextFragment

    override fun onClick(alimento: Alimento) {
        textFragment.setText("O preço do aliemento $alimento é R$ ${alimento.preco}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFragment = supportFragmentManager.findFragmentById(R.id.frag_text) as TextFragment
    }
}
