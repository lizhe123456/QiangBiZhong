/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.whmnrc.qiangbizhong.util;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.whmnrc.qiangbizhong.base.BaseResponse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonUtil {


    public static String createGsonString(Object object) {
        try {
            Gson gson = new Gson();
            String gsonString = gson.toJson(object);
            return gsonString;
        } catch (Exception e) {
            ToastUtils.showShort("数据解析失败");
            return "";
        }
    }


    public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
        try {
            Gson gson = new Gson();
            T t = gson.fromJson(gsonString, cls);
            return t;
        } catch (Exception e) {
            ToastUtils.showShort("数据解析失败");
            return null;
        }
    }

    public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
        try {
            Gson gson = new Gson();
            List<T> mList = new ArrayList<T>();
            JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();
            for (final JsonElement elem : array) {
                mList.add(gson.fromJson(elem, cls));
            }
            return mList;
        } catch (Exception e) {
            ToastUtils.showShort("数据解析失败");
            return new ArrayList<>();
        }
    }

    public static List<Map<String, Object>> changeGsonToListMaps(String gsonString) {
        List<Map<String, Object>> list = null;
        Gson gson = new Gson();
        list = gson.fromJson(gsonString,
                new TypeToken<List<Map<String, Object>>>() {
                }.getType());

        return list;
    }

    /**
     * 把modelA对象的属性值赋值给bClass对象的属性。
     *
     * @param modelA
     * @param bClass
     * @param <T>
     * @return
     */
    public static <A, T> T modelAconvertoB(A modelA, Class<T> bClass) {
        try {
            Gson gson = new Gson();
            String gsonA = gson.toJson(modelA);
            T instanceB = gson.fromJson(gsonA, bClass);
            return instanceB;
        } catch (Exception e) {
            return null;
        }
    }

    public static BaseResponse fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(BaseResponse.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public <T> String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(BaseResponse.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
