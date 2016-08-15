package dzumi.demo.app.mvvm.utils.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class UIUtils {
	public static Spannable getHighlightTextSearchResult(String fullText, String text)
	{
		/*Spannable wordtoSpan = new SpannableString(example);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.RED), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.DKGRAY), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/
		Spannable spannable = new SpannableString(fullText);
		int start = fullText.indexOf(text);
		int end = start+ text.length();
		/*spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/
		spannable.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return spannable;
	}

	public static Spannable getHighlightBoldText(String fullText, String text)
	{
		/*Spannable wordtoSpan = new SpannableString(example);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.RED), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.DKGRAY), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/
		Spannable spannable = new SpannableString(fullText);
		int start = fullText.indexOf(text);
		int end = start+ text.length();
		spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		spannable.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return spannable;
	}

	public static void HideSoftKey(Context context, View view)
	{
//		activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		InputMethodManager imm = (InputMethodManager)context.getSystemService(
				Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

	}

	public static void forceHideSoftKey(Context context)
	{
		InputMethodManager imm = (InputMethodManager)
				context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(((AppCompatActivity)context).getCurrentFocus().getWindowToken(), 0);
	}
	
	public static void ShowSoftKey(Context context, View view)
	{
		InputMethodManager inputMethodManager =
				(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		// only will trigger it if no physical keyboard is open
		inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);

	}
}
