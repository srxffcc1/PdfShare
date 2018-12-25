package com.shark.pdfedit.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.joanzapata.pdfview.listener.OnPageChangeListener;
import com.shark.pdfedit.R;
import com.shark.pdfedit.utils.PdfPrintHelp;
import com.wisdomregulation.data.entitybase.Base_Entity;

import java.io.File;

public class PDFPerViewActivity extends Activity {

    Button print;
    Button back;

    Base_Entity base_entity;
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.pdfpreview);


        com.joanzapata.pdfview.PDFView   pdfView = (com.joanzapata.pdfview.PDFView  ) findViewById(R.id.pdfView);
        back = (Button) findViewById(R.id.back);
        print = (Button) findViewById(R.id.print);
        // 在我这个测试例子中，事先准备一个叫做sample.pdf的pdf大文件放到assets目录下。  
        // 从assets文件目录下读取名为 sample.pdf的文件，缺省把该pdf定位到第一页。  
        File file = new File(getIntent().getStringExtra("path"));
        pdfView.fromFile(file).defaultPage(1).onPageChange(new OnPageChangeListener() {
        	  
            @Override  
            public void onPageChanged(int page, int pageCount) {  
                // 当用户在翻页时候将回调。  
                Toast.makeText(getApplicationContext(), page + " / " + pageCount, Toast.LENGTH_SHORT).show();  
            }  
        }).load();

        base_entity = (Base_Entity) getIntent().getSerializableExtra("baseBean");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PdfPrintHelp.print(Environment.getExternalStorageDirectory().getAbsolutePath() + "/dongtest.pdf",
                            PDFPerViewActivity.this, 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(PDFPerViewActivity.this, "请先安装printshare插件", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        pdfView.fromAsset("sample.pdf").defaultPage(1).onPageChange(new OnPageChangeListener() {  
//  
//            @Override  
//            public void onPageChanged(int page, int pageCount) {  
//                // 当用户在翻页时候将回调。  
//                Toast.makeText(getApplicationContext(), page + " / " + pageCount, Toast.LENGTH_SHORT).show();  
//            }  
//        }).load();  
    }  
}  