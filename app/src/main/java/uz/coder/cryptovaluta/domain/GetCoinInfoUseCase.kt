package uz.coder.cryptovaluta.domain

import uz.coder.cryptovaluta.data.CoinInfoRepositoryImpl


class GetCoinInfoUseCase(private val repository: CoinInfoRepositoryImpl) {
    operator fun invoke(fromSymbol: String) = repository.getCoin(fromSymbol)
}