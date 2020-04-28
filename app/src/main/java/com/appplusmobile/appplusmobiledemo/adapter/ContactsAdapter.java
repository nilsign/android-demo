package com.appplusmobile.appplusmobiledemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appplusmobile.appplusmobiledemo.R;
import com.appplusmobile.appplusmobiledemo.model.Contact;
import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

  private final List<Contact> contacts;

  public ContactsAdapter(List<Contact> contacts) {
    this.contacts = contacts;
  }

  @Override
  public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ContactViewHolder(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.card_contact, parent, false));
  }

  @Override
  public void onBindViewHolder(ContactViewHolder holder, int position) {
    holder.update(contacts.get(position));
  }

  @Override
  public int getItemCount() {
    return contacts.size();
  }

  protected final class ContactViewHolder extends RecyclerView.ViewHolder {
    private final ImageView photoImageView;
    private final TextView nameTextView;
    private final TextView workPhoneNumberTextView;

    protected ContactViewHolder(View itemView) {
      super(itemView);
      photoImageView = (ImageView) itemView.findViewById(R.id.photo_image_view);
      nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
      workPhoneNumberTextView = (TextView) itemView.findViewById(R.id.work_phone_number_text_view);
    }

    protected void update(Contact contact) {
      Glide.with(photoImageView.getContext())
          .load(contact.getSmallImageURL())
          .placeholder(R.drawable.image_not_fount)
          .fitCenter()
          .into(photoImageView);
      nameTextView.setText(contact.getName());
      workPhoneNumberTextView.setText(contact.getPhone().getWork());
    }
  }
}
