package com.syject.meeting_management.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syject.meeting_management.R;
import com.syject.meeting_management.data.adapter.SpeechHistoryRecyclerViewAdapter;
import com.syject.meeting_management.data.db.SpeechHistory;
import com.syject.meeting_management.helper.DbHelperFactory;

import java.sql.SQLException;
import java.util.List;


public class SpeechListFragment extends Fragment {


    private OnListFragmentInteractionListener mListener;

    public SpeechListFragment() {
    }

    public static SpeechListFragment newInstance() {
        SpeechListFragment fragment = new SpeechListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            List<SpeechHistory> reportHistoryList = null;

            try {
                reportHistoryList = DbHelperFactory.getHelper().getSpeechHistoryDAO().queryForAll();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            recyclerView.setAdapter(new SpeechHistoryRecyclerViewAdapter(reportHistoryList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(SpeechHistory mItem);
        //void onListFragmentInteraction(SpeechHistory mItem);
        // TODO: Update argument type and name
        //void onListFragmentInteraction(DummyItem item);
    }
}
