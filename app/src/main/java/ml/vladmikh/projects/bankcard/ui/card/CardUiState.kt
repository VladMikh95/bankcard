package ml.vladmikh.projects.bankcard.ui.card

import ml.vladmikh.projects.bankcard.data.model.CardInfo
import ml.vladmikh.projects.bankcard.util.ErrorLoadingCard

sealed interface CardUIState {

    object Initial: CardUIState
    object Loading : CardUIState
    data class Loaded(val cardInfo: CardInfo) : CardUIState
    data class Error(val error: ErrorLoadingCard) : CardUIState
}