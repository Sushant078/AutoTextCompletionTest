package com.example.autotextcompletionbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.tokenautocomplete.TokenCompleteTextView
import com.tokenautocomplete.TokenCompleteTextView.TokenClickStyle
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val autoCompleteTextView:CompletionView = findViewById(R.id.autocomplete_textview);
        autoCompleteTextView.setTokenListener(object : TokenCompleteTextView.TokenListener<SampleData> {

            override fun onTokenAdded(token: SampleData) {
                Toast.makeText(this@MainActivity,"onTokenAddedFired",Toast.LENGTH_SHORT).show()
            }

            override fun onTokenRemoved(token: SampleData) {
                Toast.makeText(this@MainActivity,"onTokenRemovedFired",Toast.LENGTH_SHORT).show()
            }

            override fun onTokenIgnored(token: SampleData) {}
        })
        autoCompleteTextView.setTokenClickStyle(TokenClickStyle.Select)
        autoCompleteTextView.imeOptions = EditorInfo.IME_ACTION_DONE
        autoCompleteTextView.setOnEditorActionListener { textView, id, keyEvent ->
            if (id === EditorInfo.IME_NULL || id === EditorInfo.IME_ACTION_DONE) {
                return@setOnEditorActionListener false
            }
            false
        }
        autoCompleteTextView.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this@MainActivity,"itemClicked",Toast.LENGTH_SHORT).show()
        }
        val dummyData = DummyData()
        val filterAdapter = FilterAdapter(this,R.layout.chip_item_data,dummyData.data)
        autoCompleteTextView.setAdapter(filterAdapter)
        autoCompleteTextView.allowCollapse(false)
//        autoCompleteTextView.performCollapse(false)
        //as soon as isLineSingle is set to true tokenListener no longer works
        autoCompleteTextView.isSingleLine = false
    }

}