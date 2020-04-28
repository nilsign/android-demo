package com.appplusmobile.appplusmobiledemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.appplusmobile.appplusmobiledemo.helper.ExtraHelper;
import com.appplusmobile.appplusmobiledemo.model.Contact;
import com.bumptech.glide.Glide;

public final class DetailedContactActivity extends AppCompatActivity {

  public static final String EXTRA_CONTACT = "contact";

  private Contact contact;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detailed_contact);

    contact = ExtraHelper.getExtra(EXTRA_CONTACT, savedInstanceState, this);

    Glide.with(this)
        .load(contact.getLargeImageURL())
        .placeholder(R.drawable.image_not_fount)
        .fitCenter()
        .into((ImageView) findViewById(R.id.photo_image_view));

    ((ImageView) findViewById(R.id.star_button_image_view)).setColorFilter(
        contact.isFavorite() ? Color.rgb(210, 210, 10) : Color.GRAY);
    findViewById(R.id.star_button_frame_layout).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        toggleFavoriteState();
      }
    });
d
    setEditTextField(R.id.name_edit_text, contact.getName());
    setEditTextField(R.id.company_edit_text, contact.getCompany());
    setEditTextField(R.id.home_phone_number_edit_text, contact.getPhone().getHome());
    setEditTextField(R.id.work_phone_number_edit_text, contact.getPhone().getWork());
    setEditTextField(R.id.mobile_number_edit_text, contact.getPhone().getMobile());
    setEditTextField(R.id.email_edit_text, contact.getEmail());
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    ExtraHelper.putExtra(EXTRA_CONTACT, contact, outState);
  }

  private void setEditTextField(int resourceId, String text) {
    EditText editText = (EditText) findViewById(resourceId);
    editText.setText(text);
    editText.setEnabled(false);
    String test = "";
    test.su
    test.equalsIgnoreCase()
        System.console().printf
  }

  private void toggleFavoriteState() {
    contact.setFavorite(!contact.isFavorite());
    ((ImageView) findViewById(R.id.star_button_image_view)).setColorFilter(
        contact.isFavorite() ? Color.rgb(210, 210, 10) : Color.GRAY);

  }

  private void toggleEditState() {
    toggleEditState(R.id.name_edit_text);
    toggleEditState(R.id.company_edit_text);
    toggleEditState(R.id.home_phone_number_edit_text);
    toggleEditState(R.id.work_phone_number_edit_text);
    toggleEditState(R.id.mobile_number_edit_text);
    toggleEditState(R.id.email_edit_text);
  }

  private void toggleEditState(int resourceId) {
    findViewById(resourceId).setEnabled(!findViewById(resourceId).isEnabled());
  }
}
