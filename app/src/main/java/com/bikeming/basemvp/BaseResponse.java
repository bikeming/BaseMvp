package com.bikeming.basemvp;

/**
 * @ClassName: com.bikeming.basemvp
 * @Description:
 * @author: fjm
 * @date: 2019/8/23 15:31
 * @Version:1.0
 */
public class BaseResponse<T> {

    public int errorCode;

    public T data;

    public String errorMsg;

}
