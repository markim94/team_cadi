package org.markim.a0804_bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

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

        //권한 허용 라이브러리 : Ted Permission implementation

    }


}
