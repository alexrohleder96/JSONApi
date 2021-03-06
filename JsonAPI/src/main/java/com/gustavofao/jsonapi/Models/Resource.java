package com.gustavofao.jsonapi.Models;

import com.gustavofao.jsonapi.Annotations.Excluded;
import com.gustavofao.jsonapi.Annotations.Id;
import com.gustavofao.jsonapi.Annotations.Type;
import com.gustavofao.jsonapi.Annotations.Types;

public class Resource {

    @Id
    private String id;
    private Links links;

    @Excluded
    private String type;

    @Excluded
    protected boolean hasAttributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        if (getClass().getAnnotation(Type.class) != null)
            return getClass().getAnnotation(Type.class).value();
        if (type == null && getClass().getAnnotation(Types.class).value() != null && getClass().getAnnotation(Types.class).value().length > 0)
            return getClass().getAnnotation(Types.class).value()[0];
        return type;
    }

    public boolean hasAttributes() {
        return hasAttributes;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
