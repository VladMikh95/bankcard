package ml.vladmikh.projects.bankcard.data.network.model

data class Number(
    val length: Int,
    val luhn: Boolean
)