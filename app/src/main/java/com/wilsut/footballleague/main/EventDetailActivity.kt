package com.wilsut.footballleague.main

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import com.wilsut.footballleague.R
import com.wilsut.footballleague.model.Event
import org.jetbrains.anko.*
import java.text.SimpleDateFormat
import java.util.*

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val event = intent.getParcelableExtra<Event>("event")
        scrollView {
            lparams(matchParent, matchParent) {
                setPadding(dip(16), 0, dip(16), 0)
            }

            linearLayout {
                lparams(matchParent, wrapContent) {
                    orientation = LinearLayout.VERTICAL
                }

                linearLayout {
                    lparams(matchParent, wrapContent) {
                        orientation = LinearLayout.VERTICAL
                    }

                    textView {
                        var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
                        val date = sdf.parse(event.dateEvent)
                        sdf = SimpleDateFormat("E, d MMM yyyy", Locale.US)
                        text = sdf.format(date)
                        gravity = Gravity.CENTER
                        textAppearance = android.R.style.TextAppearance_Medium
                    }.lparams(matchParent, wrapContent)

                    //  Team
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                        }

                        textView {
                            text = event.homeTeam
                            gravity = Gravity.START
                            textAppearance = android.R.style.TextAppearance_Medium
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView("VS") {
                            gravity = Gravity.CENTER
                            textAppearance = android.R.style.TextAppearance_Medium
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView {
                            text = event.awayTeam
                            gravity = Gravity.END
                            textAppearance = android.R.style.TextAppearance_Medium
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }
                    }

                    view {
                        backgroundResource = R.color.colorPrimary
                    }.lparams(matchParent, dip(1)) {
                        setMargins(
                            0,
                            dip(8),
                            0,
                            dip(8)
                        )
                    }

                    //  Goals
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                        }

                        textView {
                            text = event.homeScore
                            gravity = Gravity.START
                            textAppearance = android.R.style.TextAppearance_Medium
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView("Goals") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView {
                            text = event.awayScore
                            gravity = Gravity.END
                            textAppearance = android.R.style.TextAppearance_Medium
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }
                    }

                    //  Scorer
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                        }

                        textView {
                            text = event.homeGoalDetails
                            gravity = Gravity.START
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView("Scorer") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView {
                            text = event.awayGoalDetails
                            gravity = Gravity.END
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }
                    }

                    view {
                        backgroundResource = R.color.colorPrimary
                    }.lparams(matchParent, dip(1)) {
                        setMargins(
                            0,
                            dip(8),
                            0,
                            dip(8)
                        )
                    }

                    //  Line Up GK
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                            setMargins(
                                0,
                                dip(8),
                                0,
                                dip(8)
                            )
                        }

                        textView {
                            text = event.homeLineGk
                            gravity = Gravity.START
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }

                        textView("Goal Keeper") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }

                        textView {
                            text = event.awayLineGk
                            gravity = Gravity.END
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }
                    }

                    //  Line Up Defense
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                            setMargins(
                                0,
                                dip(8),
                                0,
                                dip(8)
                            )
                        }

                        textView {
                            text = event.homeLineDef
                            gravity = Gravity.START
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }

                        textView("Defense") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }

                        textView {
                            text = event.awayLineDef
                            gravity = Gravity.END
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }
                    }

                    //  Line Up Midfield
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                            setMargins(
                                0,
                                dip(8),
                                0,
                                dip(8)
                            )
                        }

                        textView {
                            text = event.homeLineMid
                            gravity = Gravity.START
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }

                        textView("Midfield") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }

                        textView {
                            text = event.awayLineMid
                            gravity = Gravity.END
                        }.lparams(dip(0), wrapContent) {
                            weight = 0.5F
                        }
                    }

                    //  Line Up Forward
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                            setMargins(
                                0,
                                dip(8),
                                0,
                                dip(8)
                            )
                        }

                        textView {
                            text = event.homeLineFor
                            gravity = Gravity.START
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView("Forward") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView {
                            text = event.awayLineFor
                            gravity = Gravity.END
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }
                    }

                    //  Line Up Subs
                    linearLayout {
                        lparams(matchParent, wrapContent) {
                            orientation = LinearLayout.HORIZONTAL
                            setMargins(
                                0,
                                dip(8),
                                0,
                                dip(8)
                            )
                        }

                        textView {
                            text = event.homeSubs
                            gravity = Gravity.START
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView("Substitute") {
                            gravity = Gravity.CENTER
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }

                        textView {
                            text = event.awaySubs
                            gravity = Gravity.END
                        }.lparams(dip(0), wrapContent) {
                            weight = 1F
                        }
                    }
                }
            }
        }
    }
}