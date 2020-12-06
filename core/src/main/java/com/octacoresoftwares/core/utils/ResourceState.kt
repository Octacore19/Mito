package com.octacoresoftwares.core.utils

class ResourceState <out D> constructor(
    val state: AppState,
    val message: String? = null,
    val data: D? = null
){
    companion object {
        @JvmStatic
        fun <D> success(
            data: D?,
            message: String?): ResourceState<D> = ResourceState(
            state = AppState.SUCCESS,
            data = data,
            message = message
        )

        @JvmStatic
        fun <D> warning(
            message: String?
        ): ResourceState<D> = ResourceState(
            state = AppState.WARNING,
            message = message
        )

        @JvmStatic
        fun <D> validationFailed(
            message: String?
        ): ResourceState<D> = ResourceState(
            state = AppState.VALIDATION_FAILED,
            message = message
        )

        @JvmStatic
        fun <D> failed(
            data: D?,
            message: String?
        ): ResourceState<D> = ResourceState(
            state = AppState.FAILED,
            data = data,
            message = message
        )

        @JvmStatic
        fun <D> loading(): ResourceState<D> = ResourceState(
            state = AppState.LOADING
        )

        @JvmStatic
        fun <D> loadingMore(): ResourceState<D> = ResourceState(
            state = AppState.LOADING_MORE
        )
    }
}