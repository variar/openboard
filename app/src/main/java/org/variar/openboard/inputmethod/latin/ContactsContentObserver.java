/*
 * Copyright (C) 2014 The Android Open Source Project
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

package org.variar.openboard.inputmethod.latin;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.ContactsContract.Contacts;

import org.variar.openboard.inputmethod.latin.ContactsManager.ContactsChangedListener;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A content observer that listens to updates to content provider {@link Contacts#CONTENT_URI}.
 */
public class ContactsContentObserver implements Runnable {
    private static final String TAG = "ContactsContentObserver";

    private final Context mContext;
    private final ContactsManager mManager;
    private final AtomicBoolean mRunning = new AtomicBoolean(false);

    private ContentObserver mContentObserver;
    private ContactsChangedListener mContactsChangedListener;

    public ContactsContentObserver(final ContactsManager manager, final Context context) {
        mManager = manager;
        mContext = context;
    }

    public void registerObserver(final ContactsChangedListener listener) {
        return;
    }

    @Override
    public void run() {
        unregister();
        return;
    }

    boolean haveContentsChanged() {
        return false;
    }

    public void unregister() {
        mContext.getContentResolver().unregisterContentObserver(mContentObserver);
    }
}
