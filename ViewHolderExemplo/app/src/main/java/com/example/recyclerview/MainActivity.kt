package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val veiculos = mutableListOf(
        Veiculo("Onix", 2018, 1,true, true),
        Veiculo("Uno", 2009, 2,true, false),
        Veiculo("Del Rey", 1998, 3,false, true),
        Veiculo("Gol", 2014, 0,true, true),
        Veiculo("Onix", 2018, 1,true, true),
        Veiculo("Uno", 2009, 2,true, false),
        Veiculo("Del Rey", 1998, 3,false, true),
        Veiculo("Gol", 2014, 0,true, true),
        Veiculo("Onix", 2018, 1,true, true),
        Veiculo("Uno", 2009, 2,true, false),
        Veiculo("Del Rey", 1998, 3,false, true),
        Veiculo("Gol", 2014, 0,true, true),
        Veiculo("Onix", 2018, 1,true, true),
        Veiculo("Uno", 2009, 2,true, false),
        Veiculo("Del Rey", 1998, 3,false, true),
        Veiculo("Gol", 2014, 0,true, true),
        Veiculo("Onix", 2018, 1,true, true),
        Veiculo("Uno", 2009, 2,true, false),
        Veiculo("Del Rey", 1998, 3,false, true),
        Veiculo("Gol", 2014, 0,true, true),
        Veiculo("Onix", 2018, 1,true, true),
        Veiculo("Uno", 2009, 2,true, false),
        Veiculo("Del Rey", 1998, 3,false, true),
        Veiculo("Gol", 2014, 0,true, true)
    )

    lateinit var adapter: VeiculoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val listView = ListView(this)

        setContentView(listView)

        adapter = VeiculoAdapter(this, veiculos)

        listView.adapter = adapter
    }
}
