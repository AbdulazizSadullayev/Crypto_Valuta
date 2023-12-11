package uz.coder.cryptovaluta.presentation

import androidx.recyclerview.widget.DiffUtil
import uz.coder.cryptovaluta.domain.CoinInfo

class CoinDiffCallback():DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}