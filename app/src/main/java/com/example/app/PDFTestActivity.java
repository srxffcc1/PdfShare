package com.example.app;


import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;
import com.shark.pdfedit.utils.PdfPrintHelp;
import com.wisdomregulation.data.entitybase.Base_Entity;

import java.io.File;

//import com.zhihuianjianproject.data.entitybase.Base_Entity;
//import com.zhihuianjianproject.utils.PdfPrintHelp;

public class PDFTestActivity extends Activity {



    Base_Entity base_entity;
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.pdfceshi);

  
        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);

        // 在我这个测试例子中，事先准备一个叫做sample.pdf的pdf大文件放到assets目录下。  
        // 从assets文件目录下读取名为 sample.pdf的文件，缺省把该pdf定位到第一页。  
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/pdf_1.pdf");
        pdfView.fromFile(file).defaultPage(1).onPageChange(new OnPageChangeListener() {
        	  
            @Override  
            public void onPageChanged(int page, int pageCount) {  
                // 当用户在翻页时候将回调。  
                Toast.makeText(getApplicationContext(), page + " / " + pageCount, Toast.LENGTH_SHORT).show();  
            }  
        }).load();

        base_entity = (Base_Entity) getIntent().getSerializableExtra("baseBean");

    }  
}  