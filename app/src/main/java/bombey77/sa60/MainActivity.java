package bombey77.sa60;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnExit;
    private static final int DIALOG = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExit = (Button) findViewById(R.id.btnExit);

        startBtnExit();
    }

    private void startBtnExit() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle(R.string.string_exit);
            adb.setIcon(android.R.drawable.btn_minus);
            adb.setPositiveButton("Yes", myCallBack);
            adb.setNegativeButton("No", myCallBack);
            adb.setNeutralButton("Cancel", myCallBack);
            
            adb.setCancelable(false);
            return adb.create();
        }

        return super.onCreateDialog(id);
    }

    DialogInterface.OnClickListener myCallBack = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    showToast();
                    finish();
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    finish();
                    break;
            }
        }
    };

    private void showToast() {
        Toast.makeText(this, "Save",Toast.LENGTH_LONG).show();
    }
}
