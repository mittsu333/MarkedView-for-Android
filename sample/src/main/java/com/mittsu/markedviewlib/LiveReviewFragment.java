package com.mittsu.markedviewlib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mittsu.markedview.MarkedView;

public final class LiveReviewFragment  extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_live_preview, container, false);

        final MarkedView markedView = (MarkedView) view.findViewById(R.id.live_md_view);
        final EditText edit = (EditText) view.findViewById(R.id.edit_text);
        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String markdownText = editable.toString();
                Log.d(TAG, markdownText);
                markedView.setMDText(markdownText);
            }
        });

        return view;
    }

}
