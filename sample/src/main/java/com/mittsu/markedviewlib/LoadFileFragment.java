package com.mittsu.markedviewlib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mittsu.markedview.MarkedView;

import java.io.File;

public final class LoadFileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_load_mdfile, container, false);

        FileCopyManager fcm = new FileCopyManager(getActivity());
        MarkedView mdView = (MarkedView)view.findViewById(R.id.md_view);
        // code block in scrolling be deactivated.
        // mdView.setCodeScrollDisable();

        File mdFile = new File(fcm.getSampleFilePath(getActivity()));
        mdView.loadMDFile(mdFile);

        return view;
    }

}
