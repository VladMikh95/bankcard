package ml.vladmikh.projects.bankcard.data.network.model

data class CardInfoRemoteDataSource(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)