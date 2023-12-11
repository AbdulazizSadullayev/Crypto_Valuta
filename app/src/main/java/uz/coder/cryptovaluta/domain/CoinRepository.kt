package uz.coder.cryptovaluta.domain

import androidx.lifecycle.LiveData
import uz.coder.cryptovaluta.domain.CoinInfo

interface CoinRepository {
    fun getCoinInfoList():LiveData<List<CoinInfo>>
    fun getCoin(fromSymbol: String):LiveData<CoinInfo>

     fun loadData()

}