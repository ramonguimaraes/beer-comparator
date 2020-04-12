package com.ramonguimaraes.beercomparator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_cervejas.*
import java.util.ArrayList

class ListCervejasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cervejas)
        var intent: Intent = getIntent()
        var cervejas: ArrayList<Cerveja> = intent.getParcelableArrayListExtra("cervejas")

        rcv_main.adapter = CervejaAdapter(cervejas, this)
        rcv_main.layoutManager = LinearLayoutManager(this)
    }
}
