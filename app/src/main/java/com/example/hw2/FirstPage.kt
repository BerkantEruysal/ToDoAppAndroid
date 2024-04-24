package com.example.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hw2.databinding.FragmentFirstPageBinding


class FirstPage : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var myAdapter: ToDoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstPageBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myList = mutableListOf(
            Item("Bulaşık yıkanacak", "çok birikti"),
            Item("Çamaşır yıkanacak", "beyaz sirke dene"),
            Item("Tuz bitti", "Migros'ta indirim var"),
        )

        myAdapter = ToDoAdapter(myList)
        binding.recyclerview.adapter = myAdapter

        // Butona tıklama dinleyicisi ekleme
        binding.button2.setOnClickListener {
            val title = binding.editTextText.text.toString()
            val description = binding.editTextText2.text.toString()

            if (title.isEmpty() || description.isEmpty()) {
                // Bir veya her iki input alanı boşsa hata mesajı göster
                Toast.makeText(requireContext(), "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
            } else {
                // Her iki input alanı da dolu ise yeni bir öğe oluştur ve RecyclerView'e ekle
                val newItem = Item(title, description)
                myList.add(newItem)
                myAdapter.notifyDataSetChanged()

                // Input alanlarını temizle
                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()
            }
        }
    }


}