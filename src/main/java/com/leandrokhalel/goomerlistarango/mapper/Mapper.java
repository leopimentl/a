package com.leandrokhalel.goomerlistarango.mapper;

public interface Mapper<T, S> {

    T map(S source);

}
