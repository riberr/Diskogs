package me.riberr.diskogs.models.response.user.identity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: Int,
    val username: String,
    val profile: String,
    @SerialName("wantlist_url")
    val wantListUrl: String,
    val rank: Float,
    @SerialName("num_pending")
    val numPending: Int,
    @SerialName("num_for_sale")
    val numForSale: Int,
    @SerialName("home_page")
    val homePage: String,
    val location: String,
    @SerialName("collection_folders_url")
    val collectionFoldersUrl: String,
    @SerialName("collection_fields_url")
    val collectionFieldsUrl: String,
    @SerialName("releases_contributed")
    val releasesContributed: Int,
    val registered: String,
    @SerialName("rating_avg")
    val ratingAvg: Float,
    @SerialName("num_collection")
    val numCollection: Int,
    @SerialName("releases_rated")
    val releasesRated: Int,
    @SerialName("num_lists")
    val numLists: Int,
    val name: String,
    @SerialName("num_wantlist")
    val numWantlist: Int,
    @SerialName("inventory_url")
    val inventoryUrl: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("banner_url")
    val bannerUrl: String,
    val uri: String,
    @SerialName("resource_url")
    val resourceUrl: String,
    @SerialName("buyer_rating")
    val buyerRating: Float,
    @SerialName("buyer_rating_stars")
    val buyerRatingStars: Float,
    @SerialName("buyer_num_ratings")
    val buyerNumRatings: Int,
    @SerialName("seller_rating")
    val sellerRating: Float,
    @SerialName("seller_rating_stars")
    val sellerRatingStars: Float,
    @SerialName("seller_num_ratings")
    val sellerNumRatings: Int,
    @SerialName("curr_abbr")
    val currAbbr: String,
    val activated: Boolean,
    @SerialName("marketplace_suspended")
    val marketplaceSuspended: Boolean,
    @SerialName("is_staff")
    val isStaff: Boolean,
    val email: String?,
    @SerialName("num_unread")
    val numUnread: Int?
)