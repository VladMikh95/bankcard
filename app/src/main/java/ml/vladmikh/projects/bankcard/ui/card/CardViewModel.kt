package ml.vladmikh.projects.bankcard.ui.card

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ml.vladmikh.projects.bankcard.data.network.model.CardInfoRemoteDataSource
import ml.vladmikh.projects.bankcard.data.repository.CardInfoRemoteDataSourceRepository
import javax.inject.Inject


@HiltViewModel
class CardViewModel @Inject constructor(
    private val repository: CardInfoRemoteDataSourceRepository
) : ViewModel(){

    private var _cardInfo = MutableLiveData<CardInfoRemoteDataSource>()
    val cardInfo: LiveData<CardInfoRemoteDataSource> get() = _cardInfo



    fun getCardInfoRemoteDataSource() {
        viewModelScope.launch {
            try {
                _cardInfo.value = repository.getCardInfo(45717360)
                Log.i("abc", _cardInfo.value.toString())
            } catch (e: Exception) {

            }
        }
}
}