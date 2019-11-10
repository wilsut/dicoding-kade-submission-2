package com.wilsut.footballleague

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        club_list.layoutManager = LinearLayoutManager(this)
//        club_list.adapter = RecyclerViewAdapter(this, items) {
//            startActivity<DetailActivity>(
//                "name" to it.name,
//                "description" to it.description,
//                "image" to it.image
//            )
//        }

        verticalLayout {
            recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(context)
                adapter = RecyclerViewAdapter(context, items) {
                    startActivity<DetailActivity>(
                        "extra_item" to it
                    )
                }
            }
        }

        initData()
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = League.description
        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    name[i],
                    image.getResourceId(i, 0),
                    description[i]
                )
            )
        }

        //Recycle the typed array
        image.recycle()
    }
}
