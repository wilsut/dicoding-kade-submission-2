package com.wilsut.footballleague.model

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("idLeague")
    var leagueId: String? = null,

    @SerializedName("strLeague")
    var league: String? = null,

    @SerializedName("strCountry")
    var country: String? = null,

    @SerializedName("strBadge")
    var badge: String? = null
)