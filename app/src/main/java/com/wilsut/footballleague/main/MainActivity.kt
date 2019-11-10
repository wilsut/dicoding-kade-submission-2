package com.wilsut.footballleague.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.wilsut.footballleague.R
import com.wilsut.footballleague.model.League
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var leagues: MutableList<League> = mutableListOf()
    private lateinit var adapter: MainAdapter
    private lateinit var listLeague: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)

            relativeLayout {
                lparams(width = matchParent, height = wrapContent)

                listLeague = recyclerView {
                    lparams(width = matchParent, height = wrapContent)
                    layoutManager = LinearLayoutManager(context)
                }

            }
        }

        adapter = MainAdapter(leagues)
        {
            startActivity<LeagueActivity>(
                "league_name" to it.league
            )
        }
        listLeague.adapter = adapter

        initData()
    }

    private fun initData() {
        val id = resources.getStringArray(R.array.id)
        val name = resources.getStringArray(R.array.league)
        val badge = resources.getStringArray(R.array.badge)
        leagues.clear()
        for (i in name.indices) {
            leagues.add(
                League(
                    leagueId = id[i],
                    league = name[i],
                    badge = badge[i]
                )
            )
        }
    }
}