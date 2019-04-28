package com.example.customlistviewtest;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

// MainActivity : 화면에 보여질 액티비티
// MyAdapter : 어댑터
// MyItem : 아이템 클래스

// activity_main.xml : 메인액티비티의 레이아웃
// listview_custom.xml : 리스트뷰에 들어갈 위젯을 구성해 놓은 레이아웃
public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter();
        listView = (ListView) findViewById(R.id.listView);

        setData();

        listView.setAdapter(adapter);
    }

    // 보통 ListView는 통신을 통해 가져온 데이터를 보여줍니다.
    // arrResId, names, contents를 서버에서 가져온 데이터라고 생각하시면 됩니다.
    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] names = getResources().getStringArray(R.array.name);
        String[] contents = getResources().getStringArray(R.array.content);

        for(int i = 0; i < names.length; i++) {
            MyItem mItem = new MyItem();
            mItem.setResId(arrResId.getResourceId(i, 0));
            mItem.setName(names[i]);
            mItem.setContents(contents[i]);

            adapter.addItem(mItem);
        }
    }
}
