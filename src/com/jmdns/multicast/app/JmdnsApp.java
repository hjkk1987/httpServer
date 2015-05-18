package com.jmdns.multicast.app;

import javax.jmdns.ServiceInfo;

import com.jmdns.multicast.connect.ConnectionWrapper;
import com.jmdns.multicast.connect.ConnectionWrapper.OnCreatedListener;
import com.jmdns.multicast.connect.NetworkDiscovery.OnFoundListener;

import android.app.Application;
import android.util.Log;

/*
 * File：JmdnsApp.java
 *
 * Copyright (C) 2015 multiCastSoC Project
 * Date：2015年5月13日 下午5:32:27
 * All Rights SXHL(New Space) Corporation Reserved.
 * http://www.at-et.cn
 *
 */

/**
 * @description:
 * 
 * @author: HuJun
 * @date: 2015年5月13日 下午5:32:27
 */

public class JmdnsApp extends Application {
	private ConnectionWrapper mConnectionWrapper = null;
	private static String Tag = JmdnsApp.class.getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application#onCreate()
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
	}

	/**
	 * @description:
	 * 
	 * @param listener
	 * @throws:
	 * @author: HuJun
	 * @date: 2015年5月13日 下午6:18:52
	 */
	public void createConnectionWrapper(
			ConnectionWrapper.OnCreatedListener listener) {
		mConnectionWrapper = new ConnectionWrapper(getApplicationContext(),
				listener);
	}

	/**
	 * @description:
	 * 
	 * @return
	 * @throws:
	 * @author: HuJun
	 * @date: 2015年5月13日 下午6:18:55
	 */
	public ConnectionWrapper getConnectionWrapper() {
		return mConnectionWrapper;
	}
}
