package com.example.ladm_u1_practica2_almacenamiento_archivos.ui.gallery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ladm_u1_practica2_almacenamiento_archivos.CustomAdapter
import com.example.ladm_u1_practica2_almacenamiento_archivos.CustomAdapter2
import com.example.ladm_u1_practica2_almacenamiento_archivos.CustomAdapter2.Companion.detail
import com.example.ladm_u1_practica2_almacenamiento_archivos.CustomAdapter2.Companion.titles
import com.example.ladm_u1_practica2_almacenamiento_archivos.R
import com.example.ladm_u1_practica2_almacenamiento_archivos.databinding.FragmentGalleryBinding
import com.example.ladm_u1_practica2_almacenamiento_archivos.ui.home.HomeFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private var titulos = ArrayList<String>()
    private var detalles = ArrayList<String>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recycleView
        val adapter = CustomAdapter2()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        leerArchivo(requireContext())

        binding.guardar.setOnClickListener{
            guardarArchivo(requireContext())
            leerArchivo(requireContext())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun guardarArchivo(context: Context){
        try {
            var archivo = OutputStreamWriter(context.openFileOutput("archivo.txt", 0))

            titles.add(binding.nombre.text.toString())
            detail.add(binding.detalles.text.toString())

            var cadena = ""
            for(i in 0 until titles.size){
                val ti = titles[i]
                val de = detail[i]
                cadena += ti + "&&" + de + "\n"
            }
            archivo.write(cadena)
            archivo.flush()
            archivo.close()

            binding.nombre.setText("")
            binding.detalles.setText("")
            AlertDialog.Builder(context).setMessage("Se guardo la informacion").show()
        } catch (e:Exception){
            AlertDialog.Builder(context).setMessage(e.message).show()
        }

    }

    fun leerArchivo(context: Context){ //requiereContext
        try {
            var archivo = BufferedReader(InputStreamReader(context.openFileInput("archivo.txt")))
            var cadena = archivo.readLines()
            titles.clear()
            detail.clear()
            for(i in cadena){
                val det = i.split("&&")
                titles.add(det[0])
                detail.add(det[1])
            }
        } catch (e:Exception){
            AlertDialog.Builder(context).setMessage(e.message).show()
        }
    }
}