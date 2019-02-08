package com.itg.calderysapp.test.model

import com.google.gson.annotations.SerializedName

data class Messages(

	@field:SerializedName("Status")
	val status: Int? = null,

	@field:SerializedName("UpdatedBy")
	val updatedBy: String? = null,

	@field:SerializedName("Type")
	val type: Any? = null,

	@field:SerializedName("Active")
	val active: Boolean? = null,

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("CreatedBy")
	val createdBy: String? = null,

	@field:SerializedName("Message")
	val message: Any? = null,

	@field:SerializedName("UpdatedOn")
	val updatedOn: String? = null,

	@field:SerializedName("CreatedOn")
	val createdOn: String? = null,

	@field:SerializedName("IMID")
	val iMID: Int? = null
)