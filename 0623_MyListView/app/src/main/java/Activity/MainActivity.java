package Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.techtown.listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView mListView = null;
    private listViewAdapter mlistViewAdapter = null; // 어댑터


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private class listViewAdapter extends BaseAdapter{

        private Context mContext = null;
        private ArrayList<Class.ListData> mlistData = new ArrayList<Class.ListData>();

        Class.ViewHolder viewHolder;


        public listViewAdapter(Context context){
            super();
            this.mContext = context;
        }


        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            if(convertView==null){
                viewHolder = new Class.ViewHolder();

                LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.list_item, null);

                /*
                 *ViewHolder
                 public ImageView profile;
                 public TextView friendName;
                 public TextView stateMessage;
                 */

                viewHolder.profile = (ImageView)convertView.findViewById(R.id.profile);
                viewHolder.friendName = (TextView)convertView.findViewById(R.id.friendName);
                viewHolder.stateMessage = (TextView)convertView.findViewById(R.id.stateMessage);

                convertView.setTag(viewHolder);
            }

            else{

                convertView.getTag();

            }
            return convertView;
        }
    }


}




/** 일반적인 리스트뷰 생성과 클릭 리스너
 String[] listMenu = {"List1", "List2", "List3"}; // 리스트뷰 데이터

 ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listMenu); // 리스튜브 스타일, 데이터 선택

 ListView listView = (ListView) findViewById(R.id.mListView); // 리스트뷰 객체선언
 listView.setAdapter(adapter); // 리스트뷰 어댑터 연결




 listview short click listener

 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// position은 각 열의 위치
if(position==0){
Toast.makeText(getApplicationContext(), "안녕하세요", Toast.LENGTH_LONG).show();
}

if(position==1){
Intent intent = new Intent(MainActivity.this, SecondActivity.class);
startActivity(intent);
finish();
}

}
});
 **/