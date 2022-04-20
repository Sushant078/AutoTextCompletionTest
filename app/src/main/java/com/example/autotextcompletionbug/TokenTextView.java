package com.example.autotextcompletionbug;
import android.content.Context;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;

/**
 * Created by mgod on 5/27/15.
 * <p>
 * Simple custom view example to show how to get selected events from the token
 * view. See ContactsCompletionView and contact_token.xml for usage
 */
public class TokenTextView extends androidx.appcompat.widget.AppCompatTextView {

    public TokenTextView(Context context) {
        super(context);
    }

    public TokenTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);

        //To change color on selection
        setBackgroundColor(selected ? ContextCompat.getColor(getContext(), R.color.purple_200) :
                ContextCompat.getColor(getContext(), android.R.color.transparent));

        //add this code for adding cross button on selction
        //setCompoundDrawablesWithIntrinsicBounds(0, 0, selected ? R.drawable.ic_clear_black_24dp : 0, 0);
    }

}
