package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    public EditText etEditItem;
    private int mEditItemPosition;
    private String mEditItemContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        etEditItem = (EditText) findViewById(R.id.etEditItem);
        mEditItemPosition = getIntent().getIntExtra("position", 0);
        mEditItemContent = getIntent().getStringExtra("item_content");
        etEditItem.setText(mEditItemContent);
        etEditItem.setSelection(mEditItemContent.length());
    }

    public void onSaveItem(View v) {
        Intent data = new Intent();
        data.putExtra("edited_item_position", mEditItemPosition);
        data.putExtra("edited_item_content", etEditItem.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

}
