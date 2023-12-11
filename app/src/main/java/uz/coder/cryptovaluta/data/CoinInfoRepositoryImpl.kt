package uz.coder.cryptovaluta.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import uz.coder.cryptovaluta.data.database.AppDatabase
import uz.coder.cryptovaluta.data.mapper.CoinMapper
import uz.example.cryptovalyuta.data.workers.MyRefreshWorker
import uz.coder.cryptovaluta.domain.CoinInfo
import uz.coder.valutakursi.domain.CoinRepository

class CoinInfoRepositoryImpl(private var application: Application) : CoinRepository {
    private val coinInfoDao = AppDatabase.getInstens(application).coinPriceInfoDao()
    private val mapper = CoinMapper()


    override fun getCoinInfoList(): LiveData<List<CoinInfo>> =
        MediatorLiveData<List<CoinInfo>>().apply {
            addSource(coinInfoDao.getPriceList()) {
                value = mapper.mapListDbModelToEntity(it)
            }
        }


    override fun getCoin(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceCoinInfoAbout(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {
        val worker = WorkManager.getInstance(application)
        worker.enqueueUniqueWork(
            MyRefreshWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            MyRefreshWorker.makeRequest()
        )
    }

}