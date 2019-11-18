package com.example.listfragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import java.lang.RuntimeException

class AlimentoListFragment: ListFragment() {

    private lateinit var adapter: ArrayAdapter<Alimento>

    private lateinit var listener : OnItemClickAlimento

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context !is OnItemClickAlimento) {
            throw RuntimeException("Não é OnItemClickAlimento")
        }

        listener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, getAlimentos())

//        val nomes = getStringArray(R.array.alimentos_nomes)
//        val precos = getStringArray(R.array.alimentos_precos)
//
//        var alimentos = ArrayList<Alimento>()
//
//        alimentos.add(Alimento("1", 2.5))
//
//        for (i in nomes.indices) {
//            val alimento = Alimento(nomes[i], precos[i].toDouble())
//            alimentos.add(alimento)
//            adapter.add(alimento)
//        }

        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var alimento = adapter.getItem(position)!!
        listener.onClick(alimento)
    }

    fun getAlimentos(): ArrayList<Alimento> {
        val nomes = getStringArray(R.array.alimentos_nomes)
        val precos = getStringArray(R.array.alimentos_precos)

        var alimentos = ArrayList<Alimento>()

        for (i in nomes.indices) {
            val alimento = Alimento(nomes[i], precos[i].toDouble())
            alimentos.add(alimento)
        }

        return alimentos
    }


    fun getStringArray(id: Int): Array<out String> {
        return requireActivity().resources.getStringArray(id)
    }

    interface OnItemClickAlimento {
        fun onClick(alimento: Alimento)
    }

}