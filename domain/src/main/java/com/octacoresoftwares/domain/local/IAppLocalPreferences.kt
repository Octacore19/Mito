package com.octacoresoftwares.domain.local

interface IAppLocalPreferences {
    fun saveAccessToken(token: String?)

    fun getAccessToken(): String?

    fun setRefreshToken(token: String?)

    fun getRefreshToken(): String?

    fun setExpiryTime(time: Long)

    fun getExpiryTime(): Long

    fun setUserLoggedIn()

    fun getUserLoggedIn(): Boolean

    fun logOut(type: Int)

    fun setValidationToken(token: String?)

    fun getValidationToken(): String?

    fun getUserRegistrationStatus(): Boolean

    fun setUserRegistrationStatus(fullyRegistered: Boolean)

    fun setDeviceId(deviceId: String?)

    fun getDeviceId(): String?

    fun setAppFirstTimeLaunch(value: Boolean)

    fun getAppFirstTimeLaunch(): Boolean

    fun clearUserPreference()
}