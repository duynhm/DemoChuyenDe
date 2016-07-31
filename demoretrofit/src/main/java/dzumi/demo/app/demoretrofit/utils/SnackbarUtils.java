package dzumi.demo.app.demoretrofit.utils;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dzumi on 4/6/2016.
 */
public class SnackbarUtils {
    public static void show(View view, String text){
        Snackbar.make(view,text,Snackbar.LENGTH_LONG).show();
    }

    public static void showError(View view, String text){
        Snackbar snackBarView = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        snackBarView.getView().setBackgroundColor(Color.RED);
        //snackBarView.setActionTextColor(actionTextColor);
        TextView tv = (TextView) snackBarView.getView().findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackBarView.show();
    }

    public static void showError(View view, int text){
        Snackbar snackBarView = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        snackBarView.getView().setBackgroundColor(Color.RED);
        //snackBarView.setActionTextColor(actionTextColor);
        TextView tv = (TextView) snackBarView.getView().findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackBarView.show();
    }
    public static void show(View view, int text){
        Snackbar.make(view,text,Snackbar.LENGTH_SHORT).show();
    }

    public static void showLong(View view, int text){
        Snackbar.make(view,text,Snackbar.LENGTH_LONG).show();
    }
    public static void show(View view, int text, String actionTitle, View.OnClickListener onClick){
        Snackbar.make(view,text,Snackbar.LENGTH_SHORT).setAction(actionTitle, onClick).show();
    }

    public static void show(View view, int text, int actionTitle, View.OnClickListener onClick){
        Snackbar.make(view,text,Snackbar.LENGTH_SHORT).setAction(actionTitle, onClick).show();
    }

    public static void showError(View view, int text, int actionTitle, View.OnClickListener onClick){
        Snackbar snackBarView = Snackbar.make(view,text,Snackbar.LENGTH_SHORT);
        snackBarView.setAction(actionTitle, onClick).show();
        snackBarView.getView().setBackgroundColor(Color.RED);
        //snackBarView.setActionTextColor(actionTextColor);
        TextView tv = (TextView) snackBarView.getView().findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackBarView.show();
    }
}
