package ml.vladmikh.projects.bankcard.data.network.model

data class Country(
    val alpha2: String,
    val currency: String,
    val emoji: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val numeric: String
)