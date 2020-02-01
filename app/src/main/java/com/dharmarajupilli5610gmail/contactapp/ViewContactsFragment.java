package com.dharmarajupilli5610gmail.contactapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import static android.view.inputmethod.InputMethodManager.SHOW_FORCED;

public class ViewContactsFragment extends Fragment {

    private static final String TAG = "ViewContactsFragment";

    private static final int STANDARD_APPBAR=0;
    private static final int SEARCH_APPBAR=1;
    private int mAppBarState;

    private AppBarLayout viewContactsBar,searchBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: in view method");
        View view=inflater.inflate(R.layout.fragment_viewcontacts,container,false);

        viewContactsBar=view.findViewById(R.id.viewContactsToolbar);
        searchBar=view.findViewById(R.id.searchToolbars);
        setAppBarState(STANDARD_APPBAR);

        FloatingActionButton fab=view.findViewById(R.id.fab_add_contact);
        ImageView ivSearchContact=view.findViewById(R.id.ivSearchIcon);
        ImageView ivBackArrow=view.findViewById(R.id.ivBackArrow);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: fab");
            }
        });

        ivSearchContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ivSearchContact");
                toggleToolBarState();
            }
        });

        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked ivBackArrow");
                toggleToolBarState();
            }
        });

        return view;
    }

    private void toggleToolBarState() {
        Log.d(TAG, "toggleToolBarState: Toggling app bar state");
        if (mAppBarState==STANDARD_APPBAR){
            setAppBarState(SEARCH_APPBAR);
        }else{
            setAppBarState(STANDARD_APPBAR);
        }
    }

    private void setAppBarState(int state) {
        Log.d(TAG, "setAppBarState: changing app bar state to:"+state);
        mAppBarState=state;
        if(mAppBarState == STANDARD_APPBAR){
            searchBar.setVisibility(View.GONE);
            viewContactsBar.setVisibility(View.VISIBLE);
            View view=getView();
            InputMethodManager imm= (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
            try{
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);
            }catch (NullPointerException e){
                Log.d(TAG, "setAppBarState:NullPointerException "+e.getMessage());
            }

        }else if(mAppBarState == SEARCH_APPBAR){
            viewContactsBar.setVisibility(View.GONE);
            searchBar.setVisibility(View.VISIBLE);

            InputMethodManager imm= (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        setAppBarState(STANDARD_APPBAR);
    }
}
