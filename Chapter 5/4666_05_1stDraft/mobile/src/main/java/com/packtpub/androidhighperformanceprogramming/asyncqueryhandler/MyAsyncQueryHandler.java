package com.packtpub.androidhighperformanceprogramming.asyncqueryhandler;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;

public class MyAsyncQueryHandler extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AsyncQueryHandler asyncQueryHandler = new AsyncQueryHandler(getContentResolver()) {
            @Override
            protected void onDeleteComplete(int token, Object cookie, int result) {
                //code to handle the delete operation...
            }

            @Override
            protected void onUpdateComplete(int token, Object cookie, int result) {
                //code to handle the update operation...
            }

            @Override
            protected void onInsertComplete(int token, Object cookie, Uri uri) {
                //code to handle the insert operation...
            }

            @Override
            protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
                //code to handle the query operation...
            }
        };
        String contentUri = null;
        String projection[] = null;
        String selectionClause = null;
        String selectionArgs[] = null;
        String sortOrder = null;
        asyncQueryHandler.startQuery(1, null,
                UserDictionary.CONTENT_URI,
                projection,
                selectionClause,
                selectionArgs,
                sortOrder);
    }
}
