package com.example.todolist;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import static com.example.todolist.SeeListItemEach.TRAINING_KEY;

public class PlanDialogDetails extends DialogFragment {

    public interface PassPlanDetails {
        void getPlan(Plan plan);
    }

    private PassPlanDetails passPlanDetails;

    private TextView txtname;
    private EditText minutes;
    private Spinner spinnerDay;
    private Button btnDismiss, btnAdd;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.plan_dialoge,null);

        initView(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Enter Details");

        Bundle bundle = getArguments();

        if(bundle != null){
            final studyItems studyItem = bundle.getParcelable(TRAINING_KEY);
            if(null != studyItem){
                txtname.setText(studyItem.getName());
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String days = spinnerDay.getSelectedItem().toString();
                        int i = Integer.valueOf(minutes.getText().toString());

                        Plan plan = new Plan(studyItem,i,days,false);

                        try {
                            passPlanDetails = (PassPlanDetails) getActivity();
                            passPlanDetails.getPlan(plan);
                            dismiss();
                        }catch(ClassCastException e){
                            dismiss();
                        }

                    }
                });
            }
        }

        return builder.create();

    }
    private void initView(View view){
        txtname = view.findViewById(R.id.txtname);
        minutes = view.findViewById(R.id.editTextMinutes);
        spinnerDay = view.findViewById(R.id.spinner);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnDismiss = view.findViewById(R.id.btnDismiss);
    }
}
