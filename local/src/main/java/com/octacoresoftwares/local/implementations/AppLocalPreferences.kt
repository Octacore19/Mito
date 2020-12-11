package com.octacoresoftwares.local.implementations

import android.content.Context
import androidx.core.content.edit
import com.octacoresoftwares.local.Constants
import com.octacoresoftwares.domain.local.IAppLocalPreferences
import javax.inject.Inject

class AppLocalPreferences @Inject constructor(context: Context): IAppLocalPreferences {

    private val preferences by lazy {
        context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    override fun saveAccessToken(token: String?) {
        preferences.edit {
            putString(Constants.ACCESS_TOKEN, token)
            apply()
        }
    }

    override fun getAccessToken(): String? = preferences.getString(
        Constants.ACCESS_TOKEN,
        ""
    )

    override fun setRefreshToken(token: String?) {
        preferences.edit {
            putString(Constants.REFRESH_TOKEN, token)
            apply()
        }
    }

    override fun getRefreshToken(): String? = preferences.getString(
        Constants.REFRESH_TOKEN,
        ""
    )

    override fun setExpiryTime(time: Long) {
        preferences.edit {
            putLong(Constants.EXPIRY_TIME, time)
            apply()
        }
    }

    override fun getExpiryTime(): Long = preferences.getLong(
        Constants.EXPIRY_TIME,
        0L
    )

    override fun setUserLoggedIn() {
        preferences.edit {
            putBoolean(Constants.USER_LOGGED_IN, true)
            apply()
        }
    }

    override fun getUserLoggedIn(): Boolean = preferences.getBoolean(
        Constants.USER_LOGGED_IN,
        false
    )

    override fun logOut(type: Int) {
        TODO("Not yet implemented")
    }

    override fun setValidationToken(token: String?) {
        preferences.edit {
            putString(Constants.VALIDATION_TOKEN, token)
            apply()
        }
    }

    override fun getValidationToken(): String? = preferences.getString(
        Constants.VALIDATION_TOKEN,
        ""
    )

    override fun getUserRegistrationStatus(): Boolean = preferences.getBoolean(
        Constants.REGISTRATION_STATUS,
        false
    )

    override fun setUserRegistrationStatus(fullyRegistered: Boolean) {
        preferences.edit {
            putBoolean(Constants.REGISTRATION_STATUS, fullyRegistered)
            apply()
        }
    }

    override fun setDeviceId(deviceId: String?) {
        preferences.edit {
            putString(Constants.DEVICE_ID, deviceId)
            apply()
        }
    }

    override fun getDeviceId(): String? = preferences.getString(
        Constants.DEVICE_ID,
        ""
    )

    override fun setAppFirstTimeLaunch(value: Boolean) {
        preferences.edit {
            putBoolean(Constants.APP_FIRST_LAUNCH, value)
            apply()
        }
    }

    override fun getAppFirstTimeLaunch(): Boolean = preferences.getBoolean(
        Constants.APP_FIRST_LAUNCH,
        false
    )

    override fun clearUserPreference() {
        preferences.edit {
            clear()
            apply()
        }
    }
}