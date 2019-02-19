package com.ys.jsst.pmis.commommodule.util;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * description:	Toast打印帮助类
 * User: shaobing
 * Date: 2016/6/14
 * Time: 16:41
 */
public class ToastUtil {
	private static Toast mToast = null;

	public static void showLongToast(Context context, int id){
		Log.d("ToastUtil", "showLongToast1");
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, id, Toast.LENGTH_LONG);
			}else{
				mToast.setText(id);
			}	
			mToast.show();
		}
	}
	
	public static void showLongToast(Context context, String content){
		Log.d("ToastUtil", "showLongToast2");
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context,content, Toast.LENGTH_LONG);
			}else{
				mToast.setText(content);
			}	
			mToast.show();
		}
	}

	public static void showShortToast(Context context, int id){
		Log.d("ToastUtil", "showLongToast3");
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
			}else{
				mToast.setText(id);
			}	
			mToast.show();
		}
	}
	public static void showLongCenterToast(Context context, String message){
		Log.d("ToastUtil", "showLongToast4");
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			}else{
				mToast.setText(message);
			}
			mToast.setGravity(Gravity.CENTER,0,0);
			mToast.show();
		}
	}
	public static void showShortToast(Context context, String content){
		Log.d("ToastUtil", "showLongToast5");
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context,content, Toast.LENGTH_SHORT);
			}else{
				mToast.setText(content);
			}	
			mToast.show();
		}
	}

	public static void toastPrompt(Context context, int id, int time){
		if(null != context){
			if(null == mToast){
				mToast = Toast.makeText(context, id, time);
			}else{
				mToast.setText(id);
			}	
			mToast.show();
		}
	}
	

	
	public static void cancelToast(){
		if(null != mToast){
			mToast.cancel();
		}
	}
}
