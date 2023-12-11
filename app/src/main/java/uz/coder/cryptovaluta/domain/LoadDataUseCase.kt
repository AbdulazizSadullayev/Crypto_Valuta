package uz.coder.cryptovaluta.domain

import uz.coder.cryptovaluta.data.CoinInfoRepositoryImpl


class LoadDataUseCase(private val repository: CoinInfoRepositoryImpl) {
 operator fun invoke() = repository.loadData()
}