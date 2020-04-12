package com.ramonguimaraes.beercomparator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import java.text.DecimalFormat

class CervejaAdapter(var cervejas: ArrayList<Cerveja>, var context: Context): RecyclerView.Adapter<CervejaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(cerveja: Cerveja){
            val marca = itemView.txtv_marca
            val preco = itemView.txtv_preco
            val precolitro = itemView.txtv_precolitro
            val litragem = itemView.txtv_mls
            val strings = itemView.context.resources.getStringArray(R.array.mls)
            val fm = DecimalFormat("R$ 0.##")

            marca.text = cerveja.marca
            litragem.text = strings[cerveja.litragem]
            preco.text = fm.format(cerveja.preco)
            precolitro.text = fm.format(cerveja.precolitro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cervejas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cerveja = cervejas[position]
        holder.bindView(cerveja)
    }
}