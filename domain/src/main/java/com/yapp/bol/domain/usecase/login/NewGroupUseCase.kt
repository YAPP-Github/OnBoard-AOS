package com.yapp.bol.domain.usecase.login

import com.yapp.bol.domain.model.ApiResult
import com.yapp.bol.domain.model.NewGroupItem
import com.yapp.bol.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Inject

class NewGroupUseCase @Inject constructor(
    private val repository: Repository
) {
    fun postFileUpload(token: String, file: File): Flow<ApiResult<String>> {
        return repository.postFileUpload(token, file)
    }

    fun postCreateGroup(
        name: String,
        description: String,
        organization: String,
        profileImageUrl: String,
        nickname: String,
    ): Flow<ApiResult<NewGroupItem>> {
        return repository.postCreateGroup(name, description, organization, profileImageUrl, nickname)
    }
}
