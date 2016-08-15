package dzumi.demo.app.mvvm.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class PublicFunction {

    public static void showDialog(Context context, String msg, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Thông báo");
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("OK", onClickListener);
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public static void showDialog(Context context, String msg) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Thông báo");
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {dialog.dismiss();});
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void showDialog(Context context, String title, String msg) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {dialog.dismiss();});
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void showDialog(Context context, String msg, DialogInterface.OnClickListener onYesListener, DialogInterface.OnClickListener onNoListener, boolean isTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        if (isTitle)
            alertDialogBuilder.setTitle("Thông báo");
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("Save", onYesListener);
        alertDialogBuilder.setNegativeButton("Cancel", onNoListener);
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void showDialog(Context context, String msg, DialogInterface.OnClickListener onYesListener, DialogInterface.OnClickListener onNoListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Thông báo");
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("OK", onYesListener);
        alertDialogBuilder.setNegativeButton("Cancel", onNoListener);
        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
