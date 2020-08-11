package gg.paiva.jetpackexploration.map.models

import com.google.gson.annotations.SerializedName

data class CameraModelRoot(
    @SerializedName("items")
    val itemsList: List<Item>
)

data class Item(
    val timestamp: String,
    val cameras: List<CamerasElement>
)

data class CamerasElement(
    val timestamp: String,
    val image: String,
    val location: CameraLocation,
    val camera_id: String,
    val image_metadata: ImageMetaData
)

data class CameraLocation(
    val latitude: Double,
    val longitude: Double
)

data class ImageMetaData(
    val height: String,
    val width: String,
    val md5: String
)
