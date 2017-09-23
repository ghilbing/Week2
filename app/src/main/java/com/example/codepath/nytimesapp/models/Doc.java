package com.example.codepath.nytimesapp.models;

import android.text.TextUtils;

import com.example.codepath.nytimesapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gretel on 9/19/17.
 */
@Parcel
public class Doc implements Serializable {

    @SerializedName("web_url")
    @Expose
    public String webUrl;
    @SerializedName("snippet")
    @Expose
    public String snippet;
    @SerializedName("lead_paragraph")
    @Expose
    public String leadParagraph;
    @SerializedName("multimedia")
    @Expose
    public List<Multimedia> multimedia = null;
    @SerializedName("headline")
    @Expose
    public Headline headline;
    @SerializedName("pub_date")
    @Expose
    public String pubDate;
    @SerializedName("document_type")
    @Expose
    public String documentType;
    @SerializedName("new_desk")
    @Expose
    public String newsDesk;
    @SerializedName("section_name")
    @Expose
    public String sectionName;
    @SerializedName("subsection_name")
    @Expose
    public String subsectionName;
    @SerializedName("_id")
    @Expose
    public String id;

    public int colorId;

    // empty constructor for Parcelable


    public Doc() {}

   /* //Constructor for com.example.codepath.nytimesapp.database
    public Doc(String id, String webUrl, Headline headline) {
        this.id = id;
        this.webUrl = webUrl;
        this.headline = headline;
    }*/

    public String getWebUrl() {
        return webUrl;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageAddress() {
        for (String subtype : new String[]{ "xlarge", "wide", "thumbnail"}) {
            for (Multimedia multimedia : this.getMultimedia()) {
                if ("image".equals(multimedia.getType()) && subtype.equals(multimedia.getSubtype())) {
                    return multimedia.getFullUrl();
                }
            }
        }
        for (Multimedia m : this.getMultimedia()) {
            if ("image".equals(m.getType())) {
                return m.getFullUrl();
            }
        }
        return null;
    }



    public String setColorId() {

        if (newsDesk.equalsIgnoreCase("null") || newsDesk.equalsIgnoreCase("none")) {
            newsDesk = "";
            return newsDesk;
        } else {

            if (!TextUtils.isEmpty(newsDesk)) {
                if (newsDesk.equalsIgnoreCase("arts")) {
                    colorId = R.color.news_desk_art;
                    return newsDesk;
                } else if (newsDesk.equalsIgnoreCase("sports")) {
                    colorId = R.color.news_desk_sports;
                    return newsDesk;
                } else if (newsDesk.equalsIgnoreCase("fashion & style")) {
                    colorId = R.color.news_desk_fashion;
                    return newsDesk;
                }
            }
        }
        return newsDesk;
    }


}


