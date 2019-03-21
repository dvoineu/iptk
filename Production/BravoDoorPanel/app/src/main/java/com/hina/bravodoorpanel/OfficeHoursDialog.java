package com.hina.bravodoorpanel;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class OfficeHoursDialog extends AppCompatDialogFragment {
    TextView tv_officeHoursDialog;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.office_hours_dialog, null);

        builder.setView(view)
                .setTitle("Office Hours")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        tv_officeHoursDialog = view.findViewById(R.id.tv_officeHoursDialog);
        SharedPreferences prefs = this.getActivity().getSharedPreferences(Constants.PREF_USER, Context.MODE_PRIVATE);
        tv_officeHoursDialog.setText(prefs.getString(Constants.OFFICE_HOURS, ""));
        return builder.create();
    }

}
