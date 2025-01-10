package ml.vladmikh.projects.bankcard.ui.history

import ml.vladmikh.projects.bankcard.data.model.CardInfo
import ml.vladmikh.projects.bankcard.util.ErrorLoadingCard

sealed interface HistoryUIState {

    object Initial: HistoryUIState
    object Loading : HistoryUIState
    data class Loaded(val cards: List<CardInfo>) : HistoryUIState
    data class Error(val error: ErrorLoadingCard) : HistoryUIState
}