package com.summer_school_2015.team13.tic_tac_toe_4_difficult;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DialogWrongTurn extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.message_wrong_turn);
        builder.setNeutralButton(R.string.message_button_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
        });

        return builder.create();
    }

    public void show() {
        this.show();
    }
}
