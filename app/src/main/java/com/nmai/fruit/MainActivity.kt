package com.nmai.fruit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nmai.fruit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var itemAdapter: ItemAdapter
   // lateinit var itemAdapter2: ItemAdapter2

    var listItem = listOf<Item>(
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1),
        Item("orange", 1f, 123f, "none", R.drawable.img_orange_1)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemAdapter = ItemAdapter(this)
        itemAdapter.addAll(listItem)
//        itemAdapter2 = ItemAdapter2(this)
//        itemAdapter2.submitList(listItem)
        binding.rcv.apply {
            adapter = itemAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)

        }
//        itemAdapter2.onClick = {item->
//            item.name = "a"
//        }

//    binding.btn.setOnClickListener {
//
//        var intent = Intent(this, MainActivity2::class.java)
//        intent.putExtra("item", Item("orange", 1f, 123f, "none", R.drawable.img_orange_1))
//
//        var bundle = Bundle()
//        bundle.putString("key", "name")
//
//        intent.putExtras( bundle)
//        startActivity(intent)
//
//    }


    }

}