package com.uninorte.activitylife;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.NumberPicker;


public class MainActivity extends ActionBarActivity {

    private String TAG = "ActivityCycle1";
    private String VALUE_STATE = "value_state";
    private Integer mValue;
    private NumberPicker mNumberPicker;
    private Animation mAnimTranslate;
    private Animation mAnimRotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");
        //http://android-er.blogspot.com/2012/02/apply-animation-on-button.html//
        mAnimTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        mAnimRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        NumberPicker mNumberPicker=
                (NumberPicker) findViewById(R.id.numberPicker);
        mNumberPicker.setMaxValue(9);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setWrapSelectorWheel(false);

        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate, restart values");
            mValue = 0;
        } else {
            mValue = savedInstanceState.getInt(VALUE_STATE);
            Log.d(TAG, "onCreate, restoring value to "+mValue);
        }

        mNumberPicker.setValue(mValue);
        mNumberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                Log.d(TAG, "onCreate, mNumberPicker value "+i);
                mValue = i+1;
            }
        });
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(VALUE_STATE, mValue);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
    }


    public void changeActivity(View view) {
        view.startAnimation(mAnimRotate);
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);


    }
}
