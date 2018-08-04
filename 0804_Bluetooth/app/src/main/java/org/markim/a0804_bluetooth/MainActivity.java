package org.markim.a0804_bluetooth;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

/**
 * 동작방법, 원리 : 
 * permissionListener 동작 이후 checkMyPermission()
 */


public class MainActivity extends AppCompatActivity {

    // bluetooth adapter
    BluetoothAdapter bluetoothAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * bluetooth를 시작하기 위한 버튼 객체, 클릭 리스너
         */
        Button button = (Button) findViewById(R.id.btnBluetooth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    // 권한 체크 메소드, Ted Permission 라이브러리를 이용.
    private void checkMyPermission(){
        TedPermission.with(this)
                .setRationaleMessage("정상적인 앱 사용을 위해서 블루투스 권한을 허용해주시기 바랍니다.")
                .setDeniedMessage("설정에서 권한을 허용해주세요.")
                // 퍼미션 리스너 연결
                .setPermissionListener(permissionListener)
                // 체크할 권한 항목
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN);
    }


    // TedPermission 라이브러리 내에 존재하는 Permission Listener
    PermissionListener permissionListener = new PermissionListener(){

        // 권한 허가를 정상적으로 받았을 때
        @Override
        public void onPermissionGranted() {
            setBlueToothOnCheck();
        }

        // 권한 허가를 받지 않았을 때
        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }
    };



    /*
    블루투스 상태를 확인하고, 꺼져있다면 블루투스를 on 시키는 메소드
     */
    private void setBlueToothOnCheck(){

        //null이 return되면 블루투스가 사용불가 상태임.
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // bluetooth Adapter가 null이 아니고 사용가능하다면
        if(bluetoothAdapter.isEnabled()){

            Intent i = new Intent(MainActivity.this, BluetoothListActivity.class);
            startActivity(i);
            finish();

            // null이라면 응답코드를 던져서 블루투스를 키게 됨.
        } else {
            Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            // 10이상으로 정의하면 됨. 통상 100
            startActivityForResult(bluetoothIntent, 100);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case 100:
                // 요청코드 10을 던지고 resultCode가 정상적으로 반환됐을때
                if(resultCode==Activity.RESULT_OK){
                    // BluetoothListActivity로 전환
                    Intent i = new Intent(MainActivity.this, BluetoothListActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    // 활성화되지 않았을 때 코드부분
                }
        }
    }

}
