package com.appplusmobile.appplusmobiledemo.task;

import android.os.AsyncTask;
import android.util.Log;

import com.appplusmobile.appplusmobiledemo.model.Contact;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import java.util.List;

public final class RequestContactsTask extends AsyncTask<String, Void, List<Contact>> {

  private static final String LOG_TAG = "RequestContactsTask";
  private static final String API_BASE_URL = "https://waltken.de/";
  private static final String API_CONTACTS_PATH = "/Contacts_v2.json";

  private final RequestContactsTaskCallback callback;

  public interface RequestContacts {
    @GET(API_CONTACTS_PATH)
    Call<List<Contact>> contacts();
  }

  public interface RequestContactsTaskCallback {
    void requestContactsTaskSucceeded(List<Contact> contacts);
    void requestContactsTaskFailed();
  }

  private RequestContactsTask(RequestContactsTaskCallback callback) {
    this.callback = callback;
  }

  public static void execute(RequestContactsTaskCallback callback) {
    new RequestContactsTask(callback).execute();
  }

  @Override
  protected List<Contact> doInBackground(String... params) {
    try {
      return new Retrofit.Builder()
          .baseUrl(API_BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(RequestContacts.class)
          .contacts()
          .execute()
          .body();
    } catch (Exception e) {
      Log.e(LOG_TAG, "Request contacts failed.", e);
    }
    return null;
  }

  @Override
  protected void onPostExecute(List<Contact> contacts) {
    super.onPostExecute(contacts);
    if (contacts != null) {
      callback.requestContactsTaskSucceeded(contacts);
      return;
    }
    callback.requestContactsTaskFailed();
  }
}
