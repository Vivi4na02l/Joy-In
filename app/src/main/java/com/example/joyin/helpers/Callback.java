package com.example.joyin.helpers;

public interface Callback {
    void onSuccess(Object responseObject);
    void onError(String error);
}
