package com.intellibucket.lib.fj.dataaccess;

import java.util.Objects;

public final class BatisPageable {
    private final Integer offset;
    private Integer limit;

    public BatisPageable(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public static BatisPageable of(Integer size, Integer page) {
        size = Math.abs(Objects.requireNonNullElse(size, 1));
        page = Math.abs(Objects.requireNonNullElse(page, 1));
        return new BatisPageable(size, (page - 1) * size);
    }
    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public BatisPageable changeLimit(Integer limit){
        return new BatisPageable(limit,this.offset);
    }
}
