package com.iknow.android.utilssample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.iknow.android.utils.R;
import iknow.android.utils.functions.Function;

/**
 * Author：J.Chou
 * Date：  2016.07.14 17:09.
 * Email： who_know_me@163.com
 * Describe:
 */
public class Main extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        testFun(new Function<String, String>() {
            @Override public String apply(String s) throws Exception {

                return null;
            }
        });
    }

    private String testFun(Function<String, String> function) {
        try {
            return function.apply("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
