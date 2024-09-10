package com.tencent.supersonic.headless.chat.knowledge;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public abstract class MapResult implements Serializable {

    protected String name;
    protected int offset;

    protected String detectWord;

    protected double similarity;

    public abstract String getMapKey();

    public Boolean lessSimilar(MapResult otherResult) {
        String mapKey = this.getMapKey();
        String otherMapKey = otherResult.getMapKey();
        return mapKey.equals(otherMapKey) && otherResult.similarity < otherResult.similarity;
    }
}
