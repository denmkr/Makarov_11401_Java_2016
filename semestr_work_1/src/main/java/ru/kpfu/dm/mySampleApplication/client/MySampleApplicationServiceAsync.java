package ru.kpfu.dm.mySampleApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MySampleApplicationServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
    void getLabelText(AsyncCallback<String> async);
    void getLuckyDay(AsyncCallback<String> async);
}
