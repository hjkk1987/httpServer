package com.jmdns.multicast.connect;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import org.json.JSONObject;
import java.net.Inet4Address;
import java.util.Map;

/**
 * easy-to-use wrapper for clients
 *
 * @author alwx
 * @version 1.0
 */
public class ConnectionWrapper {
  private Context mContext;
  private NetworkDiscovery mNetworkDiscovery;


  /**
   * wrapper constructor
   * see example of usage in {@link me.alwx.localcommunication.MainActivity}
   *
   * @param context  application context
   * @param listener listener, that will be called after all preparation finished
   *                 (see {@link me.alwx.localcommunication.connection.ConnectionWrapper.OnCreatedListener})
   */
  public ConnectionWrapper(final Context context,
                           final OnCreatedListener listener) {
    mContext = context;
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... params) {
        mNetworkDiscovery = new NetworkDiscovery(mContext);
        return null;
      }

      @Override
      protected void onPostExecute(Void aVoid) {
        if (listener != null) {
          listener.onCreated();
        }
      }
    }.execute((Void) null);
  }


  /**
   * starts server
   * you need to use this function only for phone you need to register as server
   */
  public void startServer(final int port) {


    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... params) {
        mNetworkDiscovery.startServer(port);

        return null;
      }
    }.execute((Void) null);
  }

  /**
   * performs servers search
   *
   * @param listener listener, that will be called after something found
   *                 (see {@link me.alwx.localcommunication.connection.NetworkDiscovery.OnFoundListener})
   */
  public void findServers(final NetworkDiscovery.OnFoundListener listener) {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... params) {
        mNetworkDiscovery.findServers(listener);

        return null;
      }
    }.execute((Void) null);
  }

  /**
   * stops network discovery
   */
  public void stopNetworkDiscovery() {
    if (mNetworkDiscovery != null) {
      mNetworkDiscovery.reset();
    }
  }

  public interface OnCreatedListener {
    void onCreated();
  }
}