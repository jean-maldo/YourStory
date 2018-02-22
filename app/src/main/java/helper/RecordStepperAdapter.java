package helper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.jmaldonado.yourstory.R;
import com.jmaldonado.yourstory.RecordFragment;
import com.jmaldonado.yourstory.RecordStepFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by jmaldonado on 16/12/2017.
 */

public class RecordStepperAdapter extends AbstractFragmentStepAdapter {
    private static final String CURRENT_STEP_POSITION_KEY = "messageResourceId";
    public RecordStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }
    @Override
    public Step createStep(int position) {
        switch (position){
            case 0:
                final RecordStepFragment step1 = new RecordStepFragment();
                Bundle b1 = new Bundle();
                b1.putInt(CURRENT_STEP_POSITION_KEY, position);
                step1.setArguments(b1);
                return step1;
            case 1:
                final RecordStepFragment step2 = new RecordStepFragment();
                Bundle b2 = new Bundle();
                b2.putInt(CURRENT_STEP_POSITION_KEY, position);
                step2.setArguments(b2);
                return step2;
            case 2:
                final RecordStepFragment step3 = new RecordStepFragment();
                Bundle b3 = new Bundle();
                b3.putInt(CURRENT_STEP_POSITION_KEY, position);
                step3.setArguments(b3);
                return step3;
            case 3:
                final RecordStepFragment step4 = new RecordStepFragment();
                Bundle b4 = new Bundle();
                b4.putInt(CURRENT_STEP_POSITION_KEY, position);
                step4.setArguments(b4);
                return step4;
            case 4:
                final RecordStepFragment step5 = new RecordStepFragment();
                Bundle b5 = new Bundle();
                b5.putInt(CURRENT_STEP_POSITION_KEY, position);
                step5.setArguments(b5);
                return step5;
            case 5:
                final RecordStepFragment step6 = new RecordStepFragment();
                Bundle b6 = new Bundle();
                b6.putInt(CURRENT_STEP_POSITION_KEY, position);
                step6.setArguments(b6);
                return step6;
        }
        return null;
    }
    @Override
    public int getCount() {
        return 6;
    }
}