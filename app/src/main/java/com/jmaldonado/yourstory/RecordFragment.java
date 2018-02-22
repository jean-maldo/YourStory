package com.jmaldonado.yourstory;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import helper.RecordStepperAdapter;

public class RecordFragment extends Fragment{
    private StepperLayout mStepperLayout;
    private RecordStepperAdapter mStepperAdapter;

    public RecordFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record, container, false);

        mStepperLayout = (StepperLayout) view.findViewById(R.id.stepperLayout);
        mStepperAdapter = new RecordStepperAdapter(getFragmentManager(), this.getActivity());
        mStepperLayout.setAdapter(mStepperAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
