package edu.kabi.live.logic.model

data class Live(
    val _id: String,
    val creatorId: String,
    val name: String,
    val description: String,
    val followersIds: List<String>,
    val url: String
) {

}