package com.example.autotextcompletionbug;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tokenautocomplete.TokenCompleteTextView;

/**
 * Sample token completion view for basic contact info
 * <p>
 * Created on 9/12/13.
 *
 * @author mgod
 */
public class CompletionView extends TokenCompleteTextView<SampleData> {

    public CompletionView(Context context) {
        super(context);
    }

    public CompletionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompletionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected View getViewForObject(SampleData contact) {
        LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View tokenView = l.inflate(R.layout.chip_item_view, (ViewGroup) getParent(), false);

        if (contact != null) {
            tokenView.setVisibility(View.VISIBLE);
            TokenTextView textView = tokenView.findViewById(R.id.token_text);
            textView.setText(contact.getName());
        } else {
            tokenView.setVisibility(View.GONE);
        }


        return tokenView;
    }

    @Override
    protected SampleData defaultObject(String completionText) {
        //Stupid simple example of guessing if we have an email or not
        int index = completionText.indexOf('@');
        if (index == -1) {
            return new SampleData(R.drawable.ic_launcher_background, completionText, completionText.replace(" ", "") + "@example.com");
        } else {
            return new SampleData(R.drawable.ic_launcher_foreground, completionText.substring(0, index), completionText);
        }
    }
}
