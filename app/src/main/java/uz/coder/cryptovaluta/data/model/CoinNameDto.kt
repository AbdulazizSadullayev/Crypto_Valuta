package uz.coder.cryptovaluta.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinNameDto(
    @SerializedName("Name")
    @Expose
    val name: String? = null,
    )