package com.clintpauldev.zomatosampleapp.data.remote.responses

data class LocationResponse(
    val link: String,
    val location: Location,
    val nearby_restaurants: List<NearbyRestaurant>,
    val popularity: Popularity
)

data class Location(
    val city_id: Int,
    val city_name: String,
    val country_id: Int,
    val country_name: String,
    val entity_id: Int,
    val entity_type: String,
    val latitude: String,
    val longitude: String,
    val title: String
)

data class NearbyRestaurant(
    val restaurant: Restaurant
)

data class Popularity(
    val city: String,
    val nearby_res: List<String>,
    val nightlife_index: String,
    val nightlife_res: String,
    val popularity: String,
    val popularity_res: String,
    val subzone: String,
    val subzone_id: Int,
    val top_cuisines: List<String>
)

data class Restaurant(
    val R: R,
    val apikey: String,
    val average_cost_for_two: Int,
    val book_again_url: String,
    val book_form_web_view_url: String,
    val book_url: String,
    val cuisines: String,
    val currency: String,
    val deeplink: String,
    val events_url: String,
    val featured_image: String,
    val has_online_delivery: Int,
    val has_table_booking: Int,
    val id: String,
    val include_bogo_offers: Boolean,
    val is_book_form_web_view: Int,
    val is_delivering_now: Int,
    val is_table_reservation_supported: Int,
    val is_zomato_book_res: Int,
    val location: LocationX,
    val medio_provider: Any,
    val menu_url: String,
    val mezzo_provider: String,
    val name: String,
    val offers: List<Any>,
    val opentable_support: Int,
    val order_deeplink: String,
    val order_url: String,
    val photos_url: String,
    val price_range: Int,
    val store_type: String,
    val switch_to_order_menu: Int,
    val thumb: String,
    val url: String,
    val user_rating: UserRating
)

data class R(
    val has_menu_status: HasMenuStatus,
    val is_grocery_store: Boolean,
    val res_id: Int
)

data class LocationX(
    val address: String,
    val city: String,
    val city_id: Int,
    val country_id: Int,
    val latitude: String,
    val locality: String,
    val locality_verbose: String,
    val longitude: String,
    val zipcode: String
)

data class UserRating(
    val aggregate_rating: String,
    val rating_color: String,
    val rating_obj: RatingObj,
    val rating_text: String,
    val votes: Int
)

data class HasMenuStatus(
    val delivery: Any,
    val takeaway: Int
)

data class RatingObj(
    val bg_color: BgColor,
    val title: Title
)

data class BgColor(
    val tint: String,
    val type: String
)

data class Title(
    val text: String
)