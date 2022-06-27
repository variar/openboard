/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.variar.openboard.inputmethod.latin.spellcheck;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.text.TextUtils;

import org.variar.openboard.inputmethod.latin.R;
import org.variar.openboard.inputmethod.latin.permissions.PermissionsManager;
import org.variar.openboard.inputmethod.latin.settings.SubScreenFragment;
import org.variar.openboard.inputmethod.latin.settings.TwoStatePreferenceHelper;
import org.variar.openboard.inputmethod.latin.utils.ApplicationUtils;

/**
 * Preference screen.
 */
public final class SpellCheckerSettingsFragment extends SubScreenFragment
    implements SharedPreferences.OnSharedPreferenceChangeListener,
            PermissionsManager.PermissionsResultCallback {

    private SwitchPreference mLookupContactsPreference;

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addPreferencesFromResource(R.xml.spell_checker_settings);
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.setTitle(ApplicationUtils.getActivityTitleResId(
                getActivity(), SpellCheckerSettingsActivity.class));
        TwoStatePreferenceHelper.replaceCheckBoxPreferencesBySwitchPreferences(preferenceScreen);

        mLookupContactsPreference = (SwitchPreference) findPreference(
                AndroidSpellCheckerService.PREF_USE_CONTACTS_KEY);
        turnOffLookupContactsIfNoPermission();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (!TextUtils.equals(key, AndroidSpellCheckerService.PREF_USE_CONTACTS_KEY)) {
            return;
        }

        if (!sharedPreferences.getBoolean(key, false)) {
            // don't care if the preference is turned off.
            return;
        }

        mLookupContactsPreference.setChecked(false);
    }

    @Override
    public void onRequestPermissionsResult(boolean allGranted) {
        turnOffLookupContactsIfNoPermission();
    }

    private void turnOffLookupContactsIfNoPermission() {
        mLookupContactsPreference.setChecked(false);
    }
}
