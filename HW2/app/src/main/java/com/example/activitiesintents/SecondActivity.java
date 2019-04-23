<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".SecondActivity">

<TextView
        android:id="@+id/textview1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="16dp"
                android:layout_marginEnd="16dp" />

<TextView
        android:id="@+id/textview2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_below="@id/textview1"
                android:layout_marginStart="16dp"
                android:layout_marginEnd="16dp" />

<TextView
        android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentEnd="true"
                android:layout_alignParentBottom="true"
                android:layout_marginEnd="94dp"
                android:layout_marginBottom="635dp"
                android:text="Second Activity"
                android:textSize="30sp" />

<EditText
        android:id="@+id/response"
                android:layout_width="200dp"
                android:layout_height="100dp"
                android:layout_alignParentEnd="true"
                android:layout_alignParentBottom="true"
                android:layout_marginTop="10dp"
                android:layout_marginEnd="100dp"
                android:layout_marginBottom="454dp" />

<Button
        android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentEnd="true"
                android:layout_alignParentBottom="true"
                android:layout_marginEnd="93dp"
                android:layout_marginBottom="145dp"
                android:onClick="onClick"
                android:text="Go back to Main Activity" />

</RelativeLayout>
