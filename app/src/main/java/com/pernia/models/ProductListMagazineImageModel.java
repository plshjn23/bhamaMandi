package com.pernia.models;

import java.io.Serializable;

/**
 * Created by Palash on 3/5/2017.
 */

public class ProductListMagazineImageModel implements Serializable {

    String id, uri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
