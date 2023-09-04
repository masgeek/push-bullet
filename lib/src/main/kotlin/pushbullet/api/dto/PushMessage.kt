package pushbullet.api.dto

import com.fasterxml.jackson.annotation.JsonProperty


class PushMessage(
    @JsonProperty("device_iden") var deviceIdentity: String,
    @JsonProperty("guid") var guid: String,
    @JsonProperty("title") var title: String,
    @JsonProperty("body") var body: String,
    @JsonProperty("type") var pushType: String = "note"
)
