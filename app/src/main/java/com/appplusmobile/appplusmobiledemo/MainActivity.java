package com.appplusmobile.appplusmobiledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.appplusmobile.appplusmobiledemo.adapter.ContactsAdapter;
import com.appplusmobile.appplusmobiledemo.listener.RecyclerViewTouchListener;
import com.appplusmobile.appplusmobiledemo.model.Contact;
import com.appplusmobile.appplusmobiledemo.task.RequestContactsTask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private RecyclerView contactsRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    contactsRecyclerView = (RecyclerView) MainActivity.this.findViewById(R.id.recycler_view);
    contactsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(
        getResources().getInteger(R.integer.contactColumns),
        StaggeredGridLayoutManager.VERTICAL));
    contactsRecyclerView.setItemAnimator(new DefaultItemAnimator());

    RequestContactsTask.execute(new RequestContactsTaskCallback());
  }

  private void startDetailedContactActivity(Contact contact) {
    startActivity(new Intent(this, DetailedContactActivity.class)
        .putExtra(DetailedContactActivity.EXTRA_CONTACT, contact));
  }

  private void updateRecyclerView(List<Contact> contacts) {
    sortContacts(contacts);
    contactsRecyclerView.setAdapter(new ContactsAdapter(contacts));
    addContactsClickedListener(contacts);
  }

  private void sortContacts(List<Contact> contacts) {
    Collections.sort(contacts, new Comparator<Contact>() {
      @Override
      public int compare(Contact first, Contact second) {
        return first.getName().compareTo(second.getName());
      }
    });
  }

  private void addContactsClickedListener(final List<Contact> contacts) {
    contactsRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this,
        new RecyclerViewTouchListener.OnCardClickListener() {
          @Override
          public void onClick(View view, int cardPosition) {
            startDetailedContactActivity(contacts.get(cardPosition));
          }
        }
    ));
  }

  private final class RequestContactsTaskCallback
      implements RequestContactsTask.RequestContactsTaskCallback {

    @Override
    public void requestContactsTaskSucceeded(List<Contact> contacts) {
      MainActivity.this.updateRecyclerView(contacts);
    }

    @Override
    public void requestContactsTaskFailed() {
      Toast.makeText(
          MainActivity.this,
          "Failed to load contacts.",
          Toast.LENGTH_SHORT).show();
    }
  }
}
