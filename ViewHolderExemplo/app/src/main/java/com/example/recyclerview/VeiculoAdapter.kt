package com.example.recyclerview

import android.content.Context
import android.content.res.TypedArray
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_veiculo.view.*

class VeiculoAdapter(
    private var ctx: Context,
    private var veiculos: List<Veiculo>
): BaseAdapter() {

    private val logos: TypedArray by lazy {
        ctx.resources.obtainTypedArray(R.array.logos)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val veiculo = getItem(position) as Veiculo

        val holder: ViewHolder
        val row: View

        if (convertView == null) {

            Log.d("holder", "Nova posição:  $position")

            row = LayoutInflater.from(ctx).inflate(R.layout.item_veiculo, parent, false)
            holder = ViewHolder(row)
            row.tag = holder
        } else {
            Log.d("holder", "Posição Existente:  $position")
            row = convertView
            holder = row.tag as ViewHolder

        }

        holder.imgLogo.setImageDrawable(logos.getDrawable(veiculo.fabricante));
        holder.txtModelo.text = veiculo.modelo
        holder.txtAno.text = veiculo.ano.toString()
        holder.txtCombustivel.text = ctx.getString(getCombustivel(veiculo))

//        row.imgLogo.setImageDrawable(logos.getDrawable(veiculo.fabricante));
//        row.txtModelo.text = veiculo.modelo
//        row.txtAno.text = veiculo.ano.toString()
//        row.txtCombustivel.text = ctx.getString(getCombustivel(veiculo))

        return row
    }

    companion object {
        data class ViewHolder(val view: View) {
            val imgLogo: ImageView = view.imgLogo
            val txtModelo: TextView = view.txtModelo
            val txtAno : TextView = view.txtAno
            val txtCombustivel : TextView = view.txtCombustivel
        }
    }

    override fun getItem(position: Int): Any = veiculos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = veiculos.size

    fun getCombustivel(veiculo: Veiculo): Int =
        if (veiculo.gasolina && veiculo.etanol) R.string.combus_flex
        else if (veiculo.gasolina) R.string.combus_gasolina
        else if (veiculo.etanol) R.string.combus_etanol
        else R.string.combus_invalido

}