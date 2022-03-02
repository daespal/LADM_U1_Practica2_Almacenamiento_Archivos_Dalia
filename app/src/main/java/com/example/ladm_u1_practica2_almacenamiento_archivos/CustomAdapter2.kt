package com.example.ladm_u1_practica2_almacenamiento_archivos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ladm_u1_practica2_almacenamiento_archivos.R

class CustomAdapter2: RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {

    companion object{
        var titles= mutableListOf<String>()

        var detail= mutableListOf<String>()

        var indice:Int=0
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text= detail[i]
        viewHolder.itemImage.setImageResource(R.drawable.semillas12)
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