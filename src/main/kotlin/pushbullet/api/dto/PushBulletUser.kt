package pushbullet.api.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class PushBulletUser(
    @JsonProperty("active")
    val active: Boolean? = null,
    @JsonProperty("iden")
    val userIdentity: String? = null,
    @JsonProperty("created")
    val created: String? = null,
    @JsonProperty("modified")
    val modified: String? = null,
    @JsonProperty("email")
    val email: String? = null,
    @JsonProperty("email_normalized")
    val emailNormalized: String? = null,
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("image_url")
    val imageUrl: String? = null,
    @JsonProperty("max_upload_size")
    val maxUploadSize: Int? = null
)
