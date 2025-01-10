package ml.vladmikh.projects.bankcard.data.model



data class CardInfo(
    val id: Int,
    val bankCity: String,
    val bankName: String,
    val bankPhone: String,
    val bankUrl: String,
    val brand: String,
    val countryAlpha2: String,
    val countryCurrency: String,
    val countryEmoji: String,
    val countryLatitude: Int,
    val countryLongitude: Int,
    val countryName: String,
    val countryNumeric: String,
    val numberLength: Int,
    val numberLuhn: Boolean,
    val prepaid: String,
    val scheme: String,
    val type: String
)
