package com.syject.meeting_management.data.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syject.meeting_management.R;
import com.syject.meeting_management.data.db.SpeechHistory;
import com.syject.meeting_management.ui.SpeechListFragment.OnListFragmentInteractionListener;

import java.util.List;

public class SpeechHistoryRecyclerViewAdapter extends RecyclerView.Adapter<SpeechHistoryRecyclerViewAdapter.ViewHolder> {

    private final List<SpeechHistory> mValues;
    private final OnListFragmentInteractionListener mListener;

    public SpeechHistoryRecyclerViewAdapter(List<SpeechHistory> reports, OnListFragmentInteractionListener listener) {
        mValues = reports;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.user_name.setText(mValues.get(position).userSpeech.user.name);
        holder.date.setText(mValues.get(position).date.toString());
        holder.speech_name.setText(mValues.get(position).userSpeech.speech.name);
        holder.speech_number.setText(Integer.toString(mValues.get(position).userSpeech.speech.number));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView speech_number;
        public final TextView speech_name;
        public final TextView date;
        public final TextView user_name;
        public SpeechHistory mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            speech_number = (TextView) view.findViewById(R.id.speech_number);
            speech_name = (TextView) view.findViewById(R.id.speech_name);
            date = (TextView) view.findViewById(R.id.date);
            user_name = (TextView) view.findViewById(R.id.user_name);
        }
     }
}
