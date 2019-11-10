package com.wilsut.footballleague

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class RecyclerViewAdapter(
    private val context: Context,
    private val items: List<Item>,
    private val listener: (Item) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class RecyclerUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout() {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.image
                    }.lparams {
                        width = dip(50)
                        height = dip(50)
                    }

                    textView {
                        id = R.id.name
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                        margin = dip(10)
                        gravity = Gravity.CENTER_VERTICAL
                    }
                }
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.find(R.id.name)
        private val image: ImageView = view.find(R.id.image)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RecyclerUI().createView(AnkoContext.create(parent.context, parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size
}