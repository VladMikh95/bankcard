package ml.vladmikh.projects.bankcard.ui.card

import ml.vladmikh.projects.bankcard.data.network.model.CardInfoRemoteDataSource
import ml.vladmikh.projects.bankcard.util.ErrorLoadingCard

sealed interface CardUIState {

    object Initial: CardUIState
    object Loading : CardUIState
    data class Loaded(val cardInfo: CardInfoRemoteDataSource) : CardUIState
    data class Error(val error: ErrorLoadingCard) : CardUIState
}