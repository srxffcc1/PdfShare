package com.example.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {

//    private BookFragment bookFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfframe);
//        Base_Entity base_entity=new Entity_Book_2017_0();
//        bookFragment = BookFragment.getInstance2017(base_entity,BookFragment.TYPE_ADD);
//        getFragmentManager().beginTransaction().replace(R.id.needp, bookFragment).commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
//        if(bookFragment.onBackPressed()){
//            return;
//        }else{
//            super.onBackPressed();
//        }
    }
}
