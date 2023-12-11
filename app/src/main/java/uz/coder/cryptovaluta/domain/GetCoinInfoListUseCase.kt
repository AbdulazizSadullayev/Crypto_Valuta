package uz.coder.cryptovaluta.domain

import uz.coder.cryptovaluta.data.CoinInfoRepositoryImpl


class GetCoinInfoListUseCase(private val repository: CoinInfoRepositoryImpl) {

    operator fun invoke()=repository.getCoinInfoList()
}