package com.dharmasun.data.remote;



import com.dharmasun.data.error.FailedResponseException;
import com.dharmasun.data.model.BaseResponse;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Braindigit
 * Created on 11/21/16.
 */

public class BaseResponseConverter extends Converter.Factory {

    @Override
    @SuppressWarnings("unchecked")
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Type baseResponseType = TypeToken.getParameterized(BaseResponse.class, type).getType();
        final Converter<ResponseBody, BaseResponse<?>> delegate =
                retrofit.nextResponseBodyConverter(this, baseResponseType, annotations);
        return new BaseResponseBodyConverter(delegate);
    }


    private static class BaseResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        final Converter<ResponseBody, BaseResponse<T>> delegate;

        BaseResponseBodyConverter(Converter<ResponseBody, BaseResponse<T>> delegate) {
            this.delegate = delegate;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            BaseResponse<T> response = delegate.convert(value);
            if (response == null)
                throw new IOException("BaseResponse == null");
            else if (response.getCode() == 200) {
                return response.getData();
            } else
                throw new FailedResponseException(response);
        }
    }
}
