package com.example.kalli.localshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by kalli on 5/8/16.
 */
public class MyItems extends BaseActivity implements View.OnClickListener {

    FrameLayout r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflate the view
        r = (FrameLayout) findViewById(R.id.content_base);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_my_items, null);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content_base);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

    }

    @Override
    public void onClick(View view) {

    }
}
