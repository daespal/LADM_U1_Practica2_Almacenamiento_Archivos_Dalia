package com.example.ladm_u1_practica2_almacenamiento_archivos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ladm_u1_practica2_almacenamiento_archivos.R

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val titles= arrayOf("Pepino","Jitomate","Frijol","Calabaza","Tomate Verde","Berenjena",
    "Maiz","Chile","Tamarindo","Mango","Guanabana")

    val detail= arrayOf("Verdura","Verdura","Verdura","Verdura","Verdura",
        "Verdura","Verdura","Verdura","Fruta","Fruta","Fruta")

    val images= intArrayOf(R.drawable.semillas9,R.drawable.semillas5,R.drawable.semillas2,
        R.drawable.semillas3,R.drawable.semillas6,R.drawable.semillas10,R.drawable.semillas1,
        R.drawable.semillas4,R.drawable.semillas11,R.drawable.semillas7,R.drawable.semillas8)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text= detail[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var itemImage: ImageView
        lateinit var itemTitle: TextView
        lateinit var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.imagen)
            itemTitle = itemView.findViewById(R.id.titulo)
            itemDetail = itemView.findViewById(R.id.detalles)
        }

    }
}