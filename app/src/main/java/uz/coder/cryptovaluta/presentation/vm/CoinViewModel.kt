package uz.coder.cryptovaluta.presentation.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uz.coder.cryptovaluta.data.CoinInfoRepositoryImpl
import uz.coder.cryptovaluta.domain.GetCoinInfoListUseCase
import uz.coder.cryptovaluta.domain.GetCoinInfoUseCase
import uz.coder.cryptovaluta.domain.LoadDataUseCase


class CoinViewModel(application: Application) : AndroidViewModel(application) {
    val repository = CoinInfoRepositoryImpl(application)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSmy: String) = getCoinInfoUseCase(fSmy)

    init {
        loadDataUseCase()
    }


}