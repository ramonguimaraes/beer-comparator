package com.ramonguimaraes.beercomparator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var cervejas = arrayListOf<Cerveja>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_add.setOnClickListener(View.OnClickListener {
            val marca: String = txt_marca.text.toString();
            val preco: Double = txt_preco.text.toString().toDouble();
            val litragem: Int = spinner.selectedItemPosition

            val cerveja = Cerveja(marca, preco, litragem, calcula(litragem, preco));

            cervejas.add(cerveja)
            txt_marca.text.clear()
            txt_preco.text.clear()
        })

        bt_listar.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, ListCervejasActivity::class.java)

            cervejas.sortBy({selector(it)})

            intent.putParcelableArrayListExtra("cervejas", cervejas)
            startActivity(intent)
        })
    }



    fun selector(cerveja: Cerveja) : Double = cerveja.precolitro

    fun calcula (l: Int, p: Double): Double {
        return when(l) {
            0 -> (p / 300)*1000
            1 -> (p / 350)*1000
            2 -> (p / 355)*1000
            3 -> (p / 550)*1000
            4 -> (p / 600)*1000
            else ->  p
        }
    }
}



