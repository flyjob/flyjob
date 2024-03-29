package com.intellibucket.lib.fj.dataaccess;

public final class BatisPageable {
    private final Integer limit;

    private final Integer offset;

    public BatisPageable(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

}
