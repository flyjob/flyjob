package com.intellibucket.lib.fj.dataaccess;

import java.security.PublicKey;

public final class BatisPageable {
    private final Integer limit;

    private final Integer offset;

    public BatisPageable(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public static BatisPageable of(Integer size,Integer page){
        if(validate(size, page))return null;
        int offset = calculateOffset(size,page);
        return new BatisPageable(size,offset);
    }

    private static boolean validate(Integer size, Integer page) {
        return page <= 0 || size <= 0;
    }



    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }


    private static int calculateOffset(int size, int page) {
        return  (page - 1) * size;
    }
}
