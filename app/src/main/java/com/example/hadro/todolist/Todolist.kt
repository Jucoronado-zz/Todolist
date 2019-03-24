package com.example.hadro.todolist

import android.annotation.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Todolist : AppCompatActivity() {
    var lang = arrayOf(" ", "marcos","Jose")


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_todolist)

        val texto = findViewById(R.id.text) as EditText
        val boton1 = findViewById(R.id.boton) as Button

        var Lista1 = findViewById<ListView>(R.id.lista)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lang)
        Lista1.adapter = adapter


        Lista1.setOnItemClickListener { adapterViewAdapter, view, i, id ->

            when(i){
                0 ->  Toast.makeText(applicationContext, "No se Puede eliminar ", Toast.LENGTH_SHORT).show()
                else ->  eliminar(i)
            } }

        boton1.setOnClickListener{

                val tarea = texto.text.toString()
            agregar(tarea)
        }

        }

    private fun agregar(tarea: String) {
        lang.addAll(tarea)
        notifyDataSetChanged()
    }

    private fun eliminar (pos : Int) {
        lang.remove(pos)
        notifyDataSetChanged()
    }
}
